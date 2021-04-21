package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.Category;
import com.pet.store.entity.Product;

public interface CategoryService {
	public List<Category> getAllCategories();
	public List<Product> getProductsInCategory();
	public void insertCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(int id);
	

}
