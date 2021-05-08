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
  <% Map<Integer, String> ops = (Map<Integer, String>) request.getAttribute("orderProducts");
   Object[] l = ops.values().toArray();
   Object[] y = ops.keySet().toArray();
  %>
		
			<jsp:include page="header.jsp"></jsp:include>
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
			<c:forEach items="${l}" var="l" varStatus="status">
			
			{ label:"${l}", y:${y[status.index]}}
			</c:forEach>

			
			
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