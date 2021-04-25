package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.store.entity.Customer;
import com.pet.store.entity.Product;
import com.pet.store.service.impl.CustomerServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class HomePageCustomerServlet
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerServiceImpl cusService;
	private ProductServiceImpl productService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		cusService = new CustomerServiceImpl();
		productService = new ProductServiceImpl();
	}

	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer cus = cusService.signIn(username, password);
		if (cus != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customerId", cus.getId());
		}

		List<Product> products = new ArrayList<Product>();
		if (request.getParameter("search") != null && request.getParameter("orderby")==null) {
			String search = request.getParameter("search");
			request.setAttribute("search", search);
			products = productService.searchProductByNameOrType(search);

		} 
		else if( request.getParameter("orderby")!=null && request.getParameter("search") != null) {
			String search = request.getParameter("search");
			String require = request.getParameter("orderby");
			request.setAttribute("search", search);
			products = productService.searchProductByRequire(search,require);
			
		}
		else {
			products = productService.findAllProduct();
		}
		// create new request
		request.setAttribute("products", products);

		// forward to this page
		RequestDispatcher rq = request.getRequestDispatcher("homepage.jsp");
		rq.forward(request, response);

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
