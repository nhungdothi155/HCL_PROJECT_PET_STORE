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

import com.pet.store.dao.implement.CartDAOImpl;
import com.pet.store.entity.Cart;
import com.pet.store.entity.CartItem;
import com.pet.store.service.impl.CartItemServiceImpl;
import com.pet.store.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/*")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
	private CartItemServiceImpl cartItemService;
	private CartDAOImpl cartService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		customerService = new CustomerServiceImpl();
		cartItemService = new CartItemServiceImpl();
		cartService = new CartDAOImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// having customer id and product id to add to a cart
		String action = request.getRequestURL().toString();
		if(action.contains("/cart") && !action.contains("/cart/delete")) {
			showCart(request, response);
		}
		else if(action.contains("/cart/delete")) {
			deleteCart(request, response);
			
			
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
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long id =Long.parseLong( request.getParameter("cartItemId"));
		System.out.println(id);
		cartItemService.deleteCartItem(id);
		response.sendRedirect(request.getContextPath() + "/cart");
		return ;
		
	}
	public void showCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	if (request.getSession().getAttribute("customerId") != null) {
			
			long customerId = Long.parseLong(request.getSession().getAttribute("customerId").toString());


			if (request.getParameter("productId") != null ) {
				
				int productId = Integer.parseInt(request.getParameter("productId"));
				int quantity = 1;
				if(request.getParameter("quantity")!="") {
						quantity = Integer.parseInt(request.getParameter("quantity"));
				}
			

				// add cart for a cusotmer if cart is not exits
				customerService.addCartForCustomer((int) customerId);

				// find cart by ccusotmer id
				Cart cart = customerService.findCartByCustomerId(customerId);

				// find product in of this customer in the cart item

				CartItem cartItem = cart.getCartItems().stream().filter(c -> c.getProduct().getProductId() == productId)
						.findFirst().orElse(null);

				List<CartItem> cartItems = new ArrayList<CartItem>();

				if (cartItem != null) {
					System.out.print("yalay");

					cartItem.setQuantity(cartItem.getQuantity() + quantity);
					cartItemService.updateCartItem(cartItem);

					
					Cart cartOfUser = customerService.findCartByCustomerId(customerId);
					// find all the cartItem incluing products
					cartItems = cartOfUser.getCartItems();

				} else {
					customerService.addProductToCart(cart.getCartId(), productId, quantity);
					Cart cartOfUser = customerService.findCartByCustomerId(customerId);
					// find all the cartItem incluing products
					cartItems = cartOfUser.getCartItems();

				}
				// find cart of by customer id agian
				request.setAttribute("productId", productId);
				request.setAttribute("cartItemLists", cartItems);

				

			} else {
				Cart cart = customerService.findCartByCustomerId(customerId);
				if(cart==null) {
					customerService.addCartForCustomer((int) customerId);
				}
				else {
				List<CartItem> items = cart.getCartItems();
				request.setAttribute("cartItemLists", items);
				}
				
			}
			RequestDispatcher rq = request.getRequestDispatcher("customer/cart.jsp");
			rq.forward(request, response);

		} else {
			response.sendRedirect(request.getServletContext().getContextPath() + "/login");
		}
	}

}
