package com.metacube.DAO;

/**
 * The Class Data , is used to the set the essential data part in the jdbc connection.
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class Data {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/employee_data";
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "1083543569";

    //Getters	
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	public static String getJdbcDbUrl() {
		return JDBC_DB_URL;
	}

	public static String getJdbcUser() {
		return JDBC_USER;
	}

	public static String getJdbcPass() {
		return JDBC_PASS;
	}
}
