package com.pet.store.dao;

import java.util.List;

import com.pet.store.entity.Category;

public interface CategoryDAO {

	public Category getSubCategory(String categoryName, String subCategory);
	public List<Category> getCategoryByName(String categoryName);
	
}