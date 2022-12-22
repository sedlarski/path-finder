package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.entity.Category;
import com.sedlarski.pathfinder.model.entity.enums.CategoryNameEnum;
import com.sedlarski.pathfinder.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryNameEnum name) {
        return categoryRepository.findByName(name.name()).orElse(null);
    }
}
