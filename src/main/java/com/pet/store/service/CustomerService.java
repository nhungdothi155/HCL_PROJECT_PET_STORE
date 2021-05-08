
package com.pet.store.service;

import java.util.List;

import com.pet.store.entity.Cart;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.entity.Seller;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public void signUp(Customer cus);
	public Customer signIn(String username, String password);
	public Seller signInAdmin(String username, String password);
	public void addCartForCustomer(long cusId);
	public Cart findCartByCustomerId(long custId);
	public void addProductToCart(long cart_id, long product_id,int quantity);
	
	public void addOrder(Order order);
	public Order findOrderByCustomerId(long custId);
	public void addProductToOrder(long productId, long order_id,int quantiy);
	public Customer getCustomerById(long id);
	
	
	


}
