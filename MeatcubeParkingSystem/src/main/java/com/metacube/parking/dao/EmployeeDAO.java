package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Employee;

/**
 * The Class EmployeeDAO is the dao layer used to access user data
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class EmployeeDAO {
	
	/**
	 * Insert employee in the Database.
	 *
	 * @param employee 
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean insertEmployee(Employee employee) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getInsertionQuery());
			prepareStatement.setString(1,employee.getFullName());
			prepareStatement.setString(2,employee.getGender());
			prepareStatement.setString(3,employee.getEmail());
			prepareStatement.setString(4,employee.getPassword());
			prepareStatement.setString(5,employee.getContactNumber());
			prepareStatement.setString(6,employee.getOrganization());
			prepareStatement.setString(7,employee.getProfilePhtotoUrl());
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Gets the user profile.
	 *
	 * @param email
	 * @return the user profile
	 * @throws Exception
	 */
	public static dtoEmployee getUserProfile(String email) throws Exception   {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result;
		dtoEmployee employee;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getUserProfile());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			employee = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}
	
	/**
	 * Gets the friends profile.
	 *
	 * @param email
	 * @return the friends profile
	 * @throws Exception
	 */
	public static LinkedList<dtoEmployee> getFriendsProfile(String email) throws Exception{
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result;
		LinkedList<dtoEmployee> listOfEmployee;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getCompany());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			String company = result.getString(1);
			listOfEmployee = new LinkedList<dtoEmployee>();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getFriendProfile());
			prepareStatement.setString(1,company);
			prepareStatement.setString(2,email);
			result = prepareStatement.executeQuery();
			while(result.next()) {
				dtoEmployee emp = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
				listOfEmployee.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfEmployee;
	}
	
	/**
	 * Update employee in .
	 *
	 * @param email
	 * @param dtoemployee
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getEmployeeUpdationQuery());
			prepareStatement.setString(1,dtoemployee.getFullName());
			prepareStatement.setString(2,dtoemployee.getGender());
			prepareStatement.setString(3,dtoemployee.getContactNumber());
			prepareStatement.setString(4,dtoemployee.getOrganization());
			prepareStatement.setString(5,email);
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Gets the photo url.
	 *
	 * @param email 
	 * @return the photo url
	 * @throws Exception 
	 */
	public static String getPhotoUrl(String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		String url;
		ResultSet result;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getProfilePhoto());
			prepareStatement.setString(1,email);
			result=prepareStatement.executeQuery();
			result.next();
			url = result.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
	/**
	 * Update photo url.
	 *
	 * @param url
	 * @param email
	 * @return true, if successful
	 * @throws Exception
	 */
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getPhotoUpdationQuery());
			prepareStatement.setString(1,url);
			prepareStatement.setString(2,email);
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @param email 
	 * @return the name
	 * @throws Exception
	 */
	public static String getName(String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		String name;
		ResultSet result;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getNameQuery());
			prepareStatement.setString(1,email);
			result=prepareStatement.executeQuery();
			result.next();
			name = result.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	}
}
