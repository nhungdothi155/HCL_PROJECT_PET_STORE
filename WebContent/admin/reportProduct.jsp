<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>Administrator</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/admin/css/style.css">
  </head>
  <body>
  <% String dataPoints = (String) request.getAttribute("dataPoints");
  %>
		<div class="wrapper d-flex align-items-stretch">
			<jsp:include page="header.jsp"></jsp:include>
        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
		</div>
		</div>
		
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script>

window.onload = function () {
	<% if(dataPoints != null) { %>
var options = {
		animationEnabled: true,
		exportEnabled: true,
	title: {
		text: "Selling Product- 2021"
	},
	axisX: {
		title: "Products In the Pet Store"
	},
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		dataPoints: <%out.print(dataPoints);%>
	}],
	scales: {
	      y: {
	        beginAtZero: true
	      }
	    }
};
$("#chartContainer").CanvasJSChart(options);
<% } %> 
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