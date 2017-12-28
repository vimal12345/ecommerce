<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<%@include file="header.jsp"%>

	<center>
		<springForm:form action="${pageContext.request.contextPath}/adduser"
			modelAttribute="user" method="POST">
			<div class="form-group">
				<springForm:label for="name" path="FirstName">FirstName</springForm:label>
				<springForm:input type="text" class="form-control" path="FirstName"
					style="width:300px;" />
			</div>
			<div class="form-group">
				<springForm:label for="name" path="Lastname">LastName</springForm:label>
				<springForm:input type="text" class="form-control" path="Lastname"
					style="width:300px;" />
			</div>
			<div class="form-group">
				<springForm:label for="username" path="UserName">User name</springForm:label>
				<springForm:input type="text" class="form-control" path="UserName"
					style="width:300px;" />
			</div>
			<div class="form-group">
				<springForm:label for="email" path="Email">Email</springForm:label>
				<springForm:input type="text" class="form-control" path="Email"
					style="width:300px;" />
			</div>
			<div class="form-group">
				<springForm:label for="password" path="Password">Password</springForm:label>
				<springForm:input type="password" class="form-control"
					path="Password" style="width:300px;" />

			</div>
			<div class="form-group">
				<springForm:button type="submit" name="register"
					class="btn btn-default">Submit</springForm:button>
			</div>
		</springForm:form>

	</center>
</body>
</html>