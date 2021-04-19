package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Product;
import com.pet.store.entity.Seller;

class ProductDAOImplTest {
	private ProductDAOImpl productDao;
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
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}


	@Test
	void testDelete() {
		System.out.println("test delete");
		int id = 1;
		Product product = (Product) productDao.getElementById(id);
		productDao.delete(id);
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
		 Product product = new Product();
		 productDao.insert(product);
		 Product findProduct =productDao.getElementById(product.getProductId());
		 Assertions.assertNotNull(findProduct);
	}

	@Test
	void testUpdateProduct() {
		System.out.println("test update product");
		Integer id = 1;
		Product product = new Product();
		Product findProduct = productDao.getElementById(id);
		Assertions.assertNotEquals(product, findProduct,"update successfully");
	}

	@Test
	void testGetElementByIdInt() {
		System.out.println("test get element by id");
	Integer id = 1;
	Product  product = productDao.getElementById(id);
	Assertions.assertNotNull(product);
	}

}
