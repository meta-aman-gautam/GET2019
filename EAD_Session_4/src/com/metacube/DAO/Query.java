package com.metacube.DAO;

/**
 * This class is used to perform all query.
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class Query {

	//Query for insert employee.
	public static String employeeInsert() {		
	return "INSERT INTO employee_details(fullname,gender,email,password,contact_number,organization) VALUES(?,?,?,?,?,?)";
    }
	
	// Query for check login email or password in database or not
	public static String login(String email,String password) {
		return " SELECT email,password,employee_id FROM employee_details "
				+ "WHERE email = '" + email + "' AND password = '" + password + "' ";
	}

	// Query for insert vehicle data.
	public static String vehicle() {	
		return "INSERT INTO vehicle_details(vehicle_name,type,vechile_number,employee_id,identification) VALUES(?,?,?,?,?)";
	}
	
	//Query for check employee login on first time or not.
	public static String SecondTimelogin(String email) {
		return " SELECT v.employee_id FROM employee_details e,vehicle_details v "
				+ "WHERE e.email = '" + email + "' AND e.employee_id = v.employee_id ";
	}
	
	// Query for show all employee that have this id
	public static String showEmployee(int id) {
		return " SELECT * FROM employee_details WHERE employee_id = " +id;
	}
	
	// Query for update employee that have this id.
	public static String UpdateEmployeeData(int id, String fullname, String password, long contact_number) {
		return "UPDATE employee_details " + " SET fullname = '" + fullname + "', "
				 + "password = '" + password + "', " + "contact_number = " + contact_number
				 + " WHERE employee_id = " + id;
	}
	
	// Query for find friend of employee.
	public static String friendList(int empId, String organizationName){
		return "SELECT * FROM employee_details WHERE organization = '"+ organizationName +"' "
				+ " AND employee_id NOT IN (SELECT employee_id FROM employee_details WHERE employee_id = "+ empId +" )";	
	}
	
	// Query for check employee have this email.
	public static String empDetailsWithEmail(String email){		
		return "SELECT * FROM employee_details WHERE email = '"+ email +"'";	
	}
	
	//  Query for insert data into plan.
	public static String insertIntoPlan(){
		return "INSERT INTO plan_details(employee_id, vechile_number, plan, price) VALUES(?,?,?,?)";
	}
}
