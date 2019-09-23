package com.metacube.model;

/**
 * Pojo class of employee. which is an entity of the model layer
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class Employee {

	public String fullName,gender, email,password,organization;
	public Long contactNumber;

	/**
	 * Instantiates a new employee.
	 *
	 * @param fullName the full name
	 * @param gender the gender
	 * @param email the email
	 * @param password the password
	 * @param contactNumber the contact number
	 * @param organization the organization
	 */
	public Employee(String fullName, String gender, String email,String password, Long contactNumber, String organization) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.organization = organization;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
