package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.CartItem;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.service.impl.CartItemServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;
import com.pet.store.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class SuccessOrderServlet
 */
@WebServlet("/success")
public class SuccessOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
    private OrderServiceImpl orderService;
    private CartItemServiceImpl cartItemService;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		customerService = new CustomerServiceImpl();
		orderService = new OrderServiceImpl();
      cartItemService = new CartItemServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("orders");
		long id = Long.parseLong( request.getSession().getAttribute("customerId").toString());
		Order o = new Order();
		Customer c = customerService.getCustomerById(id);
		o.setCustomer(c);

		orderService.insertOrder(o);
		Order order = customerService.findOrderByCustomerId(id);
		for(CartItem cartItem : cartItems) {
			customerService.addProductToOrder(cartItem.getProduct().getProductId(), order.getOrderId(), cartItem.getQuantity());
			cartItemService.deleteCartItem(cartItem.getCartItemId());
			
		    
			
			
		}

		request.getRequestDispatcher("afterOrder.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
