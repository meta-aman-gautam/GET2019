<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "C" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <title>Student Details!</title>
  </head>
  <body>
    <div  align="center">
  <!-- Content here -->
 <form >
 <table >
 	<th>First_Name</th>
 	<th>Last_Name</th>
 	<th>Father_Name</th>
 	<th>Email</th>
 	<th>Student_Class</th>
 	<th>Age</th>
	<C:forEach var="list" items="${list}">
	<tr>
		<td><C:out value="${list.firstName}"></C:out></td>
		<td><C:out value="${list.lastName}"></C:out></td>
		<td><C:out value="${list.fatherName}"></C:out></td>
		<td><C:out value="${list.email}"></C:out></td>
		<td><C:out value="${list.studentClass}"></C:out></td>
		<td><C:out value="${list.age}"></C:out></td>
	</tr> 
</C:forEach>
</table>
</form>
</div>
</body>
</html>