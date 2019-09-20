package com.metacube.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The Class Employee which the model of the employee
 * which contains all the information of the employee
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class Employee {
	
	
	@NotBlank(message="{fullName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{fullName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{fullName.Size}")
	private String fullName ;
	
	
	private String gender ;
	
	
	@NotBlank(message="{email.NotBlank}")
	@Size(min=2, max=30, message="{email.Size}")
	@Email(message="{email.ValidEmail}")
	private String email ;
	

	@NotBlank(message="{password.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{password.ValidPassword}")
	@Size(min=2, max=30, message="{password.Size}")
	private String password ;
	

	private String confirmPassword ;

	@NotBlank(message="{contactNumber.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{contactNumber.OnlyNumber}")
	@Size(min=8, max=10, message="{contactNumber.Size}")
	private String contactNumber ;
	
	
	private String organization  ;
	

	private String profilePhtotoUrl;
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param profilePhtotoUrl the profile phtoto url
	 * @param fullName the full name
	 * @param gender the gender
	 * @param email the email
	 * @param password the password
	 * @param confirmPassword the confirm password
	 * @param contactNumber the contact number
	 * @param organization the organization
	 */
	public Employee(String profilePhtotoUrl , String fullName , String gender , String email , String password , String confirmPassword , String contactNumber , String organization) {
		this.contactNumber = contactNumber;
		this.email = email ;
		this.fullName = fullName;
		this.gender = gender;
		this.organization = organization;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.profilePhtotoUrl = profilePhtotoUrl;
	}
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getProfilePhtotoUrl() {
		return profilePhtotoUrl;
	}

	public void setProfilePhtotoUrl(String profilePhtotoUrl) {
		this.profilePhtotoUrl = profilePhtotoUrl;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + this.fullName + ", gender=" + this.gender + ", email=" + this.email + ", password=" + this.password
				+ ", contactNumber=" + this.contactNumber + ", organization=" + this.organization + "]";
	}
}