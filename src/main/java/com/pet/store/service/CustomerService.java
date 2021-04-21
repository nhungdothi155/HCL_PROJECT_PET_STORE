package com.pet.store.service;

import com.pet.store.entity.Customer;

public interface CustomerService {
	public void signUp(Customer cus);
	public boolean signIn(String username, String password);
	public void addProductToCart();
	public void addOrder();
	
	


}
