package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class ConnectionClass for setting up the jdbc connection .
 * 
 * @author Aman Gautam
 * 
 *Dated :21/9/19
 */
public class ConnectionClass {

	/**
	 * @return object of Connection class
	 * @throws Exception when driver class not found or can't create connection
	 */
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "1083543569";
		String url = "jdbc:mysql://localhost:3306/metaparking2";
		try {
			Connection conn = null;
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			return conn;
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
			return null;
		} 
		catch (NullPointerException e){
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
			return null;
		} 
		catch (SQLException e){
			e.printStackTrace();
			System.out.println("Remote db connection establishment error");
			return null;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
