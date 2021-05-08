package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Customer;
import com.pet.store.entity.Pet;

class CustomerDAOImplTest {
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
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	void testDelete() {
		System.out.println("test delete");
		int id = 1;
		cusDAO.delete(id);
		Customer customer = cusDAO.getElementById(id);
		Assertions.assertNull(customer);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Customer> customers = cusDAO.listAll();
		Assertions.assertFalse(customers.isEmpty());
	}

	@Test
	void testInsertCustomer() {
		System.out.println("test insert");
	
		Customer cus = new Customer("nhung","do","r23423","hanoi","09345345","nhung","nhung");
		int n = cusDAO.insert(cus);
		Assertions.assertTrue(n>0);
	}

	@Test
	void testUpdateCustomer() {
		System.out.println("test update customer");
		Integer id = 1;
		Customer cus = cusDAO.getElementById(id);
		String address = "address new";
		cus.setAddress(address);
		cusDAO.update(cus);
		Customer findCus = cusDAO.getElementById(id);
		
		Assertions.assertEquals(findCus.getAddress(),address );
	}

	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		
	Customer customer = cusDAO.getElementById(id);
		Assertions.assertNotNull(customer);
	}

}
