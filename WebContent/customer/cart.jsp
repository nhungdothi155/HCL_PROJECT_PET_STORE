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
<form action="<%=request.getServletContext().getContextPath()%>/order/add" method=POST>
	<div id="form_calc" class="cart" style="display:block">
		<div class="split left">
		
			<table>
				<tr>
					<th>PRODUCT</th>
					<th>PRICE</th>
					<th>QUANTITY</th>
					<th>REMOVE</th>
				</tr>
				

					<c:forEach items="${cartItemLists }" var="c">
					
						<tr >
						
							
							<td><input type="checkbox"  onclick="test()" name="cartItem"  value="${c.cartItemId}"><img
								src="<%=request.getContextPath() %>/uploads/${fn:split(c.product.photos,',')[0] }"
								alt="" width="80" height="70" 	></td>
							<td><strong >$${c.product.price }</strong></td>
							<td><input type="number" id="input" name="quantity" value="${c.quantity}" ></td>
							<td><a href="<%=request.getContextPath() %>/cart/delete?cartItemId=${c.cartItemId}" class="text-dark"><i class="fa fa-trash"
									style="color: black;"></i></a></td>

						</tr>
					</c:forEach>
			

			</table>
		
			<a href="<%=request.getContextPath()%>/home"><button type="button">Continue seeing product</button></a>
		</div>
		<div class="split right">
		
				<h4>ORDER SUMMARY</h4>
				<div class="suborder">
					<strong id="subtotal">Sub Total Price:0$</strong>
				</div>
				<div class="total">
					<c:if test="${productId==null }">
						<strong id="total">Total Price:0$</strong>
					</c:if>
					<c:if test="${productId!=null }">
						<strong id="total">Total</strong>
					</c:if>
				</div>
				<a href="<%=request.getContextPath()%>/home"><button style="background-color: #27d9ab;">Procceed To
					Checkout</button></a>
			
		</div>

	</div>
	</form>

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