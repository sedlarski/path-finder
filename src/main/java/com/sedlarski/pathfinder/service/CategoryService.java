package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.entity.Category;
import com.sedlarski.pathfinder.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    Category findCategoryByName(CategoryNameEnum name);
}
