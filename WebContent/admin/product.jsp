<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
  	<title>Administrator</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/admin/css/style.css">
	<style>
		body {
			color: #566787;
			background: #f5f5f5;
			font-family: 'Roboto', sans-serif;
		}
		.table-responsive {
			margin: 30px 0;
		}
		.table-wrapper {
			min-width: 1000px;
			background: #fff;
			padding: 20px;        
			box-shadow: 0 1px 1px rgba(0,0,0,.05);
		}
		.table-title {
			padding-bottom: 10px;
			margin: 0 0 10px;
		}
		.table-title h2 {
			margin: 8px 0 0;
			font-size: 22px;
		}
		.search-box {
			position: relative;        
			float: right;
		}
		.search-box input {
			height: 34px;
			border-radius: 20px;
			padding-left: 35px;
			border-color: #ddd;
			box-shadow: none;
		}
		.search-box input:focus {
			border-color: #3FBAE4;
		}
		.search-box i {
			color: #a0a5b1;
			position: absolute;
			font-size: 19px;
			top: 8px;
			left: 10px;
		}
		table.table tr th, table.table tr td {
			border-color: #e9e9e9;
		}
		table.table-striped tbody tr:nth-of-type(odd) {
			background-color: #fcfcfc;
		}
		table.table-striped.table-hover tbody tr:hover {
			background: #f5f5f5;
		}
		table.table th i {
			font-size: 13px;
			margin: 0 5px;
			cursor: pointer;
		}
		table.table td:last-child {
			width: 130px;
		}
		table.table td a {
			color: #a0a5b1;
			display: inline-block;
			margin: 0 5px;
		}
		table.table td a.view {
			color: #03A9F4;
		}
		table.table td a.edit {
			color: #FFC107;
		}
		table.table td a.delete {
			color: #E34724;
		}
		table.table td i {
			font-size: 19px;
		}    
		.pagination {
			float: right;
			margin: 0 0 5px;
		}
		.pagination li a {
			border: none;
			font-size: 95%;
			width: 30px;
			height: 30px;
			color: #999;
			margin: 0 2px;
			line-height: 30px;
			border-radius: 30px !important;
			text-align: center;
			padding: 0;
		}
		.pagination li a:hover {
			color: #666;
		}	
		.pagination li.active a {
			background: #03A9F4;
		}
		.pagination li.active a:hover {        
			background: #0397d6;
		}
		.pagination li.disabled i {
			color: #ccc;
		}
		.pagination li i {
			font-size: 16px;
			padding-top: 6px
		}
		.hint-text {
			float: left;
			margin-top: 6px;
			font-size: 95%;
		}    
	</style>
		<link rel="stylesheet" href="css/style.css">


  </head>
  <body>
		
		<div class="wrapper d-flex align-items-stretch">
			<nav id="sidebar">
				<div class="custom-menu">
					<button type="button" id="sidebarCollapse" class="btn btn-primary">
	          <i class="fa fa-bars"></i>
	          <span class="sr-only">Toggle Menu</span>
	        </button>
        </div>
				<div class="p-4 pt-5">
		  		<h1><a href="index.html" class="logo">Administrator</a></h1>
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
		<div class="container">
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-8"><h2>Customer <b>Details</b></h2></div>
							<c:set var= "url" value="${url}"/>
							<c:if test="${fn:contains(url, 'pets')}">
							<a href="<%=request.getContextPath() %>/admin/pets/add" title="Add" >Add Product</a>
							</c:if>
							<c:if test="${fn:contains(url, 'accessories')}">
							<a href="<%=request.getContextPath() %>/admin/accessories/add" title="Add" >Add Product</a>
							</c:if>
							
							<div class="col-sm-4">
								<div class="search-box">
									<i class="material-icons">&#xE8B6;</i>
									<input type="text" id="search" class="form-control" placeholder="Search&hellip;">
									
								</div>
							</div>
						</div>
					</div>
						<c:if  test="${accessories !=null}">
				
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th>#  <c:out value = "${url}"/></th>
								<th>Category Name<i class="fa fa-sort"></i></th>
								<th>Product Name</th>
								<th>Brand<i class="fa fa-sort"></i></th>
								<th>Material</th>
								<th>Origin<i class="fa fa-sort"></i></th>
								<th>Price</th>
								<th>Product Numbers</th>
								<th>Product State</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody id="myTable">
						  <c:forEach items="${accessories}" var="p">
							<tr>
								<td>${p.productId }</td>
								<td>${p.category.categoryName }</td>
								<td>${p.productName}</td>
								<td>${p.brand }</td>
								<td>${p.material }</td>
								<td>${p.origin }</td>
								<td>${p.price }</td>
								<td>${p.productNumbers }</td>
								<td>${p.productState }</td>
								<td>
									
									<a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
									<a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
								</td>
								</c:forEach>
							</tr>      
						</tbody>
					</table>
				</c:if>
				<c:if  test="${pets!=null}">
				
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>Category Name<i class="fa fa-sort"></i></th>
								<th>Product Name</th>
								<th>Origin<i class="fa fa-sort"></i></th>
								<th>Price</th>
								<th>Product Numbers</th>
								<th>Weight</th>
								<th>Age</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody id="myTable">
						  <c:forEach items="${pets}" var="p">
							<tr>
								<td>${p.productId }</td>
								<td>${p.category.categoryName }</td>
								<td>${p.productName}</td>
								<td>${p.origin}</td>
								<td>${p.price }</td>
								<td>${p.productNumbers }</td>
								<td>${p.weight }</td>
								<td>${p.age }</td>
								<td>
									<a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
									<a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
									<a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
								</td>
								</c:forEach>
							</tr>      
						</tbody>
					</table>
				</c:if>
					<div class="clearfix">
						<div class="hint-text">Showing <b>10</b> out of <b>25</b> entries</div>
						<ul class="pagination">
							<li class="page-item disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
							<li class="page-item"><a href="#" class="page-link">1</a></li>
							<li class="page-item"><a href="#" class="page-link">2</a></li>
							<li class="page-item active"><a href="#" class="page-link">3</a></li>
							<li class="page-item"><a href="#" class="page-link">4</a></li>
							<li class="page-item"><a href="#" class="page-link">5</a></li>
							<li class="page-item"><a href="#" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
						</ul>
					</div>
				</div>
			</div>        
		</div>     
	</div>
<script>
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();
		});
		$(document).ready(function(){
			  $("#search").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
	
	
		</script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/jquery.min.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/popper.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/bootstrap.min.js"></script>
    <script src="<%=request.getServletContext().getContextPath() %>/admin/js/main.js"></script>
  </body>
</html>