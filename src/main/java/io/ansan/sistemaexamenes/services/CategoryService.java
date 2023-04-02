package io.ansan.sistemaexamenes.services;

import io.ansan.sistemaexamenes.entity.Category;

import java.util.Set;

public interface CategoryService {
  Category addCategory(Category category);

  Category updateCategory(Category category);

  Set<Category> getCategories();

  Category getCategory(Long id);

  void deleteCategory(Long id);
}