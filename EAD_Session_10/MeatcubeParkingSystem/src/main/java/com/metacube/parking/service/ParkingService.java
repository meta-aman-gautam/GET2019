package com.metacube.parking.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import com.metacube.parking.dao.EmployeeDAO;
import com.metacube.parking.dao.ParkingDAO;
import com.metacube.parking.dao.PlanDAO;
import com.metacube.parking.dao.VehicleDAO;
import com.metacube.parking.model.Employee;
import com.metacube.parking.dto.DtoEmployee;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;

/**
 * The Class ParkingService. is the class which defines all the service method provided in
 * application 
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class ParkingService {
	
	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return boolean true
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	public boolean addEmployee(Employee employee) throws SQLIntegrityConstraintViolationException {

		boolean answer =false;
		EmployeeDAO employeeDB = new EmployeeDAO();
		try {
			employeeDB.insertEmployee(employee);
			answer= true;
		} catch (SQLIntegrityConstraintViolationException e) {
			throw e;
		} catch (Exception e) {
			System.out.println(e);
		}
		return answer;
	}

	/**
	 * Adds the vehicle.
	 *
	 * @param vehicle 
	 * @param email 
	 * @return boolean 
	 */
	public boolean addVehicle(Vehicle vehicle, String email) {

		boolean answer =false;
		VehicleDAO vehicleDB = new VehicleDAO();
		try {
			vehicleDB.insertVehicle(vehicle, email);
			answer = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return answer;
	}

	/**
	 * Gets the vehicle id.
	 *
	 * @param email the email
	 * @return the vehicle id
	 */
	public int getVehicleId(String email) {
		VehicleDAO vehicleDB = new VehicleDAO();
		int vehicleId = 0;
		try {
			vehicleId = vehicleDB.getVehicleId(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return vehicleId;
	}

	/**
	 * Adds the plan.
	 *
	 * @param plan the plan
	 * @param email the email
	 * @param index the index
	 * @return boolean true
	 */
	public boolean addPlan(Plan plan, String email, int index) {
        boolean answer = false;
		PlanDAO planDB = new PlanDAO();
		try {
			planDB.insertPlan(plan, email, index);
			answer= true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return answer;
	}

	/**
	 * Check authentication.
	 *
	 * @param email the email
	 * @param password the password
	 * @return boolean true
	 */
	public boolean checkAuthentication(String email, String password) {
		ParkingDAO parkingDB = new ParkingDAO();
		boolean answer = false;
		try {
			if (parkingDB.checkAuthentication(email, password)) {
				answer = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return answer;
	}

	/**
	 * Gets the user profile.
	 *
	 * @param email the email
	 * @return the user profile
	 */
	public DtoEmployee getUserProfile(String email) {
		try {
			return EmployeeDAO.getUserProfile(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Gets the friends profile.
	 *
	 * @param email the email
	 * @return the friends profile
	 */
	public LinkedList<DtoEmployee> getFriendsProfile(String email) {
		try {
			return EmployeeDAO.getFriendsProfile(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Update employee.
	 *
	 * @param email the email
	 * @param dtoemployee the dtoemployee
	 * @return boolean true
	 */
	public boolean updateEmployee(String email, DtoEmployee dtoemployee) {
		boolean answer = false;
		EmployeeDAO employeeDB = new EmployeeDAO();
		try {
			employeeDB.updateEmployee(email, dtoemployee);
			answer = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return answer;
	}

	/**
	 * Gets the photo url.
	 *
	 * @param email the email
	 * @return the photo url
	 */
	public String getPhotoUrl(String email) {
		try {
			return EmployeeDAO.getPhotoUrl(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Update photo url.
	 *
	 * @param url the url
	 * @param email the email
	 * @return boolean true
	 */
	public boolean updatePhotoUrl(String url, String email) {
		boolean asnwer = false;
		try {
			return EmployeeDAO.updatePhotoUrl(url, email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return asnwer;
	}

	/**
	 * Gets the name.
	 *
	 * @param email the email
	 * @return the name
	 */
	public String getName(String email) {
		try {
			return EmployeeDAO.getName(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}