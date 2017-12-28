<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.productName}</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-lg-5">
				<img alt="${product.productName}" class="img-thumbnail"
					src="${pageContext.request.contextPath}/resources/image/${product.productName}.jpg" height="300px" width="350px">
			</div>
			<div class="col-lg-7">
				<pre>
					<h2>${product.productName}</h2>
				</pre>
				<br>
				<h4>${product.cost}</h4>
				<br>
				<p>${product.productDesc}</p>
				<br> <a class="btn btn-danger"
					href="${pageContext.request.contextPath}/user/add/to/cart/${product.productId}">ADD
					TO CART</a>
			</div>
		</div>
	</div>

</body>
</html>