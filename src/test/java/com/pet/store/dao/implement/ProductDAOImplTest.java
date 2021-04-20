package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.dao.implement.CategoryDAOImpl;
import com.pet.store.dao.implement.ProductDAOImpl;
import com.pet.store.entity.Category;
import com.pet.store.entity.Product;
import com.pet.store.entity.Seller;
import com.pet.store.entity.State;

class ProductDAOImplTest {
	private ProductDAOImpl productDao;
	private CategoryDAOImpl categoryDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new product dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDAOImpl();
		categoryDao = new CategoryDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}


	@Test
	void testDelete() {
		System.out.println("test delete");
		int id = 1;
		productDao.delete(id);
		Product product = (Product) productDao.getElementById(id);
		Assertions.assertNull(product);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Product> products = productDao.listAll();
		Assertions.assertFalse(products.isEmpty());
	}

	@Test
	void testInsertProduct() {
		System.out.println("test insert");
		int id =1;
		 Category category = categoryDao.getElementById(id);
		 Product product = new Product(category,"Dây đeo cổ","dài","no brand","vải","việt name",2000,"https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg",State.USED);
		 int n = productDao.insert(product);
		 Assertions.assertTrue(n>0);
	}

	@Test
	void testUpdateProduct() {
		System.out.println("test update product");
		Integer id = 1;
//		Category category = categoryDao.getElementById(id);
		//Product product = new Product(category,"Dây đeo cổ","dài","no brand","vải","việt name",2000,"https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg",State.NEW);
		Product product = productDao.getElementById(id);
		String updateBrand="hello";
		product.setBrand(updateBrand);
		productDao.update(product);
		Product findProduct = productDao.getElementById(id);
		Assertions.assertEquals(findProduct.getBrand(),updateBrand,"update successfully");
	}
	

	@Test
	void testGetElementByIdInt() {
		System.out.println("test get element by id");
	Integer id = 1;
	
	Product  product = productDao.getElementById(id);
	Assertions.assertNotNull(product);
	}

}

