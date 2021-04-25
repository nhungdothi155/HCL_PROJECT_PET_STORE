<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="success" method=POST >
<c:forEach var="cartItem" items="${listCartItem}">
<input type="hidden" value="${cartItem.cartItemId }" name="id"/>
<input type="hidden" value="${cartItem.cart.cartId }" name="cartId"/>
<input type="hidden" value="${cartItem.product.productId }" name="productId"/>
<input type="hidden" value="${cartItem.quantity }" name="quantity"/>
</c:forEach>
Address :<input type="text" name="address"/>
Email : <input type="email" name ="email"/>


<button>Finhish</button>
</form>

</body>
</html>