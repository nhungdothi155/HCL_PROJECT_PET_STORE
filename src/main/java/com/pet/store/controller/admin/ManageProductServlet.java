package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Product;
import com.pet.store.service.ProductService;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ManageProductServlet
 */
@WebServlet(urlPatterns = {"/admin/product/pets", "/admin/product/accessories"})
public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProductServlet() {
    	productService =  new ProductServiceImpl();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.findAllProduct();
		List<Product> pets = products.stream().filter(p->p.getCategory().getCategoryName().equals("PET")).collect(Collectors.toList());
		List<Product> accessories = products.stream().filter(p->p.getCategory().getCategoryName().equals("ACCESSORIES")).collect(Collectors.toList());
		System.out.println(request);
		String action = request.getRequestURI();
		
		if(action.endsWith("pets")) {
			System.out.println(pets.size());
			request.setAttribute("pets", pets);
		}
		else if(action.endsWith("accessories")) {
			request.setAttribute("accessories", accessories);
		}
		
				
		
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
