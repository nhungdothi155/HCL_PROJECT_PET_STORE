package com.pet.store.service.impl;

import java.util.List;

import com.pet.store.dao.implement.PetDAOImpl;
import com.pet.store.entity.Pet;
import com.pet.store.service.PetService;

public class PetServiceImpl implements PetService {
	private PetDAOImpl petDAO;
	public PetServiceImpl() {
		petDAO = new PetDAOImpl();
		
	}
	@Override
	public void insertPet(Pet Pet) {
		petDAO.insert(Pet);
		
		
	}

	@Override
	public void deletePet(int id) {
		petDAO.delete(id);
		
	}

	@Override
	public void updatePet(Pet pet) {
		petDAO.update(pet);
		
	}

	@Override
	public List<Pet> searchPetByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> findAllPet() {
		return petDAO.listAll();
		
	}

}
