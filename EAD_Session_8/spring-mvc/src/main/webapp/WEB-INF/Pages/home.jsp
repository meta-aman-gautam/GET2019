<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div class="container" align="center">
  <!-- Content here -->
 
<h3>${welcome}</h3>
  <br><button type="button" class="btn btn-success" onclick="window.location.href = 'home/addStudent';">Add Student</button>
  <br><br><button type="button" class="btn btn-success" onclick="window.location.href = 'home/showStudent';" >Show Student</button>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
  </body>
</html>