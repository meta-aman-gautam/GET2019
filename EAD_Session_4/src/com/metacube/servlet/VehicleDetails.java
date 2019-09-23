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
import com.metacube.model.VehicleDetailsPojo;

/**
 * This class is used to create servlet for vechile Details Servlet
 * implementation class VehicleDetails
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
@WebServlet("/VehicleDetails")
public class VehicleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Non parametrized constructor
	 */
	public VehicleDetails() {}

	/**
	 * This method is used to create servlet for vechile Details 
	 * 
	 * HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String vehicle_name = request.getParameter("vehiclename");
		String select_type = request.getParameter("selectType");
		String vehicle_number = request.getParameter("vehiclenumber");
		int employe_Id = Integer.parseInt(request.getParameter("employeId"));
		String identification = request.getParameter("identification");
		DataOperations dataOperations = new DataOperations();
		response.setContentType("text/html");
		
		VehicleDetailsPojo vehicleDetailsData = new VehicleDetailsPojo(employe_Id, vehicle_name, select_type, vehicle_number, identification);
		HttpSession session = request.getSession();

		int updatedValue = dataOperations.vehicleDetail(vehicleDetailsData);
		session.setAttribute("vtype", select_type);
		session.setAttribute("vnumber", vehicle_number);
		if (updatedValue == 1) {
			response.sendRedirect("ChoosePlan.jsp");
		} else {
			out.print("Vehicle Data Not Added");
			out.print("<br><br>");
			out.print("Email Id already exist");
		}
	}
}
