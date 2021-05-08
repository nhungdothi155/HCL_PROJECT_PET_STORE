<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/customer/css/cart.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/customer/css/index.css">


</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>

	
		
			<table>
				<tr>
					<th>PRODUCT</th>
					<th>PRICE</th>
					<th>QUANTITY</th>
					<th>REMOVE</th>
				</tr>
				

					<c:forEach items="${ops }" var="o">
					
						<tr >
						
							
							<td><img
								src="<%=request.getContextPath() %>/uploads/${fn:split(o.product.photos,',')[0] }"
								alt="" width="80" height="70" 	></td>
							<td><strong >$${o.product.price }</strong></td>
							<td><input type="number" id="input" name="quantity" value="${o.orderProductNumber}" ></td>
							

						</tr>
					</c:forEach>
			

			</table>
	

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

function test(item) {
	  var operand1 = parseFloat($('#input').val());
	  var operand2 = 0;
	  var result;
 
    	
	  $('input:checked').each(function() {
	    operand2 += parseInt($(this).val())
	  });

	  // operand1 could be NaN
	  // you need to decide what to do in that case
	  result = operand1 * operand2;

	  $('#total').html("Total Cost: " + result+"$");
	  $('#subtotal').html("Sub Total Cost: " + result+"$");
	
	}
$('input').on('focusin', function(){
    console.log("Saving value " + $(this).val());
    $(this).data('val', $(this).val());
});

$('input').on('change', function(){
    var prev = $(this).data('val');
    var current = $(this).val();
    console.log("Prev value " + prev);
    console.log("New value " + current);
});
	
</script>
</html>