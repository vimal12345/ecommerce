<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*"%>
<%@ page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project.model.*"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item</title>
</head>

<body>
	<nav class="navbar navbar-default">  
	<div class="container-fluid">
		   
		<div class="navbar-header">
			     
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>         <span class="icon-bar"></span>
				        <span class="icon-bar"></span>      
			</button>
			<a class="navbar-brand" href="#">vimal electronics</a>
		</div>
	</div>
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}/"><span
					class="glyphicons glyphicons-home"></span>Home</a></li>
			<security:authorize access="isAnonymous()">
				<li><a href="${pageContext.request.contextPath}/register">Register</a></li>
			</security:authorize>
			<li><a href="${pageContext.request.contextPath}/Product">Product</a></li>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="${pageContext.request.contextPath}/admin/Category">Add
						Category</a></li>
			</security:authorize>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/user/cart">
						<span class="glyphicon gliphicon-cart"></span>Cart

				</a></li>

				<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</security:authorize>
			<security:authorize access="isAnonymous()">
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</security:authorize>
		</ul>
	</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<center>
				<marquee behavior="scroll" direction="left">
					<h3>Welcome To Shopping</h3>
				</marquee>
			</center>
		</div>
	</div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<center>
					<img src="resources/image/a.jpg">
				</center>
			</div>
			<div class="item">
				<center>
					<img src="resources/image/b.jpg">
				</center>
			</div>
			<div class="item">
				<center>
					<img src="resources/image/c.jpg">
				</center>
			</div>

		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span> </a>
	</div>

	<c:forEach items="${productList}" var="product">
		<div class="col-sm-3">
			<img alt="${product.productName}"
				src="${pageContext.request.contextPath}/resources/image/${product.productName}.jpg"
				width="260px" height="300px" class="img-thumbnail">
		</div>
	</c:forEach>

</body>
</html>
