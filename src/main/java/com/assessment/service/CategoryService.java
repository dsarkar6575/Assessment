package com.assessment.service;


import org.springframework.data.domain.Page;

import com.assessment.dto.CategoryDto;

public interface CategoryService {
    Page<CategoryDto> getAllCategories(int page);
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}