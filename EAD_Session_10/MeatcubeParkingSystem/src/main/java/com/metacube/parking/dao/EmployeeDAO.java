package com.metacube.parking.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.dto.DtoEmployee;
import com.metacube.parking.utility.DtoEmployeeMapper;
import com.metacube.parking.utility.DtoLinkedListOfEmployeeMapper;
import com.metacube.parking.utility.SingleStringMapper;
import com.metacube.parking.model.Employee;

/**
 * The Class EmployeeDAO.is used access the data of the employee from the database
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class EmployeeDAO {
	
/** The jdbc template. */
static JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionClass.getConnection() , true));
	
	/**
	 * Insert employee into the database .
	 *
	 * @param employee 
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 * @throws Exception 
	 */
	public boolean insertEmployee(Employee employee) throws SQLException,Exception{
		
		jdbcTemplate.update(DatabaseQuery.getInsertionQuery(),employee.getFullName(), employee.getGender() ,employee.getEmail()
																,employee.getPassword() ,employee.getContactNumber()
																,employee.getOrganization() ,employee.getProfilePhtotoUrl());
		return true;
	}
	
	/**
	 * Gets the user profile from the database .
	 *
	 * @param email
	 * @return the user profile
	 * @throws SQLException
	 * @throws Exception 
	 */
	public static DtoEmployee getUserProfile(String email) throws SQLException,Exception   {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getUserProfile(),new Object[] { email }, new DtoEmployeeMapper());
	}
	
	/**
	 * Gets the friends profile.
	 *
	 * @param email
	 * @return the friends profile
	 * @throws SQLException the SQL exception
	 * @throws Exception 
	 */
	public static LinkedList<DtoEmployee> getFriendsProfile(String email) throws SQLException,Exception{
		
		String company = jdbcTemplate.queryForObject(DatabaseQuery.getCompany(),new Object[] { email }, new SingleStringMapper());
		System.out.println(company);
		return jdbcTemplate.queryForObject(DatabaseQuery.getFriendProfile(),new Object[] { company,email }, new DtoLinkedListOfEmployeeMapper());
	}
	
	/**
	 * Update employee in the database .
	 *
	 * @param email
	 * @param dtoemployee
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean updateEmployee(String email, DtoEmployee dtoemployee) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getEmployeeUpdationQuery(), dtoemployee.getFullName(), dtoemployee.getGender()
				,dtoemployee.getContactNumber(), dtoemployee.getOrganization(), email);
		return true;
	}
	
	/**
	 * Gets the photo url.
	 *
	 * @param email the email
	 * @return the photo url
	 * @throws Exception the exception
	 */
	public static String getPhotoUrl(String email) throws Exception {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getProfilePhoto(),new Object[] { email }, new SingleStringMapper());
	}
	
	/**
	 * Update photo url in the url .
	 *
	 * @param url 
	 * @param email
	 * @return true, if successful
	 * @throws Exception
	 */
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getPhotoUpdationQuery(), url, email );
		return true;
	}
	
	/**
	 * Gets the name.
	 *
	 * @param email the email
	 * @return the name
	 */
	public static String getName(String email) {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getNameQuery(),new Object[] { email }, new SingleStringMapper());
	}
}