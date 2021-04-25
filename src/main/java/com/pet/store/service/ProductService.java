package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.Product;

public interface ProductService {
	public void insertProduct(Product product);
	public void deleteProduct(int id);
	public void updateProduct(Product product);
	public List<Product> searchProductByNameOrType( String name);
	public List<Product> findAllProduct();
	public Product getElementById(int id);
	
	

}
