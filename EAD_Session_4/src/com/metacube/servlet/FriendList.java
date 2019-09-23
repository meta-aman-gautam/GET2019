package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;
import com.metacube.model.Employee;

/**
 * This class is used to make servlet for show employee friend list. Servlet
 * implementation class FriendList
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
@WebServlet("/FriendList")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new friend list.
	 */
	public FriendList() {}

	/**
	 * This method is used to show all friend of employee.
	 * 
	 * HttpServlet#doGet(HttpServletRequest request, HttpServletResponseresponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		if (request.getParameter("emailid") != null) {

			Employee emp = DataOperations.empDetailsWithEmail((String) request.getParameter("emailid"));
			request.setAttribute("fullName", emp.getFullName());
			request.setAttribute("email", emp.getEmail());
			request.setAttribute("contact_number", emp.getContactNumber());
			RequestDispatcher rd = request.getRequestDispatcher("/FriendProfile.jsp");
			rd.forward(request, response);
		} else {
			int empId = Integer.parseInt(session.getAttribute("empId").toString());
			String organizationName = null;
			ResultSet rs = DataOperations.showEmployee(empId);
			try {
				rs.next();
				organizationName = rs.getString(7);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			List<Employee> friend = DataOperations.showFriendList(empId,organizationName);
			out.print("<html><head><style> td { padding: 15px; } table { border = 2px } </style></head><body>");
			out.print("<h1> Friend List <h1>");
			for (int index = 0; index < friend.size(); index++) {
				out.print("<table><tr><td>"
						+ friend.get(index).fullName
						+ "</td>"
						+ "<td> <a href='http://localhost:8080/EADsession4/FriendList?emailid="
						+ friend.get(index).getEmail()
						+ "'>View profile</a></td></tr>");
			}
			out.print("</table></body></html>");
		}
		out.print("<p style='font-size:80%'>  please <a href='homepage.jsp'>click here </a> to go back</p>");
	}

}
