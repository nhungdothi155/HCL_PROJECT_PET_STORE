package com.pet.store.dao;

import com.pet.store.entity.OrderProduct;

public interface OrderProductDAO {
	public OrderProduct getElementByProductId(long productId);

}
