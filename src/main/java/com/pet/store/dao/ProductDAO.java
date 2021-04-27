package com.pet.store.dao;

import java.util.List;

import com.pet.store.entity.Product;

public interface ProductDAO {
	public List<Product> searchProductByWords(String word);
	public List<Product> searchProductByRequire(String search, String require);
	public List<Product> searchProductByCategoryName(String categoryName);
	public List<Product> searchProductByCategoryNameAndSubCategory(String categoryName, String subCategoryName) ;

}
