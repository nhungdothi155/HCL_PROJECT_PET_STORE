package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Cart;
import com.pet.store.entity.Customer;

class CartDAOImplTest {
	private CartDAOImpl cartDao;
	private CustomerDAOImpl cusDao;
	private 
	  
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new category dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		cartDao = new CartDAOImpl();
		cusDao = new CustomerDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	void testDelete() {
		System.out.println("test delete");
		Integer id = 1;
		cartDao.delete(id);
		Cart cart =  cartDao.getElementById(id);
		Assertions.assertNull(cart);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Cart> carts = cartDao.listAll();
		Assertions.assertFalse(carts.isEmpty());
	}

	@Test
	void testInsertCart() {
		Integer id = 1;
		Customer customer = cusDao.getElementById(id);
		Cart cart = new Cart(customer);
		int n = cartDao.insert(cart);
		Assertions.assertTrue(n>0);
		
	}

	@Test
	void testUpdateCart() {
		
		boolean flag = false;
		// not implement this method
		Assertions.assertFalse(flag);
	}

	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		Cart cart = cartDao.getElementById(id);
		Assertions.assertNotNull(cart);
	}

}
