package com.pet.store.controller.customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.store.entity.Customer;
import com.pet.store.service.CustomerService;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/login", "/logout", "/signUp", "/isSign","/loginSuccess" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		customerService = new CustomerServiceImpl();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get login page
		if (request.getRequestURL().toString().endsWith("/login")) {
			request.getRequestDispatcher("customer/login.jsp").forward(request, response);
		}
		// logout back up to home
		else if (request.getRequestURL().toString().endsWith("/logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("customerId");
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
		// get page sign up
		else if (request.getRequestURL().toString().endsWith("/signUp")) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/customer/signUp.jsp");
			dispatcher.forward(request, response);
		}
		// get page
		else if (request.getRequestURL().toString().endsWith("/isSign")) {
			
				SignUp(request, response);
		}
		else if(request.getRequestURL().toString().endsWith("/loginSuccess")) {
			success(request, response);
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
	public void SignUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String phoneNumber = request.getParameter("phoneNumber");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer c = new Customer();
		if (fName != null) {
			c.setFirstname(fName);
		}
		if (lName != null) {
			c.setLastname(lName);
		}
		if (dob != null) {
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			Date date = null;
			try {
				date = d.parse(dob);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setDateCreated(date);

		}
		
		if(phoneNumber!=null) {
			c.setPhone(phoneNumber);
		}
		if(username!=null) {
			c.setUsername(username);
		}
		if(password!=null) {
			c.setPassword(password);
		}
		customerService.signUp(c);
		response.sendRedirect(request.getContextPath() + "/login");
		
	}
	public void success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		Customer cus = customerService.signIn(username, password);
		System.out.println(password);

		if (cus != null) {
			System.out.print("k");
			HttpSession session = request.getSession();
			
			session.setAttribute("customerId", cus.getId());
			request.setAttribute("customerId", cus.getId());
			response.sendRedirect(request.getServletContext().getContextPath() + "/home");
			
			
		}
		else {
		
			
		response.sendRedirect(request.getServletContext().getContextPath() + "/login");
		}
		
	}

}
