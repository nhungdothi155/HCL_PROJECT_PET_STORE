package com.pet.store.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Cart;
import com.pet.store.entity.CartItem;
import com.pet.store.service.impl.CartItemServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
	private CartItemServiceImpl cartItemService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		customerService = new CustomerServiceImpl();
		cartItemService = new CartItemServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// having customer id and product id to add to a cart
		long customerId = Long.parseLong(request.getSession().getAttribute("customerId").toString());
		int productId = Integer.parseInt(request.getParameter("id"));
		System.out.println(customerId + " customer Id");
		// add cart for a cusotmer if cart is not exits
		customerService.addCartForCustomer((int) customerId);
		// find cart by ccusotmer id
		Cart cart = customerService.findCartByCustomerId(customerId);
		// find product in of this customer in the cart item
//		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		CartItem cartItem = cart.getCartItems().stream().filter(c->c.getProduct().getProductId() ==productId).findFirst().orElse(null);
	
		//System.out.println(cartItem.getProduct().getMaterial() + "k");
		
		// if product exists , add 1 to the quanity of order_product
		// else
		// add the product into cart
		List<CartItem> cartItems = new ArrayList<CartItem>();
		System.out.println(productId + "productId");
		if (cartItem != null) {
			System.out.println(cartItem.getCartItemId()  + " cartItem"); 
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItemService.updateCartItem(cartItem);
			Cart cartOfUser = customerService.findCartByCustomerId(customerId);
			// find all the cartItem incluing products
			cartItems = cartOfUser.getCartItems();
	           System.out.println(cartItems.size() + "catsize");


		} else {
			customerService.addProductToCart( cart.getCartId(), productId, 2);
			Cart cartOfUser = customerService.findCartByCustomerId(customerId);
			// find all the cartItem incluing products
			cartItems = cartOfUser.getCartItems();
	         

		}
		// find cart of by customer id agian
		
		request.setAttribute("cartItemLists", cartItems);
		

		RequestDispatcher rq = request.getRequestDispatcher("carts.jsp");
		rq.forward(request, response);

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

}
