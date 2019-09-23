package com.metacube.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is used to create filter for validate all sevlet. Servlet Filter
 * implementation class ServletFilters.
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
@WebFilter(urlPatterns = { "/EditEmployee", "/FriendList", "/ParkingPlan",
		"/UpdateEmployee", "/VehicleDetails", "/homepage.jsp",
		"/FriendProfile.jsp", "/VehicleDetails.jsp", "/ChoosePlan.jsp" })
public class ServletFilters implements Filter {

	/**
	 *Destroy method.to destroy the filter
	 */
	public void destroy() {}

	/**
	 * This method is used to create filter for all sevlet.
	 * 
	 * Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest requestOne = (HttpServletRequest) request;
		HttpServletResponse responseOne = (HttpServletResponse) response;

		HttpSession session = requestOne.getSession();
		String email = (String) session.getAttribute("email");

		if (email != null) {
			// pass the request along the filter chain
			chain.doFilter(requestOne, responseOne);
		} else {
			// if not logged in redirect to index page
			responseOne.sendRedirect("index.html");
		}
	}

	/**
	 * initialization of the filter(FilterConfig).
	 *
	 * @param fConfig the filter configuration
	 * @throws ServletException the servlet exception
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
