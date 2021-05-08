package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.OrderProduct;

public interface OrderProductService {
	public List<OrderProduct> getAllOrderProduct();
	public List<OrderProduct> getOrderProductByCustomerId(long id);

}
