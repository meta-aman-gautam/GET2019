package com.metacube.parking.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.parking.dto.DtoEmployee;

/**
 * The Class DtoEmployeeMapper maps the Dtoemployee to the jdbctemplate method of getUserProfile in the EmployeeDao Class.
 * 
 * @author Aman Gautam
 * 
 * Dated :22/9/19
 */
public class DtoEmployeeMapper implements RowMapper<DtoEmployee> {

	/**
	 * Overriding the mapRow method of the RowMapper class 
	 * to get the DtoEmployee object
	 */
	@Override
	public DtoEmployee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		DtoEmployee empDTO = new DtoEmployee();
		empDTO.setFullName(resultSet.getString(1));
		empDTO.setGender(resultSet.getString(2));
		empDTO.setEmail(resultSet.getString(3));
		empDTO.setContactNumber(resultSet.getString(4));
		empDTO.setOrganization(resultSet.getString(5));
		return empDTO;
	}
}
