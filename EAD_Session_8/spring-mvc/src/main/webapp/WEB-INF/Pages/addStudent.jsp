<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css" >

    <title>Student Details!</title>

<style>
 .error {
	color: #ff0000;
	font-weight: bold;
 }
</style>
<script>
 function done(){
	 alert("Student Added");
 }
</script>

</head>
  <body>
    <div class="container" align="center">
  <!-- Content here -->
 
  <form:form modelAttribute="studentDetails">
  <form:errors  cssClass="error" />
  <div class="form-group " align="center">
  
  <h4>Add Student Details</h4>
 </div>
   	<div class="form-group row col-md-5"  >
    	<form:label path="firstName">* First Name</form:label>
    	<form:input path="firstName"  cssClass="form-control"  placeholder="Enter FirstName" />
    	<form:errors path="firstName" cssClass="error" />
 	</div>
    <div class="form-group row col-md-5">
      <form:label path="lastName">* Last Name</form:label>
      <form:input path="lastName" cssClass="form-control" placeholder="Enter LastName" />
      <form:errors path="lastName" cssClass="error" />
   </div>
   <div class="form-group row col-md-5">
      <form:label path="fatherName">* Father's Name</form:label>
      <form:input path="fatherName" cssClass="form-control"  placeholder="Enter Father's Name" />
      <form:errors path="fatherName" cssClass="error" />
   </div>
   <div class="form-group row col-md-5">
     <form:label path="email">* Email address</form:label>
     <form:input path="email" cssClass="form-control" type ="email" placeholder="Enter Email" />
      <form:errors path="email" cssClass="error" />
   </div>
   <div class="form-group row col-md-5">
     <form:label path="studentClass">* Class</form:label>
     <form:input path="studentClass" cssClass="form-control" type="number" placeholder="Enter Class" />
     <form:errors path="studentClass" cssClass="error" />
   </div>
   <div class="form-group row col-md-5">
     <form:label path="age">* Age</form:label>
     <form:input path="age"  cssClass="form-control" type="number"  placeholder="Enter Age" />
     <form:errors path="age" cssClass="error" />
   </div>
   <button type="submit" Class="btn btn-primary" onclick=done() >Submit</button>
</form:form>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
  </body>
</html>