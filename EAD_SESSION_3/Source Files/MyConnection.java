package com.ead_session_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	//constant keyword
	static final String driver = "com.mysql.jdbc.Driver";
	static final String host= "jdbc:mysql://localhost:3306/";
	String dbName = "student" ;
	String url = host+dbName ;
	String userId = "root";
	String pass = "1083543569";
	Connection connObj ;
	public MyConnection(){
		try{
			Class.forName(driver);
			connObj = DriverManager.getConnection(url, userId, pass);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnObj() {
		return connObj;
	}
		
}
