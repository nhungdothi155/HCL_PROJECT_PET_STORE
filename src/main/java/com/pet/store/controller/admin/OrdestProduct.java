package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pet.store.entity.Product;
import com.pet.store.service.ProductService;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductMonthly
 */
@WebServlet("/reportProduct")
public class OrdestProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdestProduct() {
		productService = new ProductServiceImpl();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = productService.findAllProduct();
		Map<Integer,String> orderProducts = new TreeMap< Integer,String>(Collections.reverseOrder());
		
	for(int i=0 ;i<products.size();i++) {
		String name  = products.get(i).getProductName();
		int num = products.get(i).getOrderProducts().stream().mapToInt(ob->ob.getOrderProductNumber() ).reduce(0, (a,b)->a + b);
		orderProducts.put(num,name);
	}

	

		
	request.setAttribute("orderProducts", orderProducts);

	request.getRequestDispatcher("/admin/reportProduct.jsp").forward(request, response);
	
	
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
