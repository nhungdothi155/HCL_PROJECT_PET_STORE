package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.Category;
import com.pet.store.service.CategoryService;
import com.pet.store.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class ManageCategoryServlet
 */
@WebServlet("/admin/category")
public class ManageCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  CategoryService catService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCategoryServlet() {
        super();
        catService = new CategoryServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = catService.getAllCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
