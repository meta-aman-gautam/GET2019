package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.DAO.DataOperations;
import com.metacube.model.Employee;

/**
 * This class is used to create servlet for all employee data.
 * Servlet implementation class EmployeeDetails
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new employee details.
     */
    public EmployeeDetails() {}

	/**
	 * This method is used to add all data of employee.
	 * HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String full_name = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long contact_number = Long.parseLong(request.getParameter("contactnumber"));
		String organization = request.getParameter("selectOrganization");
			
		Employee emp = new Employee(full_name, gender, email, password, contact_number, organization);
		
		int updateValue = DataOperations.insertEmployeeDetail(emp);

		if (updateValue == 1) {	
			out.print(" Data Successfully Added");
			out.print("<br><br>");
			out.print("Click here to ");
			out.print("<a href = 'index.html'>login</a>");
		} else {
			out.print("Student Data Not Added");
			out.print("<br><br>");
			out.print("Email Id already exist");
		}
	}
			
}
