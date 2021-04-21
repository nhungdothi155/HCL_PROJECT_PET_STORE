package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Cart;
import com.pet.store.entity.CartItem;
import com.pet.store.entity.Product;

class CartItemDAOImplTest {
	private CartDAOImpl cartDao;
	private CartItemDAOImpl cartItemDao;
	private ProductDAOImpl productDao;
	  
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
		cartItemDao = new CartItemDAOImpl();
		productDao = new ProductDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	void testDelete() {
		System.out.println("test delete");
		Integer id = 1;
		cartItemDao.delete(id);
		CartItem cartItem =  cartItemDao.getElementById(id);
		Assertions.assertNull(cartItem);
		
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<CartItem> cartItems = cartItemDao.listAll();
		Assertions.assertFalse(cartItems.isEmpty());
	}

	@Test
	void testInsertCartItem() {
		Integer id = 1;
		Cart cart = cartDao.getElementById(id);
		Product product = productDao.getElementById(id);
		CartItem cartItem = new CartItem(cart, product, 4);
		int n =cartItemDao.insert(cartItem);
		Assertions.assertTrue(n>0);
		
	}

	@Test
	void testUpdateCartItem() {
		Integer id =1;
		CartItem cartItem = cartItemDao.getElementById(id);
		cartItem.setQuantity(54);
		cartItemDao.update(cartItem);
		CartItem findcartItem = cartItemDao.getElementById(id);
		Assertions.assertEquals(findcartItem.getQuantity(), 54);
	}

	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		CartItem cartItem = cartItemDao.getElementById(id);
		Assertions.assertNotNull(cartItem);

	}

}
