package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.Pet;

public interface PetService {
	public void insertPet(Pet Pet);
	public void deletePet(int id);
	public void updatePet(Pet pet);
	public List<Pet> searchPetByWord( String word);
	public List<Pet> findAllPet();

}
