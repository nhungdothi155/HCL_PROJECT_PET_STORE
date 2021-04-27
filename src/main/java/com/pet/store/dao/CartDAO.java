package com.pet.store.dao;

import com.pet.store.entity.Cart;

public interface CartDAO {
	public Cart findCartByCustomerId(long custId);

}
