package com.pet.store.service.impl;

import java.util.List;

import com.pet.store.dao.implement.CategoryDAOImpl;
import com.pet.store.entity.Category;
import com.pet.store.entity.Product;
import com.pet.store.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAOImpl catDAO;
	public CategoryServiceImpl() {
		catDAO = new CategoryDAOImpl();
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Category> getAllCategories() {
		return catDAO.listAll();
	}

	@Override
	public List<Category> getCategoriesByName(String name){
		return catDAO.getCategoryByName(name);
		
	}

	@Override
	public void insertCategory(Category category) {
		catDAO.insert(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		catDAO.update(category);
		
	}

	@Override
	public void deleteCategory(int id) {
		catDAO.delete(id);
	}

}
