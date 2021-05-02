package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Order;
import com.pet.store.service.OrderService;
import com.pet.store.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class ManageOrderServlet
 */
@WebServlet("/admin/order")
public class ManageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrderServlet() {
    	orderService = new OrderServiceImpl();
     
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = orderService.findAllOrder();
		System.out.println(orders.size() + "K") ;
		System.out.println(request.getServletPath());
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
