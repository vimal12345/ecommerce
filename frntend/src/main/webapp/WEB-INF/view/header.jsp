<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project.model.*" %>	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body>

	<% 
		List<Category> categories = new ArrayList<Category>();
		categories = (List<Category>)getServletContext().getAttribute("categoryList");
	%>
	
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
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<c:forEach items="${categories}" var="cat">
						<li><a href="${pageContext.request.contextPath}/getProductByCat/${cat.id}">${cat.catName}</a></li>
					</c:forEach>
				</ul>
			</li>
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

</body>
</html>