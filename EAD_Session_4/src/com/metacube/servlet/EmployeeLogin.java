package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;

/**
 * This class is used to make servlet for employee login page. Servlet
 * implementation class EmployeeLogin
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee login.
	 */
	public EmployeeLogin() {}

	/**
	 * This method to check email or password valid or not if valid then send
	 * user to homepage.
	 * 
	 * HttpServlet#doPost(HttpServletRequest request, HttpServletResponseresponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int empId = DataOperations.loginCheck(email, password);
		boolean flag = DataOperations.SecondTimeloginCheck(email);

		HttpSession session = request.getSession();
		session.setAttribute("empId", String.valueOf(empId));
		session.setAttribute("email", email);

		if (empId > 0) {
			if (flag) {
				response.sendRedirect("VehicleDetails.jsp");
			} else {
				response.sendRedirect("homepage.jsp");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid email or password');");
			out.println("</script>");
		}
	}

}
