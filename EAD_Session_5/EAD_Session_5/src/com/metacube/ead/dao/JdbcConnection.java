package com.metacube.ead.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class JdbcConnection.{DAO LAYER}
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class JdbcConnection {

	/** Constants. */
	static final String DRIVER = "com.mysql.jdbc.Driver",
						HOST = "jdbc:mysql://localhost:3306/",
						DBNAME = "shoppingcart",
						MYSQLURL = HOST+DBNAME,
						USERID = "root",
						PASSWORD = "1083543569";
	

	Connection objConnection ;
	
	/**
	 * Instantiates a new jdbc connection.
	 */
	public JdbcConnection() {
		try {
			Class.forName(DRIVER);
			objConnection = DriverManager.getConnection(MYSQLURL,USERID,PASSWORD);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the obj connection.
	 *
	 * @return the obj connection
	 */
	public Connection getObjConnection() {
		return objConnection;
	}
}
