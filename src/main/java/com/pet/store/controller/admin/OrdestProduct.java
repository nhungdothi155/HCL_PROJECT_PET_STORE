package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
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
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;
import com.pet.store.service.OrderProductService;
import com.pet.store.service.ProductService;
import com.pet.store.service.impl.OrderProductServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductMonthly
 */
@WebServlet("/reportProduct")
public class OrdestProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private OrderProductService orderService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdestProduct() {
		productService = new ProductServiceImpl();
		orderService = new  OrderProductServiceImpl();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Product> products = productService.findAllProduct();
		List<OrderProduct> ops = orderService.getAllOrderProduct();
		Map<Object,Object> orderProducts = new TreeMap< Object,Object>(Collections.reverseOrder());
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		int num = 0;
	for(int i=0 ;i<products.size();i++) {
		String name  = products.get(i).getProductName();
		 num = products.get(i).getOrderProducts().stream().mapToInt(ob->ob.getOrderProductNumber() ).reduce(0, (a,b)->a + b);
		System.out.println(num);
		orderProducts.put("label", name);
		orderProducts.put("y", num);
		list.add(orderProducts);
	
	}
	
	System.out.println(orderProducts.size());
	
	Gson gsonObj = new Gson();

	String dataPoints = gsonObj.toJson(list);
	
	 
		
	request.setAttribute("dataPoints", dataPoints);

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
