package com.pet.store.dao;

import com.pet.store.entity.Cart;
import com.pet.store.entity.Order;
import com.pet.store.entity.Customer;

public interface CustomerDAO {
	public Customer isLogin(String username, String password);
	


}
