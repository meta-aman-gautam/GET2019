package com.ead_session_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class ShowStudentDetails
 */
@WebServlet("/ShowStudentDetails")
public class ShowStudentDetails extends HttpServlet {
	
	MyConnection connection = new MyConnection();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString ;
		
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	MyQuery objMyQuery = new MyQuery();
    	queryString =objMyQuery.showStudent();
    	
    	if(request.getParameter("id")==null){
 	    	
	    	try {
	    		PreparedStatement preStatement = connection.connObj.prepareStatement(queryString);
	    		ResultSet resultSet=  preStatement.executeQuery();
	    		while(resultSet.next()){
	    			out.println("|Student Id -"+resultSet.getInt(1)
	    					   +"|Student Name - "+resultSet.getString(2)+" "+resultSet.getString(3)
	    					   +"|Father's Name - "+resultSet.getString(4)
	    					   +"|Email - "+resultSet.getString(5)
	    					   +"|Class - "+resultSet.getString(6)
	    					   +"|Age - "+resultSet.getString(7)
	    					   +"<a href='http://localhost:8080/StudentOperation/rtest.html?id="+resultSet.getInt(1)
	    					   +"&name="+resultSet.getString(2)
	    					   +"&lname="+resultSet.getString(3)
	    					   +"&fname="+resultSet.getString(4)
	    					   +"&email="+resultSet.getString(5)
	    					   +"&classname="+resultSet.getInt(6)
	    					   +"&age="+resultSet.getInt(7)
	    					   +"'>Update values</a><br>");
	    			
	    		}
				out.println("<br><br><a href='index.html'>Back To Home</a><br><br>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	else{
  
			try {
				queryString = "SELECT * FROM studentdetails WHERE studentid = "+request.getParameter("id")+"";
				PreparedStatement preStatement = connection.connObj.prepareStatement(queryString);
				ResultSet resultSet=  preStatement.executeQuery();
				out.println("<html>");
	    		out.println("<head><h3> Update Details <h3></head>");
	    		out.println(queryString);
	    		out.println("</head>");
	    		out.println("<body>");
	    		out.println("<form action ='ShowStudentDetails' method ='POST'>");
	    		out.println("First Name - <input type='text' size ='30%' value ="+request.getParameter("firstname")+"><br><br>");
	    		out.println("First Name - <input type='text' size ='30%' value ="+resultSet.getString(2)+"><br><br>");
	    		out.println("Last Name - <input type='text' size ='30%' value ="+resultSet.getString(3)+"><br><br>");
	    		out.println("Father Name - <input type='text' size ='30%' value ="+resultSet.getString(4)+"><br><br>");
	    		out.println("Email - <input type='text' size ='30%' value ="+resultSet.getString(5)+"><br><br>");
	    		out.println("Class - <input type='text' size ='30%' value ="+resultSet.getInt(6)+"><br><br>");
	    		out.println("Age - <input type='text' size ='30%' value ="+resultSet.getInt(7)+"><br><br>");
	    		out.println("<input type='submit' value='update'><br><br>");
	    		out.println("</form>");
	    		out.println("</body>");
	    		out.println("</html>");
	    		
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName,lastName,fatherName,email;
		int age,studentclass,studentId;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		MyQuery objMyQuery = new MyQuery();
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		fatherName = request.getParameter("fathername");
		email = request.getParameter("email");
		studentclass = Integer.parseInt(request.getParameter("class"));
		age = Integer.parseInt(request.getParameter("age"));
		studentId= Integer.parseInt(request.getParameter("id"));
		
		String queryString = objMyQuery.updateDetails(studentId, firstName, lastName, email, fatherName, studentclass, age);
				
		try {
			PreparedStatement preStatement = connection.connObj.prepareStatement(queryString);
			preStatement.executeUpdate();
			out.print("**Database updated**");
			out.println("<a href='http://localhost:8080/StudentOperation/ShowStudentDetails?'>Update Database</a><br><br>");
			out.println("<a href='index.html'>Back To Home</a><br><br>");
		} 
		catch (MySQLIntegrityConstraintViolationException e) {
			out.print("**Sorry Email Already used Pls try again**");
			out.println("<a href='http://localhost:8080/StudentOperation/ShowStudentDetails?'>Try Again</a><br><br>");
			out.println("<a href='index.html'>Back To Home</a><br><br>");
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}




}
