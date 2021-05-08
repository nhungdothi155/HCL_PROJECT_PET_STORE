<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/customer/css/index.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
 <!-- Header -->
 <jsp:include page="header.jsp"></jsp:include>
<!-- Header -->
 <div class="flex-col medium-text-center">
	  	<p class="woocommerce-result-count hide-for-medium">Show 25 products for each page</p>

	  </div>
    <div class="products">
    <form style="position:relative; top: 100px" class="search" method="get" >
	<select class="selectpicker" name="orderby" class="orderby" aria-label="Đơn hàng của cửa hàng" onchange="this.form.submit()">
					<option value="feature" >featured</option>
					<option value="lowprice">LowestPriceToHigh</option>
					<option value="highprice">HighestPriceToLow</option>
					<option value="newest">Newest</option>
			</select>
			<input type="hidden" name="search" value="${search }">
<!-- <input type="hidden" name="page" value="${page }">
	
	 <input type="hidden" name="post_type" value="product">-->
	</form>
    <div class="flex" style="margin-top:100px; margin-left:110px;margin-right:100px" >
    <c:if test="${products!=null }">
    <c:forEach items ="${products }" var ="p" >
      <div >
       <a href="<%=request.getServletContext().getContextPath()%>/product?id=${p.productId}"> <img  style="object-fit: cover;"  src="<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(p.photos,',')[0]}"  ></a>
        <p class="category">${p.category.categoryName }</p>
        <h4>${p.productName }</h4>
        <p class="price">$${p.price}</p>

      </div>
      </c:forEach>
     </c:if>
     
    
    </div>
  </div>
  <%
  String path= request.getContextPath() + "/home/";
  %>
  
 <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="${path }?page=${currentPage - 1}&search=${search}&orderby=${orderby }">Previous</a></td>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${path}?page=${i}&search=${search}&orderby=${orderby }">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="${path }?page=${currentPage + 1}&search=${search}&orderby=${orderby }">Next</a></td>
    </c:if>
 
  
   
    
    <!-- footer -->

 <jsp:include page="footer.jsp"></jsp:include>
      

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<script>
document.getElementById('search').value = '${param.foo}';
  var myIndex = 0;
  carousel();
  
  function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 5000); // Change image every 2 seconds
  }
  </script>
</html>
