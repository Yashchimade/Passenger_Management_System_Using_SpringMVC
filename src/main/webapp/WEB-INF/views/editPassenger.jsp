<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Passenger</title>
</head>
<body>
	<h2>Edit Passenger</h2>
	<div class="error">${errorMessage}>
		<form action="${request.contextPath}/passenger/update" method="post">
			<input type="hidden" name="id" value="${passenger.id}"> <input
				type="text" name="name" value="${passenger.name}" required><br>
			<input type="text" name="gender" value="${passenger.gender}" required><br>
			<input type="text" name="country" value="${passenger.country}"
				required><br>
			<textarea name="aboutYou">${passenger.aboutYou}</textarea>
			<br>
			<input type="checkbox" id="mailingList" name="mailingList" value="true" ${passenger.mailingList ? 'checked' : ''}>
			<input type="submit" value="Update Passenger">
		</form>
	</div>
</body>
</html>