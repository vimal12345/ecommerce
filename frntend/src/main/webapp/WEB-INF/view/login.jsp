<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp"%>

	<center>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div class="form-group">
				<label for="username">User name</label> <input type="text"
					class="form-control" name="username" style="width: 300px;">
			</div>
			<div class="form-group">
				<label for="pa
				ssword">Password</label> <input type="password"
					class="form-control" name="password" style="width: 300px;">
			</div>
			<div class="form-group">
				<button type="submit" name="login" class="btn btn-default">Submit</button>
			</div>
		</form>
	</center>
</body>
</html>