package com.ajaysw.service;

import com.ajaysw.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    String createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Long categoryId, Category category);

}
