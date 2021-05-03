package com.pet.store.dao;

import java.util.List;

import com.pet.store.entity.OrderProduct;

public interface OrderProductDAO {
	public OrderProduct getElementByProductId(long productId);
	

}
