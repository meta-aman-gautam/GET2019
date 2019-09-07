package com.ead_session_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class MyConnection creates connection and sets up driver .
 * @author Aman Gautam
 * 
 * Dated: 9/7/19
 */
public class MyConnection {
	
	static final String DRIVER = "com.mysql.jdbc.Driver",
						HOST= "jdbc:mysql://localhost:3306/",
						PASSWORD = "1083543569",
						USERID = "root",
						DBNAME = "student" ,
						URL= HOST+DBNAME ;
	
	private static Connection connObj =null;
	
	//only one instance of the connection will be created during the entire program
	static{
		try {
			Class.forName(DRIVER);
			connObj = DriverManager.getConnection(URL, USERID, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());;
		}	
	}
	
	/**
	 * Gets the connection object.
	 *
	 * @return the connobj
	 */
	public Connection getConnObj() {
		return connObj;
	}
}
