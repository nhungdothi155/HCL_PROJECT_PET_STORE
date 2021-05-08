package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.store.entity.CartItem;
import com.pet.store.entity.Customer;
import com.pet.store.entity.Order;
import com.pet.store.service.impl.CartItemServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;
import com.pet.store.service.impl.OrderServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class Order
 */
@WebServlet(urlPatterns = {"/order/all","/order/add","/order/insert"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartItemServiceImpl cartItemService;
	private CustomerServiceImpl customerService;
	private OrderServiceImpl orderService;
	private ProductServiceImpl productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    	customerService = new CustomerServiceImpl();
		orderService = new OrderServiceImpl();
		cartItemService = new CartItemServiceImpl();
		productService = new ProductServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getRequestURL().toString();
		if(action.contains("/order/all")) {
			
		}
		//redirect to order add form
		else if(action.contains("/order/add")) {
			showOrderForm(request, response);
			
		}
		
		else if(action.contains("/order/insert")) {
			insertOrder(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void showOrderForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] listQuantity = request.getParameterValues("quantity");
		String[] listCartItem = request.getParameterValues("cartItem");
		List<CartItem> list = new ArrayList<CartItem>();
	     for(int i = 0 ; i<listCartItem.length;i++) {
	    	 
	    		 CartItem cartItem= cartItemService.getCartItemById(Long.parseLong(listCartItem[i]));
		    	 cartItem.setQuantity(Integer.parseInt(listQuantity[i]));
		    	 System.out.println(i);
		    	 
		    	 cartItemService.updateCartItem(cartItem);
		    	 list.add(cartItem);
	    	 
	     }
	   Double totalCost = list.stream().mapToDouble(a->a.getQuantity()*a.getProduct().getPrice()).reduce(0,(a,b)->a+b);
	    
	    request.setAttribute("cartItems",list);
	    request.setAttribute("totalCost", totalCost);
		System.out.println(list.size() + "size of all item in order");
		request.getRequestDispatcher("/customer/checkout.jsp").forward(request, response);
	}
	public void insertOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("customerId")!=null) {
			// get list cartItems
			String[] cartItemIds = request.getParameterValues("id");
		
			//String[] cartIds = request.getParameterValues("cartId");
			String[] productIds = request.getParameterValues("productId");
			String[] quantity = request.getParameterValues("quantity");
			// get the information of a user to add for a order
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			
			String country = request.getParameter("country");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
		
			String postcode = request.getParameter("postcode");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			String totalCost = request.getParameter("totalCost");

             System.out.println(totalCost);
			// get cusotmer id
			long customerId = Long.parseLong(request.getSession().getAttribute("customerId").toString());
			
			// create new order
			Order o = new Order();
			
			// get customer by id
			Customer c = customerService.getCustomerById(customerId);

			o.setCustomer(c);
			o.setCustomerFirstname(fname);
			o.setCustomerLastname(lname);
			o.setCustomerCountry(country);
			o.setCustomerCity(city);
			o.setZipCode(postcode);
			o.setCustomerPhone(phone);
			o.setTotalPrice(Double.parseDouble(totalCost));
			
	        o.setCustomerAddress(address);
	        o.setCustomerEmail(email);
			// insert customer in id
			orderService.insertOrder(o);
			Order order = customerService.findOrderByCustomerId(customerId);
			System.out.println(order.getOrderId());
		  
			for (int i = 0; i < cartItemIds.length; i++) {
				
				// add product to order
				customerService.addProductToOrder(Long.parseLong(productIds[i]), order.getOrderId(),
						Integer.parseInt(quantity[i]));
				// delte product in the cart
				cartItemService.deleteCartItem(Long.parseLong(cartItemIds[i]));

			}
		
			response.sendRedirect(request.getServletContext().getContextPath() + "/home");;
			}
			else {
				response.sendRedirect(request.getServletContext().getContextPath() + "/login");
			}
	}
	}
