<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/detail.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
 
</head>
<body>
<div class = "card-wrapper">
      <div class = "card">
        <!-- card left -->
        <!-- <div class="url">Pet/Mono</div> -->
        <div class = "product-imgs">
          <div class = "img-display">
            <div class = "img-showcase">
              <img src = "image/image1.png" alt = "shoe image">
              <img src = "image/image2.png" alt = "shoe image">
              <img src = "image/image3.png" alt = "shoe image">
              <img src = "image/image4.png" alt = "shoe image">
            </div>
          </div>
          <div class = "img-select">
            <div class = "img-item">
              <a href = "#" data-id = "1">
                <img src = "image/image1.png" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "2">
                <img src = "image/image2.png" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "3">
                <img src = "image/image3.png" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "4">
                <img src = "image/image4.png" alt = "shoe image">
              </a>
            </div>
          </div>
        </div>
        <!-- card right -->
        <div class = "product-content">
          <h2 class = "product-title">nike shoes</h2>
          <div class = "product-detail">
            <h2>about this item: </h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo eveniet veniam tempora fuga tenetur placeat sapiente architecto illum soluta consequuntur, aspernatur quidem at sequi ipsa!</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur, perferendis eius. Dignissimos, labore suscipit. Unde.</p>
            <ul>
              <li><i class="fas fa-check"></i>Color: <span>Black</span></li>
              <li><i class="fas fa-check"></i>Available: <span>in stock</span></li>
              <li><i class="fas fa-check"></i>Category: <span>Shoes</span></li>
              <li><i class="fas fa-check"></i>Shipping Fee: <span>Free</span></li>
              <li><i class="fas fa-check"></i>Price: <span><a href="./index.html"> contact with me </a></span> </li>
            </ul>

            <div class = "social-links">
              <p><i class="fa fa-map-marker" aria-hidden="true"></i>  km9 Nguyen Trai, Thanh Xuan Bac, Nam Tu Liem, Ha Noi</p>
               <p><i class="fa fa-phone-square" aria-hidden="true"></i>  (008424) 3854 4338</p> 
              <P><i class="fa fa-envelope" aria-hidden="true"></i>  hanu@hanu.edu.vn</P>
            </div>
          </div>

          <div class = "purchase-info">
            <button type = "button" class = "btn">
              Add to Cart <i class = "fas fa-shopping-cart"></i>
            </button>
            <input type = "number" min = "0" value = "1">
            <!-- <button type = "button" class = "btn">Compare</button> -->
          </div>

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