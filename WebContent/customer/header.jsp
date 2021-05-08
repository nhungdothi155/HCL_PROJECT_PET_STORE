<%@page import="java.util.stream.Collectors"%>
<%@page import="com.pet.store.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.pet.store.service.impl.CategoryServiceImpl"%>
<%@page import="com.pet.store.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
CategoryService c = new CategoryServiceImpl();


List<Category> cats = c.getAllCategories();
request.setAttribute("cats1", cats.stream().filter(k -> k.getCategoryName().equals("PETS")).collect(Collectors.toList()));
request.setAttribute("cats2", cats.stream().filter(k -> k.getCategoryName().equals("ACCESSORIES")).collect(Collectors.toList()));

String searchValue= request.getParameter("search");

%>

 <div class="main-header">
    <div class="header">
      <i class="header-icon"><img class="header-icon-image" src="<%=request.getServletContext().getContextPath() %>/customer/images/petIcon.jpg"></i>
      
      <div class="search-container">
          <form action="<%=request.getContextPath() %>/home" method=get>
            <input id="search" type="text" placeholder="" name="search" value="${search }">
           <button style="background-image: url(<%=request.getServletContext().getContextPath() %>/customer/images/searchIcon.jpg); background-size: cover;"></button>
          </form>
        </div>

        <div class="phone" ><i class="fa fa-phone" style="font-size:18px"></i>0972751283</div>
       
        <div class="love">
         <a href="<%=request.getContextPath() %>/order/all"><button class="btn" style="border: none; background-color: white;"><i class='fas fa-cart-arrow-down' style='font-size:20px'>&#xf07a;</i></button></a> 
        </div>

        <div class="cart">
          <a href="<%=request.getContextPath() %>/cart"><button class="btn" style="border: none;outline:none;background-color: white;"><i class="fa" style="font-size:24px; color: #7d7d7d;">&#xf07a;</i></button></a>
        </div>
		<c:if test="${customerId==null }">
        <div class="sign-in">
           <a href="<%=request.getContextPath() %>/login"><button class="btn" style="border:none; background-color: white;margin-right: -100px;padding-right: 3px; border-right: 0.3px solid #ccc;">SignIn</button></a>
        </div>

        <div class="sign-up">
            <a href="<%=request.getContextPath() %>/signUp"> <button class="btn" style="border:none; background-color: white;margin-right: 50px; margin-left: -30px;" >SignUp</button></a>
        </div>
        </c:if>
        <c:if test="${customerId!=null }">
        <div class="sign-up">
         <a href="<%=request.getContextPath() %>/logout"> <button class="btn" style="border:none; background-color: white;margin-right: 50px; margin-left: -30px;">LogOut</button></a>
        </div>
        </c:if>
  </div>

  <nav>
    <ul class="nav">
      <li><a href="<%=request.getServletContext().getContextPath()%>/home">Home</a></li>
      <li><a href="<%=request.getContextPath() %>/home/pets">Pet</a>
        <ul>
          <c:forEach items="${cats1 }" var="c">
            <li><a href="<%=request.getContextPath() %>/home/${c.subCategories.toLowerCase() }">${c.subCategories}</a></li>
          </c:forEach>
          
        </ul>
      </li>
      <li><a href="<%=request.getContextPath() %>/home/accessories">Accessories</a>
        <ul>
        <c:forEach items ="${cats2 }" var ="c">
          <li><a href="<%=request.getContextPath() %>/home/${c.subCategories.toLowerCase() }">${c.subCategories }</a></li>
         
        </c:forEach>
        </ul>
      </li>
      <li><a href="#">NEWS</a></li>
      <li><a href="#">Contact</a>
       
      </li>
      <li><a href="<%=request.getServletContext().getContextPath()%>/home/contact">Contact</a></li>
    </ul>
  </nav>
  </div>