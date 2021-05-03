package com.pet.store.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;
import com.pet.store.service.OrderProductService;
import com.pet.store.service.impl.OrderProductServiceImpl;


/**
 * Servlet implementation class IncomeYearly
 */
@WebServlet("/reportIncome")
public class IncomeYearly extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderProductService opService;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeYearly() {
    	opService = new  OrderProductServiceImpl();
			
		
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderProduct> ops = opService.getAllOrderProduct();
		System.out.println(ops.size());
		  double Jan = ops.stream().filter(o->o.getDateCreated().getMonth()==1).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Feb = ops.stream().filter(o->o.getDateCreated().getMonth()==2).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Mar = ops.stream().filter(o->o.getDateCreated().getMonth()==3).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Apr = ops.stream().filter(o->o.getDateCreated().getMonth()==4).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double May = ops.stream().filter(o->o.getDateCreated().getMonth()==5).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Jun = ops.stream().filter(o->o.getDateCreated().getMonth()==6).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Jul = ops.stream().filter(o->o.getDateCreated().getMonth()==7).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Aug = ops.stream().filter(o->o.getDateCreated().getMonth()==8).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Sep = ops.stream().filter(o->o.getDateCreated().getMonth()==9).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Oct = ops.stream().filter(o->o.getDateCreated().getMonth()==10).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Nov = ops.stream().filter(o->o.getDateCreated().getMonth()==11).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  double Dec = ops.stream().filter(o->o.getDateCreated().getMonth()==12).mapToDouble(p->p.getOrderProductNumber()*p.getProduct().getPrice()).reduce(0, (a,b)->a + b);
		  System.out.println(Jan);
		  System.out.println(Apr);
		  System.out.println(Jan + Feb + Mar + Apr + May + Jun + Jul + Aug + Sep + Oct + Nov + Dec);
		  double[] months ={Jan, Feb, Mar, Apr, May, Jun,Jul, Aug, Sep, Oct, Nov, Dec};
		  request.setAttribute("months", months);
		
		  request.getRequestDispatcher("/admin/reportIncome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
