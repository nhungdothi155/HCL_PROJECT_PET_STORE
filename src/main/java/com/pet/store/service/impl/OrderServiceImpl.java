package com.pet.store.service.impl;

import java.util.List;

import com.pet.store.dao.implement.OrderDAOImpl;
import com.pet.store.entity.Order;
import com.pet.store.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDAOImpl orderDAO;
	
	public OrderServiceImpl() {
		orderDAO = new OrderDAOImpl();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insertOrder(Order Order) {
	orderDAO.insert(Order);
		
	}

	@Override
	public void deleteOrder(int id) {
		orderDAO.delete(id);
		
	}

	@Override
	public void updateOrder(Order Order) {
orderDAO.update(Order);		
	}

	@Override
	public List<Order> searchOrderByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllOrder() {
		return orderDAO.listAll();
	}

}
