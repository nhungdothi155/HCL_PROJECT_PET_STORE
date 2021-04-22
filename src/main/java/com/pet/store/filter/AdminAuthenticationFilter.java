package com.pet.store.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse =(HttpServletResponse) response;
		StringBuffer urlPattern = httpRequest.getRequestURL();
		String url = urlPattern.toString();
		if(url.contains(".jsp") && !url.equals("error.jsp")) {
			RequestDispatcher rq = httpRequest.getRequestDispatcher("error.jsp");
			rq.forward(httpRequest, httpResponse);
		}
		chain.doFilter(httpRequest, httpResponse);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
