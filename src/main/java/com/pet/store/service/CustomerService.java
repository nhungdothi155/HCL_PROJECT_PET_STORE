package com.pet.store.service;

import com.pet.store.entity.Cart;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;

public interface CustomerService {
	public void signUp(Customer cus);
	public Customer signIn(String username, String password);
	public void addCartForCustomer(int cusId);
	public Cart findCartByCustomerId(int custId);
	public void addProductToCart(int cart_id, int product_id,int quantity);
	
	public void addOrder(Order order);
	public Order findOrderByCustomerId(int custId);
	public void addProductToOrder(int productId, int order_id,int quantiy);
	
	
	


}
