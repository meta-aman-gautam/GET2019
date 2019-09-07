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

/**
 * Servlet implementation class SearchStudentDetails
 */
@WebServlet("/SearchStudentDetails")
public class SearchStudentDetails extends HttpServlet {
	
	MyConnection connection = new MyConnection();
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString = null ,firstName,lastName;
		ResultSet resultSet =null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<form action ='SearchStudentDetails"
				+ ""
				+ "' method ='POST'>");
		out.println("<h4 align ='right'>"
				+"<input type='text' name ='fname' value ='"+request.getParameter("firstname")+"' size='17%' readonly>" 
				+ "<input type='text'name ='lname' value ='"+request.getParameter("lastname")+"' size='17%' readonly><br>"
				+"<input type='number' name='class' minvalue='1' maxvalue='100'>"
				+ "<input type='submit' value='FILTER VIA CLASS'>"
				+ "</h4>");
		out.println("</form>");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		MyQuery objMyQuery = new MyQuery();
		queryString= objMyQuery.SearchByName(firstName, lastName);
		try {
			PreparedStatement preStatement = connection.getConnObj().prepareStatement(queryString);
			resultSet =preStatement.executeQuery();
			out.println("<h2>Searched Student Details</h2>");
			while(resultSet.next()){
				out.println("<h5>Student Name : "+resultSet.getString(2)+" "+resultSet.getString(3)+"<br>");
				out.println("Father's Name : "+resultSet.getString(4)+"<br>");
				out.println("Email Address : "+resultSet.getString(5)+"<br>");
				out.println("Student Class  : "+resultSet.getInt(6)+"<br>");
				out.println("Student Age : "+resultSet.getInt(7)+"<br><br><br></h5>");
			}
			out.println("<a href='http://localhost:8080/StudentOperation/searchstudent.html'>Search Again</a><br><br>");
			out.println("<a href='index.html'>Back To Home</a><br><br>");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString = null ,firstName,lastName;
		int classname;
		ResultSet resultSet =null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		firstName = request.getParameter("fname");
		lastName = request.getParameter("lname");
		classname = Integer.parseInt(request.getParameter("class"));
		
		MyQuery objMyQuery = new MyQuery();
		queryString= objMyQuery.SearchByClass(firstName, lastName,classname);
		try {
			PreparedStatement preStatement = connection.getConnObj().prepareStatement(queryString);
			resultSet =preStatement.executeQuery();
			out.println("<h2>Searched Student Details via Class</h2>");
			while(resultSet.next()){
				out.println("<h5>Student Name : "+resultSet.getString(2)+" "+resultSet.getString(3)+"<br>");
				out.println("Father's Name : "+resultSet.getString(4)+"<br>");
				out.println("Email Address : "+resultSet.getString(5)+"<br>");
				out.println("Student Class  : "+resultSet.getInt(6)+"<br>");
				out.println("Student Age : "+resultSet.getInt(7)+"<br><br><br></h5>");
			}
			out.println("<a href='http://localhost:8080/StudentOperation/searchstudent.html'>Search Again</a><br><br>");
			out.println("<a href='index.html'>Back To Home</a><br><br>");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
