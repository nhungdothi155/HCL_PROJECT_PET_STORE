package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Category;
import com.pet.store.entity.Order;
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;

class OrderProductDAOImplTest {
	private OrderProductDAOImpl orderProductDAO;
	private ProductDAOImpl productDAO;
	private OrderDAOImpl orderDAO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new custoerm dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {

		orderDAO = new OrderDAOImpl();
		productDAO = new ProductDAOImpl();
		orderProductDAO = new OrderProductDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}


	@Test
	void testDelete() {
		System.out.println("test delete");
		Integer id = 1;
		orderProductDAO.delete(id);
		OrderProduct orderProduct =  orderProductDAO.getElementById(id);
		Assertions.assertNull(orderProduct);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<OrderProduct> orderProducts = orderProductDAO.listAll();
		Assertions.assertFalse(orderProducts.isEmpty());
	}

	@Test
	void testInsertOrderProduct() {
		Integer id =1;
		Product product = productDAO.getElementById(3);
		Order order = orderDAO.getElementById(id);
		OrderProduct orderProduct = new OrderProduct(product, order,2);
		int n = orderProductDAO.insert(orderProduct);
		Assertions.assertTrue(n>0);
		
	}

	@Test
	void testUpdateOrderProduct() {
		System.out.println("test update");
		Integer id = 1;
		OrderProduct orderProduct = orderProductDAO.getElementById(id);
		int quantity = 5;
		orderProduct.setOrderProductNumber(quantity);
		OrderProduct findOrderProduct = orderProductDAO.getElementById(id);
		Assertions.assertEquals(findOrderProduct.getOrderProductNumber(), quantity);
			}

	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		OrderProduct orderProduct = orderProductDAO.getElementById(id);
		Assertions.assertNotNull(orderProduct);
	}

}
