<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<div class="error">${errorMessage}
		<form action="${pageContext.request.contextPath}/login" method="post">
			<input type="text" name="username" placeholder="Username" required><br>
			<input type="password" name="password" placeholder="Password"
				required><br> <input type="submit" value="Login">
		</form>
	</div>
	<%
	if (request.getAttribute("error") != null) {
	%>
	<p style="color: red">${error}</p>
	<%
	}
	%>
</body>
</html>