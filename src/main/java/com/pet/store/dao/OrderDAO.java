package com.pet.store.dao;

import com.pet.store.entity.Order;

public interface OrderDAO {
	public Order findOrderByCustomerId(long custId) ;

}
