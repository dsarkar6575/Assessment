package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
