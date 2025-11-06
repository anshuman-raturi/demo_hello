package com.cg.films.service.impl;

import com.cg.films.dto.CategoryDTO;
import com.cg.films.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    private CategoryRepository categoryRepository = null;

    public void CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryDTO(cat.getCategoryId(), cat.getName()))
                .toList();

        if (categories.isEmpty()) {
            throw new EntityNotFoundException("No categories available");
        }

        return categories;
    }
}