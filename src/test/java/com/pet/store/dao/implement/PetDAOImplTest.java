package com.pet.store.dao.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pet.store.entity.Pet;
import com.pet.store.entity.Product;
import com.pet.store.entity.State;
import com.pet.store.entity.Status;

class PetDAOImplTest {
	private PetDAOImpl petDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	System.out.println("create new product dao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		petDao = new PetDAOImpl();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}



	@Test
	void testDelete() {
		System.out.println("test delete");
		int id = 1;
		petDao.delete(id);
		Pet product = (Pet) petDao.getElementById(id);
		Assertions.assertNull(product);
	}

	@Test
	void testListAll() {
		System.out.println("test list");
		List<Pet> products = petDao.listAll();
		Assertions.assertFalse(products.isEmpty());
	}

	@Test
	void testInsertPet() {
		System.out.println("test insert");
		 Pet pet = new Pet("Tomy",4,4.3,"Normal","thailand",Status.IN_STOCK,"https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg","ngoan va hien");
		 int  n = petDao.insert(pet);
		 Assertions.assertTrue(n>0);
	}

	@Test
	void testUpdatePet() {
		System.out.println("test update product");
		Integer id = 1;
		//Pet pet = new Pet(1,"Tomy",4,4.3,"Normal","vietname",Status.IN_STOCK,"https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg","ngoan va hien cung voi de thuong");
		Pet pet = petDao.getElementById(id);
		String name = "Tommyyyyyy";
		pet.setPetName(name);
		petDao.update(pet);
		Pet findPet = petDao.getElementById(id);
		Assertions.assertEquals( findPet.getPetName(),name);
	}

	@Test
	void testGetElementByIdInt() {
		System.out.println("test get element by id");
		Integer id = 1;
		
		Pet  pet = petDao.getElementById(id);
		Assertions.assertNotNull(pet);
	}

}
