package com.pet.store.controller.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.service.CustomerService;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class HomePageCustomerServlet
 */
@WebServlet("/customer")
public class HomePageCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService cusService;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		cusService = new CustomerServiceImpl();
	}
    public HomePageCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flag = cusService.signIn(username, password);
		if(flag) {
			//create new request 
			RequestDispatcher rq= request.getRequestDispatcher("homepage.jsp");
			//forward to this page
			rq.forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").include(request, response);
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
