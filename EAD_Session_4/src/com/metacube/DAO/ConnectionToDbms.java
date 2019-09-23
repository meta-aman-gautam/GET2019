package com.metacube.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used for make connection to the database .
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */

public class ConnectionToDbms {

	public Connection connectionObject() {

		Connection connObj = null;

		try {
			Data data = new Data();
			Class.forName(data.getJdbcDriver());
			connObj = DriverManager.getConnection(data.getJdbcDbUrl(),
					data.getJdbcUser(), data.getJdbcPass());

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connObj;
	}
}

