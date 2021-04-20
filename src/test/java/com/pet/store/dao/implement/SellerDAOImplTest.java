package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.pet.store.entity.Seller;

class SellerDAOImplTest {
	private SellerDAOImpl sellerDao;
  
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new seller dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		sellerDao = new SellerDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	void testDelete() {
		System.out.println("test delete");
		int id = 1;
		sellerDao.delete(id);
		Seller seller = (Seller) sellerDao.getElementById(id);
		Assertions.assertNull(seller);
	}

	@Test
	void testIsLogin() {
		System.out.println("test login");
		boolean flagTrue= sellerDao.isLogin("admin","admin");
		boolean flagFalse = sellerDao.isLogin("sd", "dsfs");
		
		Assertions.assertTrue(flagTrue);
		Assertions.assertFalse(flagFalse);
		
		
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Seller> sellers = sellerDao.listAll();
		Assertions.assertFalse(sellers.isEmpty());
		
	}

	@Test
	void testInsertSeller() {
		System.out.println("test insert");
	 Seller seller = new Seller("admin1","admin1");
	int n= sellerDao.insert(seller);
	Assertions.assertTrue(n>0);
	
	}

	@Test
	void testUpdateSeller() {
		Integer id = 1;
		Seller seller = new Seller(id, "admin1","admin1change");
		sellerDao.update(seller);
		Seller findSeller = sellerDao.getElementById(id);
		Assertions.assertEquals(seller.getPassword(),findSeller.getPassword(), "Change password successfully");
		
	}

	@Test
	void testGetElementByIdInt() {
		Integer id = 1;
		Seller seller = sellerDao.getElementById(id);
		Assertions.assertNotNull(seller);
	}

}
