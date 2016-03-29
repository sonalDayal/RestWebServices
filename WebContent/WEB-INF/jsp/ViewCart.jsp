<!DOCTYPE html> 
<html>
    <head>   
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/productListJs.js"></script>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<script type="text/javascript" language="JavaScript">
			
		</script>
	</head>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Cart</title>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="60">
<form name="frm_product_list" id="frm_product_list" method="post" action="" >
				<div class="jumbotron col-xs-12">
				  <div class="container text-center">
					<h1>Online DemoCart</h1>      
					 </div>
				</div>

				<nav class="navbar navbar-inverse col-xs-12">
				  <div class="collapse navbar-collapse" id="myNavbar">
					  <ul class="nav navbar-nav">
						<li> <a href="#">Home</a></li>
						<li class="active"><a href="#Products">Products</a></li>
					  </ul>
					  <ul class="nav navbar-nav navbar-right">
						<li><a href="#" ><span class="glyphicon glyphicon-user"></span> Register</a></li>
						<li><a href="#" id="submit"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
						<li><a href="#Contact">Contact</a></li>
					  </ul>
					</div>
				 
				</nav>
				  <div align =left class="container text-center">
					<h2>View Your Cart</h2>      
					 </div>
				</div>
    <div align="center">
 
            
   
             
    		 <c:forEach items="${prDetails}" var="country">
       		 <option value="${country.key}">${country.value}</option>
   			 </c:forEach>
			
    
    </div>
    	</form>
</body>

</html>
