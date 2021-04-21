package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.Order;

public interface OrderService {
	public void insertOrder(Order Order);
	public void deleteOrder(int id);
	public void updateOrder(Order Order);
	public List<Order> searchOrderByWord( String word);
	public List<Order> findAllOrder();

}
