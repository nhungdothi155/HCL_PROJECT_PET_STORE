package com.pet.store.service.impl;


import com.pet.store.dao.implement.CustomerDAOImpl;
import com.pet.store.entity.Customer;
import com.pet.store.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAOImpl cusDAO;
	public CustomerServiceImpl() {
		cusDAO = new CustomerDAOImpl();
	}
	@Override
	public void signUp(Customer cus) {
		cusDAO.insert(cus);
		
	}

	@Override
	public boolean signIn(String username,String password) {
		return cusDAO.isLogin(username, password);
		
	}

	@Override
	public void addProductToCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrder() {
		// TODO Auto-generated method stub
		
	}

}
