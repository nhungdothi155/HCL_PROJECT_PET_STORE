package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Order;
import com.pet.store.service.OrderService;
import com.pet.store.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderMonthly
 */
@WebServlet("/reportOrder")
public class OrderYearly extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderYearly() {
    	orderService = new OrderServiceImpl();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = orderService.findAllOrder();
//	    Map<Integer, Integer> months = new HashMap<Integer, Integer>();
//	    Integer Jan;
//	    Integer Feb;
//	    Integer Mar;
//	    Integer Apr;
//	    Integer May;
//	    Integer Jun;
//	    Integer Jul;
//	    Integer Aug;
//	    Integer Sep;
//	    Integer Oct;
//	    Integer Nov;
//	    Integer Dec;
	  int Jan = orders.stream().filter(o->o.getDateCreated().getMonth()==1).collect(Collectors.toList()).size();
	  int Feb = orders.stream().filter(o->o.getDateCreated().getMonth()==2).collect(Collectors.toList()).size();
	  int Mar = orders.stream().filter(o->o.getDateCreated().getMonth()==3).collect(Collectors.toList()).size();
	  int Apr = orders.stream().filter(o->o.getDateCreated().getMonth()==4).collect(Collectors.toList()).size();
	  int May = orders.stream().filter(o->o.getDateCreated().getMonth()==5).collect(Collectors.toList()).size();
	  int Jun = orders.stream().filter(o->o.getDateCreated().getMonth()==6).collect(Collectors.toList()).size();
	  int Jul = orders.stream().filter(o->o.getDateCreated().getMonth()==7).collect(Collectors.toList()).size();
	  int Aug = orders.stream().filter(o->o.getDateCreated().getMonth()==8).collect(Collectors.toList()).size();
	  int Sep = orders.stream().filter(o->o.getDateCreated().getMonth()==9).collect(Collectors.toList()).size();
	  int Oct = orders.stream().filter(o->o.getDateCreated().getMonth()==10).collect(Collectors.toList()).size();
	  int Nov = orders.stream().filter(o->o.getDateCreated().getMonth()==11).collect(Collectors.toList()).size();
	  int Dec = orders.stream().filter(o->o.getDateCreated().getMonth()==12).collect(Collectors.toList()).size();
	  
		int[] months = {Jan, Feb,Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};
		request.setAttribute("months", months);
		request.getRequestDispatcher("/admin/reportOrder.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
