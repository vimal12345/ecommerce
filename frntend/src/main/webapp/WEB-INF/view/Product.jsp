<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<form:form
			action="${pageContext.request.contextPath}/admin/AddProduct"
			modelAttribute="product">
			<table align="center" cellspacing="2">
				<tr>
					<td colspan="2">Product Module</td>
				</tr>
				<form:hidden path="productId" />
				<tr>
					<td>Product Name</td>
					<td><form:input path="productName" class="form-control"
							style="width:300px;" /></td>
				</tr>
				<tr>
					<td>Product Desc</td>
					<td><form:input path="productDesc" class="form-control" /></td>
				</tr>
				<tr class="form-group">
					<td>Category</td>
					<td><form:select path="category.id"  class="form-control" multiple="false">
						<form:options items="${categories}" itemLabel="catName" itemValue="id"/>
					</form:select> </td>
				</tr>
				<tr>
					<td>Cost</td>
					<td><form:input path="cost" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" value="Insert" class="btn btn-default" />
						</center>
					</td>
				</tr>
			</table>
		</form:form>
	</security:authorize>
	<table cellspacing="2" align="center"
		class="table table-default table-responsive table-hover">
		<thead>
			<tr>
				<th>ProductName</th>
				<th>Images</th>
				<th>Product Description</th>
				<th>Cost</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.productName}</td>
					<td><img alt="${product.productName}"
						src="${pageContext.request.contextPath}/resources/image/${product.productName}.jpg"
						width="260px" height="300px" class="img-thumbnail"></td>
					<td>${product.productDesc}</td>
					<td>${product.cost}</td>
					<td><security:authorize access="hasRole('ROLE_ADMIN')">
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/admin/deleteProduct/${product.productId}">DELETE</a>
							<a class="btn btn-info"
								href="${pageContext.request.contextPath}/admin/updateProduct/${product.productId }">UPDATE</a>

						</security:authorize> <security:authorize access="hasRole('ROLE_USER')">
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/user/add/to/cart/${product.productId}">ADD
								TO CART</a>
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/show/product/${product.productId}">View</a>
						</security:authorize></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>