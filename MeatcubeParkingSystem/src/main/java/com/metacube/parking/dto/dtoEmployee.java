package com.metacube.parking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * The Class dtoEmployee. is used to save the employee details
 * 
 * @author Aman Gautan
 * 
 * Dated :21/9/19
 */
public class dtoEmployee {
	

	@NotBlank(message="{fullName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{fullName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{fullName.Size}")
	private String fullName ;
	
	private String gender ;
	
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email ;
	

	@NotBlank(message="{contactNumber.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{contactNumber.OnlyNumber}")
	@Size(min=8, max=10, message="{contactNumber.Size}")
	private String contactNumber ;

	private String organization  ;
	
	/**
	 * Instantiates a new dto employee.
	 *
	 * @param fullName the full name
	 * @param gender the gender
	 * @param email the email
	 * @param contactNumber the contact number
	 * @param organization the organization
	 */
	public dtoEmployee(String fullName , String gender , String email , String contactNumber , String organization) {
		this.contactNumber = contactNumber;
		this.email = email ;
		this.fullName = fullName;
		this.gender = gender;
		this.organization = organization;
	}
	
	/**
	 * Instantiates a new dto employee.
	 */
	public dtoEmployee() {
	}

	
	//Setter and getter method 
	
	
	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return this.fullName;
	}
	
	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the contact number.
	 *
	 * @return the contact number
	 */
	public String getContactNumber() {
		return this.contactNumber;
	}
	
	/**
	 * Sets the contact number.
	 *
	 * @param contactNumber the new contact number
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public String getOrganization() {
		return this.organization;
	}
	
	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Employee [fullName=" + this.fullName + ", gender=" + this.gender + ", email=" + this.email +", contactNumber=" + this.contactNumber + ", organization=" + this.organization + "]";
	}
}