<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

		
	
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
                    <a href="reportOrder">Order Monthly</a>
                </li>
                <li>
                    <a href="reportProduct">Selling Product</a>
                </li>
                <li>
                    <a href="reportIncome">Income Monthly</a>
                </li>
	            </ul>
	          </li>
	          <li>
	               <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Product</a>
	            <ul class="collapse list-unstyled" id="homeSubmenu">
                <li>
                    <a href="admin/pets">Pets</a>
                </li>
                <li>
                    <a href="admin/accessories">Accessories</a>
                </li>
	            </ul>
	          </li>
	          <li>
              <a href="admin/order">Orders</a>
	          </li>
	          <li>
              <a href="admin/category">Categories</a>
	          </li>
			  <li>
				<a href="admin/customer">Customers</a>
				</li>
	        </ul>

	      </div>
    	</nav>


 