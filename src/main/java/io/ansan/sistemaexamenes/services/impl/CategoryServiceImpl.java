package io.ansan.sistemaexamenes.services.impl;

import io.ansan.sistemaexamenes.entity.Category;
import io.ansan.sistemaexamenes.repository.CategoryRepo;
import io.ansan.sistemaexamenes.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteCategory(Long id) {
		Category category = new Category();
		category.setCategoryId(id);
		categoryRepo.delete(category);
	}
}