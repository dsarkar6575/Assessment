package com.assessment.service;


import org.springframework.data.domain.Page;

import com.assessment.dto.ProductDto;

public interface ProductService {
    Page<ProductDto> getAllProducts(int page);
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
}
