<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  
		<jsp:include page="header.jsp"></jsp:include>
        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
		<div class="container">
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-8"><h2>Category <b>Details</b></h2></div>
							<div class="col-sm-4">
								<div class="search-box">
									<i class="material-icons">&#xE8B6;</i>
									<input type="text" id="search" class="form-control" placeholder="Search&hellip;">
								</div>
							</div>
						</div>
					</div>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>Category Name<i class="fa fa-sort"></i></th>
								<th>Sub Cateogries</th>
								<th>Date Created<i class="fa fa-sort"></i></th>
								<th>Date Modified</th>
								
							</tr>
						</thead>
						<tbody id="myTable">
						  <c:forEach items="${categories}" var="cat">
							<tr>
								<td>${cat.categoryId }</td>
								<td>${cat.categoryName }</td>
								<td>${cat.subCategories} </td>
								<td>${cat.dateCreated}</td>
								<td>${cat.dateModified }</td>
								</c:forEach>
							</tr>      
						</tbody>
					</table>
					
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