<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp"%>

	<center>
		<form action="${pageContext.request.contextPath}/admin/uploadFile"
			method="POST" enctype="multipart/form-data">
			File to upload: <input type="file" name="file"> 
			<input type="submit" value="Upload">
		</form>
	</center>
</body>
</html>