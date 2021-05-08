package com.pet.store.controller.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.store.entity.Customer;
import com.pet.store.entity.Seller;
import com.pet.store.service.CustomerService;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/login", "/logout", "/signUp", "/isSign", "/loginSuccess" })
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/signUp.jsp");
			dispatcher.forward(request, response);
		}
		// get page
		else if (request.getRequestURL().toString().endsWith("/isSign")) {

			SignUp(request, response);
		} else if (request.getRequestURL().toString().endsWith("/loginSuccess")) {
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
		String lName = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String phoneNumber = request.getParameter("phoneNumber");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(fName + lName + dob + phoneNumber + username + password);
		Customer c = new Customer();
		if (fName != null) {
			c.setFirstname(fName);
		}
		if (lName != null) {
			c.setLastname(lName);
		}
		if (dob != null) {

			c.setDob(dob);

		}

		if (phoneNumber != null) {
			c.setPhone(phoneNumber);
		}
		if (username != null) {
			c.setUsername(username);
		}
		if (password != null) {
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
		Seller seller = customerService.signInAdmin(username, password);
		

		if (cus != null && seller == null) {

			HttpSession session = request.getSession();

			session.setAttribute("customerId", cus.getId());
			request.setAttribute("customerId", cus.getId());
			response.sendRedirect(request.getServletContext().getContextPath() + "/home");

		} else if (cus == null && seller != null) {
			System.out.println("K");
			HttpSession session = request.getSession();

			session.setAttribute("adminId", seller.getSellerId());

			response.sendRedirect(request.getServletContext().getContextPath() + "/admin/customer");
		}

		else {

			response.sendRedirect(request.getServletContext().getContextPath() + "/login");
		}

	}

}
