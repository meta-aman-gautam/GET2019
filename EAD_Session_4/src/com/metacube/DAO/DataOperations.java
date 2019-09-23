package com.metacube.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.model.Employee;
import com.metacube.model.VehicleDetailsPojo;

/**
 * This class is used for varies operation on data base.
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class DataOperations {

	public static ConnectionToDbms obj = new ConnectionToDbms();
	public static Connection connObj = obj.connectionObject();

	/**
	 * This method is used to insert employee details in data base.
	 * @param emp, object of employee
	 * @return, this return no of inserted data.
	 */
	public static int insertEmployeeDetail(Employee emp) {
		int noOfUpdate = 0;
		try {
			Statement stmt = connObj.createStatement();
			PreparedStatement pstmt = connObj.prepareStatement(Query.employeeInsert());
			pstmt.setString(1, emp.getFullName());
			pstmt.setString(2, emp.getGender());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPassword());
			pstmt.setLong(5, emp.getContactNumber());
			pstmt.setString(6, emp.getOrganization());
			noOfUpdate = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noOfUpdate;
	}

	/**
	 * This method is used to check email id or password valid or not.
	 * @param email, This email of employee.
	 * @param password, password of employee.
	 * @return, empId of employee.
	 */
	public static int loginCheck(String email, String password) {
		int empId = 0;
		try {

			Statement stmt = connObj.createStatement();
			ResultSet rs = stmt.executeQuery(Query.login(email, password));
			rs.next();
			if (rs.getString(1) != null) {
				empId = rs.getInt(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empId;
	}

	/**
	 * This method is used to check employee login on first time or not. 
	 * @param email, email of employee.
	 * @return, return true if first time login.
	 */
	public static boolean SecondTimeloginCheck(String email) {
		boolean answer = true;
		ResultSet rs = null;
		try {
			Statement stmt = connObj.createStatement();
			rs = stmt.executeQuery(Query.SecondTimelogin(email));
			if (rs.next()) {
				answer= false;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	/**
	 * This method is used to insert vehicle detail in database.
	 * @param data, object of vechileDetails
	 * @return, this return no of updated value.
	 */
	public static int vehicleDetail(VehicleDetailsPojo data) {
		int noOfUpdate = 0;
		try {
			Statement stmt = connObj.createStatement();
			PreparedStatement pstmt = connObj.prepareStatement(Query.vehicle());
			pstmt.setString(1, data.getVehicleName());
			pstmt.setString(2, data.getVehicleType());
			pstmt.setString(3, data.getVechicleNumber());
			pstmt.setInt(4, data.getEmpId());
			pstmt.setString(5, data.getIdentification());
			noOfUpdate = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noOfUpdate;
	}

	/**
	 * This method to show all employee of this id.
	 * @param id, employee id
	 * @return, resultset.
	 */
	public static ResultSet showEmployee(int id) {
		ResultSet rs = null;
		try {
			Statement stmt = connObj.createStatement();
			rs = stmt.executeQuery(Query.showEmployee(id));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * This method is used to update employee data.
	 * @param id, id of employee
	 * @param fullname, name of employee.
	 * @param password, password of employee.
	 * @param contact_number, contactNumber of employee.
	 * @return, no of updated data.
	 */
	public static int updateEmployee(int id, String fullname, String password,long contact_number) {
		int rs = 0;
		try {
			Statement stmt = connObj.createStatement();
			rs = stmt.executeUpdate(Query.UpdateEmployeeData(id, fullname, password, contact_number));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * This method is used to show all friend of employee.
	 * @param empId, employee id
	 * @param organizationName,
	 * @return, This return list of friends of employee.
	 */
	public static List<Employee> showFriendList(int empId, String organizationName) {

		List<Employee> friendList = new ArrayList<Employee>();

		try {
			Statement stmt = connObj.createStatement();
			ResultSet rs = stmt.executeQuery(Query.friendList(empId, organizationName));
			while (rs.next()) {
				friendList.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friendList;
	}

	/**
	 * This method is used to show employee which have this email.
	 * @param email, email of employee.
	 * @return, this return object of employee.
	 */
	public static Employee empDetailsWithEmail(String email) {
		Employee emp = null;

		try {
			Statement stmt = connObj.createStatement();
			ResultSet rs = stmt.executeQuery(Query.empDetailsWithEmail(email));
			rs.next();
			emp = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
    /**
     * This method is used to insert vehicle plan in database.
     * @param empId, 
     * @param vehicleNumber
     * @param passType
     * @param price
     * @return, this return no of updated data.
     */
	public static int insertIntoPlan(int empId, String vehicleNumber,
			String passType, float price) {

		int noOfUpdate = 0;
		try {
			Statement stmt = connObj.createStatement();
			PreparedStatement pstmt = connObj.prepareStatement(Query.insertIntoPlan());
			pstmt.setInt(1, empId);
			pstmt.setString(2, vehicleNumber);
			pstmt.setString(3, passType);
			pstmt.setFloat(4, price);
			noOfUpdate = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noOfUpdate;
	}
}