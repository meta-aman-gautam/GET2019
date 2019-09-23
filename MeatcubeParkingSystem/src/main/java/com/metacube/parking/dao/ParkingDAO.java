package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionClass;

/**
 * The Class ParkingDAO. basically another dao layer which also
 * act as the data accessing entity in the application
 * which is to authenticate the user
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class ParkingDAO {
	
	/**
	 * Check authentication.
	 *
	 * @param email
	 * @param password 
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean checkAuthentication(String email, String password) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result =null;
		boolean flag=false;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getPassword());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			String dbPass = result.getString(1);
			if(dbPass.equals(password)) {
				flag=true;
			}
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
		return flag;
	}
}
