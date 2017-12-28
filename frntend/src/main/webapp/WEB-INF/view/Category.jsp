<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<form:form
		action="${pageContext.request.contextPath}/admin/AddCategory"
		modelAttribute="category">
		<table align="center" cellspacing="2">
			<tr>
				<td colspan="2">Category Module</td>
			</tr>

			<tr>
				<td>Category Name</td>
				<td><form:input path="catName" class="form-control"
						style="width:300px;" /></td>
			</tr>
			<tr>
				<td>Category Desc</td>
				<td><form:input path="catDesc" class="form-control" /></td>
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
	<br>
	<br>
	<table cellspacing="6" align="center" class="table table-responsive">
		<thead>
			<tr>
				<td>CategoryName</td>
				<td>Category Description</td>
				<td>Operation</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.catName}</td>
					<td>${category.catDesc}</td>
					<td><a class="btn btn-danger"
						href="${pageContext.request.contextPath}/admin/deleteCategory/${category.id}">DELETE</a>
						| <a class="btn btn-info"
						href="${pageContext.request.contextPath}/admin/updateCategory/${category.id}">UPDATE</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>