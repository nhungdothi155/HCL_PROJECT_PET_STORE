package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Category;
import com.pet.store.entity.Product;
import com.pet.store.service.impl.CategoryServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class HomePageCustomerServlet
 */
@WebServlet(urlPatterns = { "/home", "/home/contact", "/home/*" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerServiceImpl cusService;
	private ProductServiceImpl productService;
	private CategoryServiceImpl categoryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		cusService = new CustomerServiceImpl();
		productService = new ProductServiceImpl();
		categoryService = new CategoryServiceImpl();
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


		String actionR = request.getRequestURI().substring((request.getContextPath() + "/home").length());
		String action = actionR;
		if (actionR.length() > 0) {
			action = actionR.substring(1);
		}

		if (action.equals("contact")) {
			showContactPage(request, response);
		}
		if (action.length() > 0 && !action.equals("contact") && request.getParameter("search") == null) {

			showListProductByCategory(request, response);

		}
		if (!action.equals("contact") && request.getParameter("search") != null) {
			System.out.println("k");

			showListProductSearch(request, response);
		}

		else {
			showCustomerPage(request, response);
		}

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

	public void showListProductByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// find the action of page
		String actionR = request.getRequestURI().substring((request.getContextPath() + "/home").length());
		String action = actionR;
		if (actionR.length() > 0) {
			action = actionR.substring(1);
		}
	
		int page = 1;
		int recordsPerPage = 25;
		// if pagnition !=null
		String require = "feature";
		if (request.getParameter("orderby") != null) {
		
			require = request.getParameter("orderby").toLowerCase();
		}
		if (request.getParameter("page") != null || request.getParameter("page") == "") {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println(action + require + "134" );
		
			
		List<Product> products = productService.searchProductByNameOrType(action,require, page - 1, recordsPerPage);
		List<Product> allProducts = productService.searchProductByNameOrType(action);
		System.out.println(products.size());
		int noOfPages = (int) Math.ceil(allProducts.size() * 1.0 / recordsPerPage);
		// set value need for pagination
		request.setAttribute("orderby", require);
		request.setAttribute("category", action);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/customer/categoryPage.jsp").forward(request, response);
	}

	public void showListProductSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set the variable
		String search = request.getParameter("search").toLowerCase();
		String require = "feature";
		if (request.getParameter("orderby") != null) {
			System.out.println(require);
			require = request.getParameter("orderby").toLowerCase();
		}

		// defautl pagenition
		int page = 1;
		int recordsPerPage = 25;
		// if pagnition !=null
		if (request.getParameter("page") != null || request.getParameter("page") == "") {
			page = Integer.parseInt(request.getParameter("page"));
		}
		// find all the product
		List<Product> products = productService.searchProductByRequire(search, require, page - 1, recordsPerPage);
		System.out.println(products.size() + "productsize");
		List<Product> allProducts = productService.searchProductByRequire(search, require);

		System.out.println(allProducts.size());
		int noOfPages = (int) Math.ceil(allProducts.size() * 1.0 / recordsPerPage);
		// set value need for pagination

		request.setAttribute("search", search);
		request.setAttribute("orderby", require);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/customer/searchPage.jsp").forward(request, response);
	}

	public void showContactPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/customer/contact.jsp").forward(request, response);
	}

	public void showCustomerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int limit = 12;
		List<Product> dogs = productService.searchProductByNameOrType("dog", limit);

		request.setAttribute("dogs", dogs);
		List<Product> cats = productService.searchProductByNameOrType("cat", limit);
		request.setAttribute("cats", cats);
		List<Product> acs = productService.searchProductByNameOrType("accessories", limit);
		request.setAttribute("acs", acs);
		// forward to this page
		RequestDispatcher rq = request.getRequestDispatcher("/customer/index.jsp");
		rq.forward(request, response);
	}
	// show

}
