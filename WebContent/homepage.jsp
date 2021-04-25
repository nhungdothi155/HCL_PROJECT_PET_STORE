<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h1>List product</h1>
	<form  method=GET >
	Search :<input type="search" name="search"  />
	<c:set var="search" scope="session" value="${search}"/>  
	<c:if test="${search !=null }">
	<select name="orderby">
	<option value="feature">Featured</option>
	<option value="lowprice">LowToHigh</option>
	<option value="highprice">HighToLow</option>
	<option value="newest">Newest</option>
	</select>
	</c:if>
	<input type="submit"  value="Search" />
	</form>
	
	<table>
		<tr>
			<th>Product
			<th>
			<th>Price</th>
			<th>Select</th>
		</tr>
		<c:forEach var="product" items="${products}">

			<tr>
				<td><c:out value="${product.category.getCategoryName()}" /></td>
				<td><c:out value="${product.price}" /></td>

				<td><a href="product?id=<c:out value='${product.productId}' />">ViewProduct</a>
					&nbsp;&nbsp;&nbsp;&nbsp;<a href="cart?id=${product.productId}" >Add To Cart</a></td>
					
			</tr>
		</c:forEach>
		

	</table>

</body>
</html>