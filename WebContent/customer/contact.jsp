
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous">
<link href="<%=request.getContextPath() %>/customer/css/contact.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/customer/css/index.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!-- header -->
<div class="footer">
  <div class="container">
    <div class="footer-inner">
      <div class="row">
        <div class="col-md-8">
          <div class="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3725.0966607745468!2d105.7934374142446!3d20.98876209451995!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135acc7080ef987%3A0xf3d8ab6bbe8f6cb9!2zxJDhuqFpIEjhu41jIEjDoCBO4buZaSwgVHJ1bmcgVsSDbiwgSMOgIMSQw7RuZywgSMOgIE7hu5lpLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1620177310054!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
          </div>
        </div>
        <div class="col-md-4">
          <div class="contact-text">
          <h1>Contact Us</h1>
            <h2><i class="fa fa-map-marker" aria-hidden="true"></i> &nbsp; Address</h2>
            <p>&nbsp;km9 Nguyen Trai, Thanh Xuan Bac, Nam Tu Liem, Ha Noi</p>
            <h2><i class="fa fa-phone-square" aria-hidden="true"></i> &nbsp; Hotline</h2>
            <P>&nbsp;(008424) 3854 4338</P>
            <h2><i class="fa fa-envelope" aria-hidden="true"></i> &nbsp; E-Mail</h2>
            <P> &nbsp; hanu@hanu.edu.vn</P>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- header -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
