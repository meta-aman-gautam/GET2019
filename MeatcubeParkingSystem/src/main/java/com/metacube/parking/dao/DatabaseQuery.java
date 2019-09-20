package com.metacube.parking.dao;

/**
 * The Class DatabaseQuery which is used to write all the 
 * queries in the application.
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 * 
 */
public class DatabaseQuery {
	
	/**
	 * insertion of the employee details-> query.
	 *
	 * @return String type Query
	 */
	public static String getInsertionQuery(){
		String query="INSERT INTO Employee("
				+ "Name , Gender , Email , Password , Number , Company , ProfilePhtotoUrl)"
				+ "VALUES(?,?,?,?,?,?,?);";
				
		return query;
	}	
	
	/**
	 * Insert the Vehicle details ->query.
	 *
	 * @return String type Query
	 */
	public static String getVehicleInsertionQuery(){
		String query="INSERT INTO Vehicle("
				+ "Email , Name , Type , Number , EmployeeId , Details)"
				+ "VALUES(?,?,?,?,?,?);";
		return query;
	}
	
	/**
	 * Gets the vehicle ID.
	 *
	 * @return String type Query
	 */
	public static String getVehicleID(){
		String query="SELECT VehicleId FROM vehicle WHERE Email = ? ;";
		return query;
	}
	
	/**
	 * Query to insert into plans .
	 *
	 * @return String type Query
	 */
	public static String getPlanInsertionQuery(){
		String query="INSERT INTO plandetails("
				+ "VehicleId , Email , Currency , Price )"
				+ "VALUES(?,?,?,?);";
		return query;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return String type Query
	 */
	public static String getPassword(){
		String query="SELECT Password FROM employee WHERE Email = ? ;";
		return query;
	}
	
	/**
	 * Gets the user profile.
	 *
	 * @return String type Query
	 */
	public static String getUserProfile() {
		String query="SELECT Name , Gender , Email , Number , Company FROM employee WHERE Email = ? ;";
		return query;
	}
	
	/**
	 * Gets the friend profile.
	 *
	 * @return String type Query
	 */
	public static String getFriendProfile() {
		String query="SELECT Name , Gender , Email , Number , Company FROM employee WHERE Company = ? and Email != ? ;";
		return query;
	}
	
	/**
	 * Gets the company.
	 *
	 * @return String type Query
	 */
	public static String getCompany() {
		String query="SELECT Company FROM employee WHERE Email = ? ;";
		return query;
	}
	
	/**
	 * Gets the employee updation query.
	 *
	 * @return String type Query
	 */
	public static String getEmployeeUpdationQuery() {
		String query="UPDATE Employee SET Name = ? , Gender = ? , Number = ? , Company = ? WHERE email = ? ;";
		return query;
	}
	
	/**
	 * Query used to select the Profile photo of the employees
	 *
	 * @return String type Query
	 */
	public static String getProfilePhoto() {
		String query="SELECT ProfilePhtotoUrl FROM Employee WHERE email = ? ;";
		return query;
	}
	
	/**
	 * Photo updation in the page ->query.
	 *
	 * @return String type Query
	 */
	public static String getPhotoUpdationQuery() {
		String query="UPDATE Employee SET ProfilePhtotoUrl = ? WHERE email = ? ;";
		return query;
	}
	
	/**
	 * Gets the name of the employee ->query.
	 *
	 * @return String type Query
	 */
	public static String getNameQuery() {
		String query="SELECT Name FROM Employee WHERE email = ? ;";
		return query;
	}


}