 <div class="main-header">
    <div class="header">
      <i class="header-icon"><img class="header-icon-image" src="<%=request.getServletContext().getContextPath() %>/customer/images/petIcon.jpg"></i>
      
      <div class="search-container">
          <form action="">
            <input type="text" placeholder="" name="search">
           <button style="background-image: url(<%=request.getServletContext().getContextPath() %>/customer/images/searchIcon.jpg); background-size: cover;"></button>
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