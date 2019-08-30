package com.ead_session_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudentDetails")
public class AddStudentDetails extends HttpServlet {

	MyConnection connection = new MyConnection();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out = response.getWriter();
    	
    	response.setContentType("text/html");
    	
    	
		String firstName,lastName,email,fatherName,queryString;
		int  age,studentclass ;
		
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		fatherName = request.getParameter("fathername");
		email = request.getParameter("email");
		studentclass = Integer.parseInt(request.getParameter("class"));
		age = Integer.parseInt(request.getParameter("age"));
		
		MyQuery objMyQuery = new MyQuery() ;

		queryString =objMyQuery.addStudent(firstName, lastName, email, fatherName, studentclass,age);
		
		try {
			AddStudentDetail(queryString);
			out.println("Student- "+firstName+" "+lastName+" Added Succesfully .");
			out.println("<a href='index.html'>Back To Home</a><br><br>");
		} 
		catch (MySQLIntegrityConstraintViolationException e) {
			out.print("No duplicate emails id can be added \n");
			out.println("<a href='addstudent.html'>Add STUDENT DETAILS</a><br><br>");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
    
    
	public void AddStudentDetail(String queryString) throws SQLException{
		PreparedStatement prestatement = connection.connObj.prepareStatement(queryString);
		prestatement.executeUpdate();
	}
	
	
}