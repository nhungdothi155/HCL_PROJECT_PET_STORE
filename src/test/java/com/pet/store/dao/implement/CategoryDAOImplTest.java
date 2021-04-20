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
import com.pet.store.entity.Pet;
import com.pet.store.entity.Seller;

class CategoryDAOImplTest {
	private CategoryDAOImpl categoryDao;
	  
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new category dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		categoryDao = new CategoryDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}


	@Test
	void testDelete() {
		System.out.println("test delete");
		Integer id = 1;
		categoryDao.delete(id);
		Category category =  categoryDao.getElementById(id);
		Assertions.assertNull(category);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Category> categories = categoryDao.listAll();
		Assertions.assertFalse(categories.isEmpty());
	}

	@Test
	void testInsertCategory() {
		System.out.println("test insert");
		Category category = new Category();
		category.setCategoryName("hang moi ve");
		int n =categoryDao.insert(category);
		Assertions.assertTrue(n>0);
		
	}

	@Test
	void testUpdateCategory() {
		System.out.println("test update");
		Integer id = 1;
		Category category = categoryDao.getElementById(id);
		String name = "hang";
		category.setCategoryName(name);
		Category findCategory = categoryDao.getElementById(id);
		Assertions.assertEquals(findCategory.getClass(), name);
		
		
	}

	@Test
	void testGetElementByIdLong() {
		System.out.println("test get element by id");
		Integer id = 1;
		Category cat = categoryDao.getElementById(id);
		Assertions.assertNotNull(cat);
	}

}
