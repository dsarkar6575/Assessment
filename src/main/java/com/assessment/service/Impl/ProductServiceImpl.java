package com.assessment.service.Impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assessment.dto.ProductDto;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.model.Category;
import com.assessment.model.Product;
import com.assessment.repository.CategoryRepo;
import com.assessment.repository.ProductRepo;
import com.assessment.service.ProductService;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepository;
    private final CategoryRepo categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<ProductDto> getAllProducts(int page) {
        Pageable pageable = PageRequest.of(page, 5); // 5 items per page
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            if (product.getCategory() != null) {
                productDto.setCategoryId(product.getCategory().getId());
                productDto.setCategoryName(product.getCategory().getName());
            }
            return productDto;
        });
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        if (product.getCategory() != null) {
            productDto.setCategoryId(product.getCategory().getId());
            productDto.setCategoryName(product.getCategory().getName());
        }
        return productDto;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        
        if (productDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + productDto.getCategoryId()));
            product.setCategory(category);
        }
        
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        
        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        
        if (productDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + productDto.getCategoryId()));
            existingProduct.setCategory(category);
        } else {
            existingProduct.setCategory(null);
        }
        
        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }
}