<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h1>List product</h1>
	<form action="order" method=POST>
		<table>
			<tr>
				<th>Product
				<th>
				<th>Price</th>
				<th>Select</th>
			</tr>


			<c:forEach var="cartItem" items="${cartItemLists}">

				<tr>
					<td><input type="checkbox" value="${cartItem.cartItemId }"
						name="cartItem" /></td>
					<td><c:out
							value="${cartItem.product.category.getCategoryName()}" /></td>
					<td><c:out value="${cartItem.product.price}" /></td>
					<td><c:out value="${cartItem.quantity}" /></td>
				</tr>

			</c:forEach>



		</table>
		<input type="submit" value="Order">
	</form>

</body>
</html>