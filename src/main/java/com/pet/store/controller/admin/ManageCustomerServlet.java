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
@WebServlet(urlPatterns = {"/admin/customer","/admin/logout"})
public class ManageCustomerServlet extends HttpServlet {
	private CustomerService cusService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCustomerServlet() {
    	cusService = new CustomerServiceImpl();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getRequestURL().toString();
		if(action.contains("/admin/customer")) {
			List<Customer> customers = cusService.getAllCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("/admin/customer.jsp").forward(request, response);
		}
		else if(action.contains("/admin/logout")) {
			request.getSession().removeAttribute("adminId");
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
