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
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;

class OrderDAOImplTest {
	private OrderDAOImpl orderDAO;
	private CustomerDAOImpl cusDAO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new custoerm dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		cusDAO = new CustomerDAOImpl();
		orderDAO = new OrderDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}


	@Test
	void testDelete() {
		System.out.println("test delete");
		Integer id = 1;
		orderDAO.delete(id);
		Order order =  orderDAO.getElementById(id);
		Assertions.assertNull(order);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Order> orders = orderDAO.listAll();
		Assertions.assertFalse(orders.isEmpty());
	}

	@Test
	void testInsertOrder() {
		System.out.println("test insert");
		Integer id = 1;
		Customer customer = cusDAO.getElementById(id);
		Order order = new Order(customer,34,"nhung","do","hanoi","ha tay","xon 2","thidonhung","zipcode","nothing","nothing");
		int n = orderDAO.insert(order);
		Assertions.assertTrue(n>0);
		
		
	}

	@Test
	void testUpdateOrder() {
		System.out.println("test update");
		Integer id = 1;
		Order order = orderDAO.getElementById(id);
		String note="new changes";
		order.setNote(note);
		orderDAO.update(order);
		Order updateOrder = orderDAO.getElementById(id);
		Assertions.assertEquals(updateOrder.getNote(),note);
	}
	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		Order order = orderDAO.getElementById(id);
		Assertions.assertNotNull(order);
	}

}
