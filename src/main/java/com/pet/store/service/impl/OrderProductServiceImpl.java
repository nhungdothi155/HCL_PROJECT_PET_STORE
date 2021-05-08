package com.pet.store.service.impl;

import java.util.List;

import com.pet.store.dao.OrderProductDAO;
import com.pet.store.dao.implement.OrderProductDAOImpl;
import com.pet.store.entity.OrderProduct;
import com.pet.store.service.OrderProductService;


public class OrderProductServiceImpl implements OrderProductService {
	private OrderProductDAOImpl opDAO;
	public OrderProductServiceImpl() {
		// TODO Auto-generated constructor stb
		opDAO = new OrderProductDAOImpl();
	}

	@Override
	public List<OrderProduct> getAllOrderProduct() {
		return opDAO.listAll();
		
		
	}

	@Override
	public List<OrderProduct> getOrderProductByCustomerId(long id) {
		// TODO Auto-generated method stub
		return opDAO.getOrderProductByCustomerId(id);
	}

}
