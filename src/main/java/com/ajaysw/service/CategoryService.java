package com.ajaysw.service;

import com.ajaysw.model.Category;
import com.ajaysw.payload.CategoryDTO;
import com.ajaysw.payload.CategoryResponse;

public interface CategoryService {

    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);

}
