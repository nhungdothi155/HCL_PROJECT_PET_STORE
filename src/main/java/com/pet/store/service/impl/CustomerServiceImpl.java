package com.pet.store.service.impl;


import com.pet.store.dao.implement.CartDAOImpl;
import com.pet.store.dao.implement.CartItemDAOImpl;
import com.pet.store.dao.implement.CustomerDAOImpl;
import com.pet.store.dao.implement.OrderDAOImpl;
import com.pet.store.dao.implement.OrderProductDAOImpl;
import com.pet.store.dao.implement.ProductDAOImpl;
import com.pet.store.entity.Cart;
import com.pet.store.entity.CartItem;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;
import com.pet.store.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAOImpl cusDAO;
	private CartDAOImpl cartDAO;
	private ProductDAOImpl productDAO;
	private CartItemDAOImpl cartItemDAO;
	private OrderDAOImpl orderDAO;
	private OrderProductDAOImpl orderProductDAO;
	public CustomerServiceImpl() {
		cusDAO = new CustomerDAOImpl();
		cartDAO = new CartDAOImpl();
		productDAO = new ProductDAOImpl();
		cartItemDAO = new CartItemDAOImpl();
		orderDAO = new OrderDAOImpl();
		orderProductDAO = new OrderProductDAOImpl();
		
	}
	
	@Override
	public void signUp(Customer cus) {
		cusDAO.insert(cus);
		
	}

	

	@Override
	public void addCartForCustomer(int cusId) {
		Customer c = cusDAO.getElementById(cusId);
		if(c!=null) {
		Cart cart = new Cart(c);
		cartDAO.insert(cart);
		}
		
	}
	@Override
	public Cart findCartByCustomerId(int custId) {
		Cart cart = cartDAO.findCartByCustomerId(custId);
		return cart;
	}
	@Override
	public void addProductToCart(int cart_id, int product_id,int quantity) {
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
	public Order findOrderByCustomerId(int custId) {
		Order order = orderDAO.findOrderByCustomerId(custId);
		return order;
	}
	@Override
	public void addProductToOrder(int productId, int order_id, int quantity) {
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

}
