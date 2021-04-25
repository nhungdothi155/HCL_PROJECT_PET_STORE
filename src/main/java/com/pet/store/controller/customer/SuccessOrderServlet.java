package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.entity.Product;
import com.pet.store.service.impl.CartItemServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;
import com.pet.store.service.impl.OrderServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class SuccessOrderServlet
 */
@WebServlet("/success")
public class SuccessOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
	private OrderServiceImpl orderService;
	private CartItemServiceImpl cartItemService;
	private ProductServiceImpl productService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		customerService = new CustomerServiceImpl();
		orderService = new OrderServiceImpl();
		cartItemService = new CartItemServiceImpl();
		productService = new ProductServiceImpl();
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
		// get list cartItems
//		List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("orders");
		String[] cartItemIds = request.getParameterValues("id");
		String[] cartIds = request.getParameterValues("cartId");
		String[] productIds = request.getParameterValues("productId");
		String[] quantity = request.getParameterValues("quantity");

		String address = request.getParameter("address");
		String email = request.getParameter("email");

		// get cusotmer id
		long customerId = Long.parseLong(request.getSession().getAttribute("customerId").toString());
		// create new order
		Order o = new Order();
		// get customer by id
		Customer c = customerService.getCustomerById(customerId);

		o.setCustomer(c);
        o.setCustomerAddress(address);
        o.setCustomerEmail(email);
		// insert customer in id
		orderService.insertOrder(o);
		Order order = customerService.findOrderByCustomerId(customerId);
		System.out.println(order.getOrderId());
		for (int i = 0; i < cartIds.length; i++) {
			// add product to order
			customerService.addProductToOrder(Long.parseLong(productIds[i]), order.getOrderId(),
					Integer.parseInt(quantity[i]));
			// delte product in the cart
			cartItemService.deleteCartItem(Long.parseLong(cartItemIds[i]));

		}
		List<Product> products = productService.findAllProduct();

		// create new request
		request.setAttribute("products", products);

		request.getRequestDispatcher("homepage.jsp").forward(request, response);

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
