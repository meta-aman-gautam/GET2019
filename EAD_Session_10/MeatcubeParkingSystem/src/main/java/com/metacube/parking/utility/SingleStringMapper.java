package com.metacube.parking.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * The Class SingleStringMapper is a class which is used to mad the single string to the row.
 * @author Aman Gautam
 * 
 * Dated :22/9/19
 */
public class SingleStringMapper implements RowMapper<String> {

	/**
	 * mapRow an overridden method which is used to map the single string coming from the database
	 * to the method variable
	 */
	@Override
	public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return resultSet.getString(1) ;
	}

}
