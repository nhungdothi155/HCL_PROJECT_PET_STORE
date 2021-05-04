<%@page import="java.util.stream.Collectors"%>
<%@page import="com.pet.store.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.pet.store.service.impl.CategoryServiceImpl"%>
<%@page import="com.pet.store.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%
CategoryService c = new CategoryServiceImpl();
List<Category> cats = c.getAllCategories();
request.setAttribute("cats1", cats.stream().filter(k -> k.getCategoryName().equals("PETS")).collect(Collectors.toList()));
request.setAttribute("cats2", cats.stream().filter(k -> k.getCategoryName().equals("ACCESSORIES")).collect(Collectors.toList()));


%>
<form class="form-horizontal"  method="get"  action="<%=request.getContextPath()%>/admin/products/${request}" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->
<legend>PRODUCTS</legend>
<c:if test="${pId!=null }" >
<input type="hidden" name="pId" value="${pId}" >
</c:if>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
  <div class="col-md-4">
  
  <input id="product_name" value="${pName}" name="pName" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">PRODUCT DESCRIPTION FR</label>  
  <div class="col-md-4">
  <input id="product_name_fr" value="${pDes}" name="pDes" placeholder="PRODUCT DESCRIPTION FR" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_id">CATEGORY</label>  
  <div class="col-md-4">
<c:if test="${fn:contains(url,'pets') }">
 <select class ="form-control inputstl" id="categoryId" name="pCat">
 <c:forEach items="${cats1 }" var="cat">
 	<option value="${cat.categoryId }">${cat.categoryName }/${cat.subCategories}</option>
 </c:forEach>
 </select>
</c:if>
<c:if test="${fn:contains(url,'accessories') }">
 <select class ="form-control inputstl" id="categoryId" name="pCat">
 <c:forEach items="${cats2 }" var="cat">
 	<option value="${cat.categoryId}">${cat.categoryName }/${cat.subCategories}</option>
 </c:forEach>
 </select>
</c:if>
    
  </div>
</div>
<c:if test="${fn:contains(url, 'accessories')}">
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">PRODUCT BRAND</label>  
  <div class="col-md-4">
  <input id="brand" name="pBrand" value="${pBrand}" placeholder="PRODUCT BRAND" class="form-control input-md" required="" type="text">
    
  </div>
</div>
</c:if>

<!-- Text input-->
<c:if test="${fn:contains(url, 'accessories')}">
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">PRODUCT MATERIAL</label>  
  <div class="col-md-4">
  <input id="material" name="pMaterial" value="${pMaterial}" placeholder="PRODUCT MATERIAL" class="form-control input-md" required="" type="text">
    
  </div>
</div>
</c:if>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">PRODUCT ORIGIN</label>  
  <div class="col-md-4">
  <input id="origin" name="pOrigin" value="${pOrigin}" placeholder="PRODUCT ORIGIN" class="form-control input-md" required="" type="text">
    
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">PRODUCT PRICE</label>  
  <div class="col-md-4">
  <input id="" name="pPrice" value="${pPrice}" placeholder="PRODUCT PRICE" class="form-control input-md" required="" type="text">
    
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">AVAILABLE QUANTITY</label>  
  <div class="col-md-4">
  <input id="" name="pNumbers" value="${pNumbers}" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="text">
    
  </div>
</div>


<!-- Text input-->
<c:if test="${fn:contains(url, 'pets')}">
<div class="form-group">
  <label class="col-md-4 control-label" for="product_weight">PRODUCT WEIGHT</label>  
  <div class="col-md-4">
  <input id="product_weight" value="${pWeight}" name="pWeight" placeholder="PRODUCT WEIGHT" class="form-control input-md" required="" type="text">
    
  </div>
</div>
</c:if>

<!-- Textarea -->
<c:if test="${fn:contains(url, 'pets')}">
<div class="form-group">
  <label class="col-md-4 control-label" for="product_description">PRODUCT AGE</label>
  <div class="col-md-4">                     
  <input id="product_weight" value="${pAge}" name="pAge" placeholder="PRODUCT AGE" class="form-control input-md" required="" type="text">
  </div>
</div>
</c:if>

<!-- Textarea -->
<c:if test="${fn:contains(url, 'accessories')}">
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">PRODUCT STATE</label>
  <div class="col-md-4">                     
<select class ="form-control inputstl" id="categoryId" name="pState" >
 	<option value="NEW">NEW</option>
 	<option value="USED">USED</option>
 </select>

  </div>
</div>
</c:if>
<!-- test if insert or update -->
<c:if test="${fn:contains(url, 'add')}">    
 <!-- File Button --> 
<div class="form-group">
  <div style="color:red">You should consider when upload image , because you can not fix it</div>
  <label class="col-md-4 control-label" for="filebutton">main_image</label>
  <div class="col-md-4">
    <input id="filebutton1"  onchange="onChange(this.value)"  name="img1" class="input-file" type="file" required>
  </div>
</div>
<!-- File Button --> 
<div class="form-group">
<div style="color:red">You should consider when upload image , because you can not fix it</div>
  <label class="col-md-4 control-label" for="filebutton">auxiliary_images 1</label>
  <div class="col-md-4">
    <input id="filebutton2"  onchange="onChange(this.value)"  name="img2" class="input-file" type="file" required>
  </div>
</div>
<!-- File Button --> 
<div class="form-group">
<div style="color:red">You should consider when upload image , because you can not fix it</div>
  <label class="col-md-4 control-label" for="filebutton">auxiliary_images 2</label>
  <div class="col-md-4">
    <input id="filebutton3"  onchange="onChange(this.value)"  name="img3" class="input-file" onchange="onChange(this.value)" type="file" required>
  </div>
</div>
<!-- File Button --> 
<div class="form-group">
<div style="color:red" >You should consider when upload image , because you can not fix it</div>
  <label class="col-md-4 control-label" for="filebutton">auxiliary_images 3</label>
  <div class="col-md-4">
    <input id="filebutton4"  onchange="onChange(this.value)"  name="img4" class="input-file" onchange="onChange(this.value)"  type="file" required>
  </div>
</div>
</c:if>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Save The Information</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Save</button>
  </div>
  </div>

</fieldset>
</form>


</body>
<script>
function onChange(value){
 var img1 =document.getElementById("filebutton1").value  
 var img2 =document.getElementById("filebutton2").value 
 var img3 =document.getElementById("filebutton3").value  
 var img4 =document.getElementById("filebutton4").value 
	if(img1===img2){
		document.getElementById("filebutton2").value =null;
	}
	if(img1=== img3){
		document.getElementById("filebutton3").value =null;
	}
	if(img1=== img4){
		document.getElementById("filebutton4").value =null;
	}
	if(img2=== img3){
		document.getElementById("filebutton3").value =null;
	}
	if(img2=== img4){
		document.getElementById("filebutton4").value =null;
	}
	if(img3=== img4){
		document.getElementById("filebutton4").value =null;
	}
	
	
}
</script>
</html>