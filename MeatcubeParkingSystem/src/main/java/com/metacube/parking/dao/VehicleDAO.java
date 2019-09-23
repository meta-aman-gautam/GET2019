package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.model.Vehicle;

/**
 * The Class VehicleDAO is used to insert the vehicle information 
 * in the database choosen by the employee
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class VehicleDAO {
	
	/**
	 * Insert vehicle details into the database.
	 *
	 * @param vehicle
	 * @param email
	 * @return true, if successful
	 * @throws Exception
	 */
	public boolean insertVehicle(Vehicle vehicle , String email) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getVehicleInsertionQuery());
			prepareStatement.setString(1,email);
			prepareStatement.setString(2,vehicle.getVehicleName());
			prepareStatement.setString(3,vehicle.getVehicleType());
			prepareStatement.setString(4,vehicle.getVehicleNumber());
			prepareStatement.setString(5,vehicle.getEmployeeId());
			prepareStatement.setString(6,vehicle.getVehicleDetails());
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
	 * Gets the vehicle id.
	 *
	 * @param email 
	 * @return the vehicle id
	 * @throws Exception 
	 */
	public int getVehicleId(String email) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result = null; 
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getVehicleID());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			int vehicleId = result.getInt(1);
			return vehicleId;
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
}
