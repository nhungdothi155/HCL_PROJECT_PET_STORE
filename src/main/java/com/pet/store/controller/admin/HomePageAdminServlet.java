package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Customer;
import com.pet.store.service.CustomerService;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class HomePageAdminServlet
 */
@WebServlet("/admin")
public class HomePageAdminServlet extends HttpServlet {
	private CustomerService cusService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageAdminServlet() {
    	cusService = new CustomerServiceImpl();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = cusService.getAllCustomers();
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("admin/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
