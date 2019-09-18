<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Student Details</h1>
        
		<br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Student's Email</th>
				<th>Student's Class</th>
				<th>Student's Age</th>
			</tr>

			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.getFirstName()}</td>
					<td>${student.lastName}</td>
					<td>${student.fatherName}</td>
					<td>${student.email}</td>
					<td>${student.studentClass}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>