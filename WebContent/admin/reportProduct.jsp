<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>Sidebar 02</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/admin/css/style.css">
  </head>
  <body>
  <% Map<Integer, String> ops = (Map<Integer, String>) request.getAttribute("orderProducts");
   Object[] l = ops.values().toArray();
   Object[] y = ops.keySet().toArray();
  %>
		
		<div class="wrapper d-flex align-items-stretch">
				<nav id="sidebar">
				<div class="custom-menu">
					<button type="button" id="sidebarCollapse" class="btn btn-primary">
	          <i class="fa fa-bars"></i>
	          <span class="sr-only">Toggle Menu</span>
	        </button>
        </div>
				<div class="p-4 pt-5">
		  		<h1><a href="index.html" class="logo">Splash</a></h1>
	        <ul class="list-unstyled components mb-5">
	          <li class="active">
	            <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Report</a>
	            <ul class="collapse list-unstyled" id="homeSubmenu">
                <li>
                    <a href="<%=request.getContextPath() %>/reportOrder">Order Monthly</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/reportProduct">Selling Product</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/reportIncome">Income Monthly</a>
                </li>
	            </ul>
	          </li>
	          <li>
	               <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Product</a>
	            <ul class="collapse list-unstyled" id="homeSubmenu">
                <li>
                    <a href="<%=request.getContextPath() %>/admin/pets">Pets</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/admin/accessories">Accessories</a>
                </li>
	            </ul>
	          </li>
	          <li>
              <a href="<%=request.getContextPath() %>/admin/order">Orders</a>
	          </li>
	          <li>
              <a href="<%=request.getContextPath() %>/admin/category">Categories</a>
	          </li>
			  <li>
				<a href="<%=request.getContextPath() %>/admin/customer">Customers</a>
				</li>
	        </ul>

	      </div>
    	</nav>
        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
		</div>
		
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script>
window.onload = function () {

var options = {
	animationEnabled: true,
	title: {
		text: "GDP Growth Rate - 2016"
	},
	axisY: {
		title: "Growth Rate (in %)",
		suffix: "%"
	},
	axisX: {
		title: "Countries"
	},
	data: [{
		type: "column",
		yValueFormatString: "#,##0.0#"%"",
		dataPoints: [
			{ label:"<%=l[0]%>", y:<%=y[0]%> },	
			
			{ label:"<%=l[1]%>", y:<%=y[1]%> },	
			{ label:"<%=l[2]%>", y:<%=y[2]%> },	

			
			
		]
	}]
};
$("#chartContainer").CanvasJSChart(options);

}
</script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/jquery.min.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/popper.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/bootstrap.min.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/main.js"></script>
    <script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
  </body>
</html>