package com.metacube.ead.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String HOST = "jdbc:mysql://localhost:3306/";
	static final String DBNAME = "shoppingcart?useSSL=false";
	static final String MYSQLURL = HOST+DBNAME;
	static final String USERID = "root";
	static final String PASSWORD = "1083543569";
	
	Connection objConnection ;
	
	public JdbcConnection() {
		try {
			Class.forName(DRIVER);
			objConnection = DriverManager.getConnection(MYSQLURL,USERID,PASSWORD);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getObjConnection() {
		return objConnection;
	}
}
