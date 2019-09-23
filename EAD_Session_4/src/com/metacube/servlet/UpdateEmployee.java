package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;


/**
 * This class is used to create servlet for update employee data. Servlet
 * implementation class UpdateEmployee
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new update employee.
	 */
	public UpdateEmployee() {}

	/**
	 * This method is used to create servlet for update employee data.
	 *  HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int empId = Integer.parseInt(session.getAttribute("empId").toString());
		String full_name = request.getParameter("fullname");
		String password = request.getParameter("password");
		long contact_number = Long.parseLong(request.getParameter("contactnumber"));
		DataOperations.updateEmployee(empId, full_name, password, contact_number);
		response.setContentType("text/html");
		out.print("<h1>Data successfully Update,   <a href = 'homepage.jsp'>Click hear</a> to Homepage</h1>");
	}
}
