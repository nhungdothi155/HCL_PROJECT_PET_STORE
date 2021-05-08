package com.pet.store.service.impl;


import java.util.List;

import com.pet.store.dao.implement.CartDAOImpl;
import com.pet.store.dao.implement.CartItemDAOImpl;
import com.pet.store.dao.implement.CustomerDAOImpl;
import com.pet.store.dao.implement.OrderDAOImpl;
import com.pet.store.dao.implement.OrderProductDAOImpl;
import com.pet.store.dao.implement.ProductDAOImpl;
import com.pet.store.dao.implement.SellerDAOImpl;
import com.pet.store.entity.Cart;
import com.pet.store.entity.CartItem;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;
import com.pet.store.entity.Seller;
import com.pet.store.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAOImpl cusDAO;
	private CartDAOImpl cartDAO;
	private ProductDAOImpl productDAO;
	private CartItemDAOImpl cartItemDAO;
	private OrderDAOImpl orderDAO;
	private OrderProductDAOImpl orderProductDAO;
	private SellerDAOImpl sellerDao;
	public CustomerServiceImpl() {
		cusDAO = new CustomerDAOImpl();
		cartDAO = new CartDAOImpl();
		productDAO = new ProductDAOImpl();
		cartItemDAO = new CartItemDAOImpl();
		orderDAO = new OrderDAOImpl();
		orderProductDAO = new OrderProductDAOImpl();
		sellerDao = new SellerDAOImpl();
		
	}
	
	@Override
	public void signUp(Customer cus) {
		cusDAO.insert(cus);
		
	}

	

	@Override
	public void addCartForCustomer(long cusId) {
		Customer c = cusDAO.getElementById(cusId);
		Cart cart = cartDAO.findCartByCustomerId(cusId);
		if(c!=null && cart==null) {
		Cart newcart = new Cart(c);
		cartDAO.insert(newcart);
		}
		
	}
	@Override
	public Cart findCartByCustomerId(long custId) {
		Cart cart = cartDAO.findCartByCustomerId(custId);
		return cart;
	}
	@Override
	public void addProductToCart(long cart_id, long product_id,int quantity) {
		Cart c = cartDAO.getElementById(cart_id);
		Product p = productDAO.getElementById(product_id);
		CartItem cp = new CartItem(c,p,quantity);
		cartItemDAO.insert(cp);
		
		
		
	}
	@Override
	public void addOrder(Order order) {
		orderDAO.insert(order);
		
		
	}
	@Override
	public Order findOrderByCustomerId(long custId) {
		Order order = orderDAO.findOrderByCustomerId(custId);
		return order;
	}
	@Override
	public void addProductToOrder(long productId, long order_id, int quantity) {
		
		Product product = productDAO.getElementById(productId);
		Order order = orderDAO.getElementById(order_id);
		
		
		OrderProduct op = new OrderProduct(product, order, quantity);
		orderProductDAO.insert(op);
	
		
	}

	@Override
	public Customer signIn(String username, String password) {
		Customer cus = cusDAO.isLogin(username, password);
		
		return cus;
	}

	@Override
	public Seller signInAdmin(String username, String password) {
		Seller seller = sellerDao.isLogin(username, password);
		return seller;
	}

	@Override
	public Customer getCustomerById(long id) {
	    return cusDAO.getElementById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return cusDAO.listAll();
		// TODO Auto-generated method stub
		
	}

}
