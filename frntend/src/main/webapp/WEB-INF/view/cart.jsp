<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class = "container">
		<table class="table table-hover">
			<thead>
				<tr>
					<td>Image</td>
					<td>Name</td>
					<td>Cost</td>
					<td>Quantity</td>
					<td>Action</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${cart.cartItems}" var="cart">
					<tr>
						<td><img alt="${product.productName}"
							src="${pageContext.request.contextPath}/resources/image/${cart.product.productName}.jpg"
							width="260px" height="300px" class="img-thumbnail"></td>
						<td>${cart.product.productName}</td>
						<td>${cart.subTotal}</td>
						<td>${cart.quantity}</td>
						<td><a href="${pageContext.request.contextPath}/user/delete/cartItem/${cart.id}" class="btn btn-danger">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-sm-6">
				<h3>Grand Total : ${cart.grandTotal}</h3>
			</div>
			<div class="col-sm-6">
				<c:if test="${cart.cartItems == null}">
					<c:set var="disabled" value="disabled"></c:set>
				</c:if>
				<a href="checkout" class="btn btn-primary" style="right: 50px" ${disabled} >CHECK OUT</a>	
			</div>
		</div>
		
	</div>
</body>
</html>