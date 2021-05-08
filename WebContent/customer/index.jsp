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
 
    <div class="dogs">
      <h1><span>DOGS</span></h1>
    <div class="flex">
    <c:forEach items ="${dogs }" var ="dog" >
      <div >
       <a href="<%=request.getServletContext().getContextPath()%>/product?id=${dog.productId}"> <img  style="object-fit: cover;"  src="<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(dog.photos,',')[0]}"  ></a>
       
        <p class="category">${dog.category.categoryName }</p>
        <h4>${dog.productName }</h4>
        <p class="price">$${dog.price}</p>

      </div>
      </c:forEach>
     
    
    </div>
  </div>
  
    <div class="cats">
      <h1><span>CATS</span></h1>
      <div class="flex">
        <div >
          <img  style="object-fit: cover;" src="images/ad1.png"  >
          <p class="category">Accessoreis</p>
          <h4>Kitt</h4>
          <p class="price">$19.99</p>

        </div>
        <div>2</div>
        <div>3</div>
        <div>4</div>
        <div>5</div>
        <div>6</div>
      </div>
    </div>
    <div class="accessories">
      <h1><span>ACCESSORIES</span></h1>
      <div class="flex">
        <div >
          <img  style="object-fit: cover;" src="images/ad1.png"  >
          <p class="category">Accessoreis</p>
          <h4>Kitt</h4>
          <p class="price">$19.99</p>

        </div>
        <div>2</div>
        <div>3</div>
        <div>4</div>
        <div>5</div>
        <div>6</div>
      </div>
    </div>
    <div class="contact"></div>
    
    <!-- footer -->

 <jsp:include page="footer.jsp"></jsp:include>
      

</body>
<script>
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
