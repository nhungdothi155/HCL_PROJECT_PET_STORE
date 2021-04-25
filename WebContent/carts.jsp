<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h1>List product</h1>
	<table>
		<tr>
			<th>Product
			<th>
			<th>Price</th>
			<th>Select</th>
		</tr>
		<form action="order" method=POST>
		
		<c:forEach var="cartItem" items="${cartItemLists}" >
		
			<tr>
			     <td><input type="checkbox" value="${cartItem.cartItemId }" name="cartItem" /></td>
				<td><c:out value="${cartItem.product.category.getCategoryName()}" /></td>
				<td><c:out value="${cartItem.product.price}" /></td>
               <td><c:out value="${cartItem.quantity}" /></td>
				<td><a href="product?id=<c:out value='${cartItem.product.productId}' />">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>

		</c:forEach>
		<input type="submit" value="order" />
					</form>

	</table>

</body>
</html>