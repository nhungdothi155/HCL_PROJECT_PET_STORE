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
  <div class="main-header">
    <div class="header">
      <i class="header-icon"><img class="header-icon-image" src="images/petIcon.jpg"></i>
      
      <div class="search-container">
          <form action="">
            <input type="text" placeholder="" name="search">
           <button style="background-image: url(images/searchIcon.jpg); background-size: cover;"></button>
          </form>
        </div>

        <div class="phone" ><i class="fa fa-phone" style="font-size:18px"></i>0972751283</div>
       
        <div class="love">
          <button class="btn" style="border: none; background-color: white;"><i class="fa fa-heart"  style="font-size: 20px;"></i></button>
        </div>

        <div class="cart">
          <button class="btn" style="border: none;background-color: white;"><i class="fa" style="font-size:24px; color: #7d7d7d;">&#xf07a;</i></button>
        </div>

        <div class="sign-in">
          <button class="btn" style="border:none; background-color: white;margin-right: -100px;padding-right: 3px; border-right: 0.3px solid #ccc;">SignIn</button>
        </div>

        <div class="sign-up">
          <button class="btn" style="border:none; background-color: white;margin-right: 50px; margin-left: -30px;">SignUp</button>
        </div>
  </div>

  <nav>
    <ul class="nav">
      <li><a href="#">Home</a></li>
      <li><a href="#">Pet</a>
        <ul>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
        </ul>
      </li>
      <li><a href="#">Accessories</a>
        <ul>
          <li><a href="#">item a lonng submenu</a></li>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
        </ul>
      </li>
      <li><a href="#">NEWS</a></li>
      <li><a href="#">Contact</a>
        <ul>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
          <li><a href="#">item</a></li>
        </ul>
      </li>
      <li><a href="#">Contact</a></li>
    </ul>
  </nav>

  </div>
    <!-- <div class="slide-show" style="height:600px;width: 100% ; background-image: url(images/white.jpg); background-size: cover;background-repeat: no-repeat;">
  
    </div> -->
    <div class="dogs">
      <h1><span>DOGS</span></h1>
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

    <footer class="footer-distributed">
 
      <div class="footer-left">
      
      <h3>WebDev<span>Trick</span></h3>
      
      <p class="footer-links">
      <a href="#">Home</a>
      ·
      <a href="#">Blog</a>
      ·
      <a href="#">Pricing</a>
      ·
      <a href="#">About</a>
      ·
      <a href="#">Faq</a>
      ·
      <a href="#">Contact</a>
      </p>
      
      <p class="footer-company-name">webdevtrick &copy; 2019</p>
      </div>
      
      <div class="footer-center">
      
      <div>
      <i class="fa fa-map-marker"></i>
      <p><span>21 Revolution Street</span> Delhi, India</p>
      </div>
      
      <div>
      <i class="fa fa-phone"></i>
      <p>+1 555 123456</p>
      </div>
      
      <div>
      <i class="fa fa-envelope"></i>
      <p><a href="mailto:support@company.com">contact@webdevtrick.com</a></p>
      </div>
      
      </div>
      
      <div class="footer-right">
      
      <p class="footer-company-about">
      <span>About the company</span>
      Web Dev Trick is a blog for web designers, graphic designers, web developers &amp; SEO Learner.
      </p>
      
      <div class="footer-icons">
      
      <a href="#"><i class="fa fa-facebook"></i></a>
      <a href="#"><i class="fa fa-twitter"></i></a>
      <a href="#"><i class="fa fa-linkedin"></i></a>
      <a href="#"><i class="fa fa-github"></i></a>
      
      </div>
      
      </div>
      
      </footer>
      

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
