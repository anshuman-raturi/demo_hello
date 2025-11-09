package com.cg.films.service;

import com.cg.films.dto.CategoryDTO;
import com.cg.films.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryDTO(cat.getCategoryId(), cat.getName()))
                .toList();
    }
}
