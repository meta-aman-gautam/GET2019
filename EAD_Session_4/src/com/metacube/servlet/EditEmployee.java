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
 * Servlet for Edit employee data.
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a employee editing class.
	 */
	public EditEmployee() {}

	/**
	 * This method is used to edit all data of employee.
	 * HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();
			int empId = Integer.parseInt(session.getAttribute("empId").toString());
			ResultSet rs = DataOperations.showEmployee(empId);
			rs.next();
			String fullName = rs.getString(2);
			String gender = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			long contact_number = rs.getLong(6);
			String organization = rs.getString(7);
			request.setAttribute("fullName", fullName);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("contact_number",String.valueOf(contact_number));
			RequestDispatcher rd = request.getRequestDispatcher("/EditEmployeeData.jsp");
			rd.forward(request, response);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
