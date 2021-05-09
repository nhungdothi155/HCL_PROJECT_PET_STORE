<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/customer/css/detail.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"  />
 
</head>
<body>
<div class = "card-wrapper">
      <div class = "card">
        <!-- card left -->
        <!-- <div class="url">Pet/Mono</div> -->
        <div class = "product-imgs">
          <div class = "img-display">
            <div class = "img-showcase">
             
              <img width=300 height=500 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[0]}" alt = "shoe image">
           <img width=300 height=500 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[1]}" alt = "shoe image">
            <img width=300 height=500 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[2]}" alt = "shoe image">
             <img width=300 height=500  src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[3]}" alt = "shoe image">
             
            </div>
          </div>
          <div class = "img-select">
            <div class = "img-item">
              <a href = "#" data-id = "1">
                   <img width=125 height=90  src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[0]}" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "2">
                 <img width=125 height=90 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[1]}" alt = "shoe image">              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "3">
                 <img  width=125 height=90 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[2]}" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "4">
                <img width=125 height=90 src = "<%=request.getServletContext().getContextPath() %>/uploads/${fn:split(product.photos, ',')[3]}" alt = "shoe image">
              </a>
            </div>
          </div>
        </div>
        <!-- card right -->
        <div class = "product-content">
          <h2 class = "product-title">${product.productName }</h2>
          <div class = "product-detail">
            <h2>About: </h2>
            <p>${product.description}</p>
            <ul>
              <li><i class="fas fa-check"></i>Origin: <span>${product.origin}</span></li>
              <li><i class="fas fa-check"></i>Available: <span>in stock</span></li>
              <li><i class="fas fa-check"></i>Category: <span>${product.category.subCategories }</span></li>
              <li><i class="fas fa-check"></i>Shipping Fee: <span>Free</span></li>
              <li><i class="fas fa-check"></i>Price: <span><a href="./index.html"> contact with me </a></span> </li>
            </ul>

            <div class = "social-links">
              <p><i class="fa fa-map-marker" aria-hidden="true"></i>  km9 Nguyen Trai, Thanh Xuan Bac, Nam Tu Liem, Ha Noi</p>
               <p><i class="fa fa-phone-square" aria-hidden="true"></i>  (008424) 3854 4338</p> 
              <P><i class="fa fa-envelope" aria-hidden="true"></i>  hanu@hanu.edu.vn</P>
            </div>
          </div>
		<form action="cart" method="post">
          <div class = "purchase-info">
           <button type = "submit" class = "btn">
             Add to Cart <i class = "fas fa-shopping-cart"></i>
            </button >
            <input type = "number" min = "1"  name="quantity"/>
              <input type = "hidden" value="${product.productId }" name="productId">
         
          </div>
          </form>

<!-- 
          <div class = "product-price">
            <p class = "last-price">Old Price: <span>$257.00</span></p>
            <p class = "new-price">New Price: <span>$249.00 (5%)</span></p>
          </div> -->

         
        </div>
      </div>
    </div>

    
    <script >
      const imgs = document.querySelectorAll('.img-select a');
const imgBtns = [...imgs];
let imgId = 1;
imgBtns.forEach((imgItem) => {
    imgItem.addEventListener('click', (event) => {
        event.preventDefault();
        imgId = imgItem.dataset.id;
        slideImage();
    });
});
function slideImage(){
    const displayWidth = document.querySelector('.img-showcase img:first-child').clientWidth;
    document.querySelector('.img-showcase').style.transform = `translateX(${- (imgId - 1) * displayWidth}px)`;
}
window.addEventListener('resize', slideImage);
    </script>
</body>
</html>