package com.assessment.dto;


import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private Long categoryId;
    private String categoryName;
}