<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <!---<title> Responsive Registration Form | CodingLab </title>--->
      <link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/customer/css/signUp.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="title">Registration</div>
    <div class="content">
      <form action="<%=request.getContextPath()%>/isSign" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">FirstName</span>
            <input type="text" name="firstname" required>
          </div>
           <div class="input-box">
            <span class="details">LastName</span>
            <input type="text" name="lastname" required>
          </div>
           <div class="input-box">
            <span class="details">Date of Birth</span>
            <input type="date" name="dob" required>
          </div>
       
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" name="phoneNumber" required>
          </div>
          <div class="input-box">
            <span class="details">Username</span>
            <input type="text" name="username" required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" name="password" required>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input type="password" name="password" required>
          </div>
        </div>
        
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>

</body>
<script>
</script>
</html>
