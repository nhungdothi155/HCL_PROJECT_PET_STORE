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
import com.pet.store.entity.Product;
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
		System.out.println(customerId);
		// add cart for a cusotmer if cart is not exits
		customerService.addCartForCustomer((int) customerId);
		// find cart by ccusotmer id
		Cart cart = customerService.findCartByCustomerId(customerId);
		// find product in of this customer in the cart item
		CartItem cartItem = cart.getCartItems().stream().filter(p -> p.getProduct().getProductId() == productId)
				.findAny().orElse(null);
		// if product exists , add 1 to the quanity of order_product
		// else
		// add the product into cart
		if (cartItem != null) {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItemService.updateCartItem(cartItem);

		} else if(cartItem==null) {
			customerService.addProductToCart((int) cart.getCartId(), productId, 2);
		}
		// find cart of by customer id agian
		Cart cartOfUser = customerService.findCartByCustomerId(customerId);
		// find all the cartItem incluing products
		List<CartItem> cartItems = cartOfUser.getCartItems();

		// create a product list
		List<Product> products = new ArrayList<Product>();
		for (CartItem ci : cartItems) {
			System.out.println(ci.getQuantity());
			// add all product from cartItem to product lists
			products.add(ci.getProduct());
		}
		request.setAttribute("cartItemLists", cartItems);
		// set products atrribute to use in carts.jsp
		request.setAttribute("products", products);

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
