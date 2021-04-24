package com.pet.store.service.impl;

import java.util.List;

import com.pet.store.dao.implement.ProductDAOImpl;
import com.pet.store.entity.Product;
import com.pet.store.service.ProductService;

public class ProductServiceImpl implements ProductService  {
	private ProductDAOImpl productDAO;
	
	public ProductServiceImpl() {
		productDAO = new ProductDAOImpl();
	}
	@Override
	public void insertProduct(Product product) {
		productDAO.insert(product);
		
		
	}

	@Override
	public void deleteProduct(int id) {
		productDAO.delete(id);
		
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.update(product);
		
	}

	@Override
	public List<Product> searchProductByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productDAO.listAll();
	}
	@Override
	public Product getElementById(int id) {
		return productDAO.getElementById(id);
	}

}
