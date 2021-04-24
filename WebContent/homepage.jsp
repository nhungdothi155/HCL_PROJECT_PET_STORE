<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h1>List product</h1>
<table>
<tr>
<th>Product<th>
<th>Price</th>
<th>Select</th>
</tr>
 <c:forEach var="product" items="${products}">

                                <tr>
                                    <td>
                                        <c:out value="${product.category.getCategoryName()}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.price}" />
                                    </td>
                                   
                                    <td><a href="product?id=<c:out value='${product.productId}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; </td>
                                </tr>
                            </c:forEach>

</table>

</body>
</html>