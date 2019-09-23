package com.metacube.parking.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.parking.dto.DtoEmployee;

/**
 * The Class DtoLinked ListOf EmployeeMapper. is used to add DtoEmployee to the linkedList<DtoEmployee> which is sent to the Dao class
 * 
 * @author Aman Gautam
 * 
 * Dated :23/9/19
 */
public class DtoLinkedListOfEmployeeMapper implements RowMapper<LinkedList<DtoEmployee>> {


	/**
	 * maprow method which is used to add DtoEmployee to the 
	 * linkedList<DtoEmployee> which is sent to the Dao class
	 */
	@Override
	public LinkedList<DtoEmployee> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		LinkedList<DtoEmployee> listOfEmployeesData = new LinkedList<DtoEmployee>();
		do{
			DtoEmployee emp = new DtoEmployee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			System.out.println(emp.toString());
			listOfEmployeesData.add(emp);
		}
		while(resultSet.next());
		
		return listOfEmployeesData;
	}
}
