<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<script src="validation.js"></script>
	<style>
		td {
			padding: 15px;
		}

		textarea {
			width: 175px;
		}
	</style>
</head>

<body>
	<div id="1" align="center">
		<form action="UpdateEmployee" method="POST" name="Emplopyeform" onsubmit="return empFormValidation()">

			<h1>Employee details</h1>
			<table>
				<tr>
					<td>Full Name :</td>
					<td><input type="text" placeholder="Please enter full name" name="fullname" id="name"
							value="<%=request.getAttribute("fullName")%>" required>
						<br /> <span id="ename"></span></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email" placeholder="email" name="email" id="email"
							value="<%=request.getAttribute("email")%>" readonly>
						<br /> <span id="eemail"></span></td>
				</tr>
				<tr>
					<td>New Password :</td>
					<td><input type="password" placeholder="password" name="password" id="password"
							value=<%=request.getAttribute("password")%>> </br> <span id="epassword"></span></td>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><input type="password" placeholder="confirm password" name="confirmpassword"
							id="confirm_password" value=<%=request.getAttribute("password")%>> <br /> <span
							id="econfirm_password"></span></td>
				</tr>
				<tr>
					<td>Contact No. :</td>
					<td><input type="tel" placeholder="contact number" name="contactnumber" id="number"
							value=<%=request.getAttribute("contact_number")%>> <br />
						<span id="enumber"></span></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button type="submit">Update</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>