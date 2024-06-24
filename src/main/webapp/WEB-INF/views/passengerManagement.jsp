<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger Management</title>
<script>
	function validateForm() {
		var name = document.forms["passengerForm"]["name"].value;
		var gender = document.forms["passengerForm"]["gender"].value;
		var country = document.forms["passengerForm"]["country"].value;

		if (name == "" || gender == "" || country == "") {
			alert("Name, Gender, and Country must be filled out");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h3>Passenger Details</h3>
	<div class="container">
		<form name="passengerForm"
			action="${pageContext.request.contextPath}/passengers" method="post"
			onsubmit="return validateForm()">
			User Name: <input type="text" name="name" required><br>
			<br> Gender: <input type="radio" id="male" name="gender"
				value="Male" required> <label for="male">Male</label> <input
				type="radio" id="female" name="gender" value="Female" required>
			<label for="female">Female</label><br> <br> Select a
			country: <select name="country" required>
				<option value="">Select</option>
				<option value="USA">USA</option>
				<option value="India">India</option>
				<option value="India">Canada</option>

			</select><br> <br> About You:<br>
			<textarea name="aboutYou" rows="3" cols="30"></textarea>
			<br> <br> 
			
			<input type="checkbox" id="mailingList" name="mailingList" value="true"> 
				<label for="mailingList">Would you like to join our mailing list?</label><br> 
				<input type="submit" value="Submit">
		</form>
	</div>

	<h3>Passenger List</h3>
	<div class="container">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Country</th>
				<th>About You</th>
				<th>Mailing List</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${passengers}" var="passenger">
				<tr>
					<td>${passenger.name}</td>
					<td>${passenger.gender}</td>
					<td>${passenger.country}</td>
					<td>${passenger.aboutYou}</td>
					<td>${passenger.mailingList ? 'Yes' : 'No'}</td>
					<td><a
						href="${pageContext.request.contextPath}/passengers/edit/${passenger.id}">Edit</a>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/passengers/delete/${passenger.id}"
							method="post">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>