package com.pet.store.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.store.dao.implement.CustomerDAOImpl;
import com.pet.store.entity.CartItem;
import com.pet.store.entity.Customer;
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
		Customer cus  = cusService.signIn(username, password);
		if(cus!=null) {
			//create new request 
			RequestDispatcher rq= request.getRequestDispatcher("homepage.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("customer_id", cus.getId());
			CustomerDAOImpl c = new CustomerDAOImpl();
			Customer customer = c.getElementById(cus.getId());
			
			List<CartItem> is = customer.getCarts().get(0).getCartItems();
			PrintWriter out = response.getWriter();
			for(CartItem i : is) {
				System.out.println(i.getProduct().getProductName() );
			}
			
			
			
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
