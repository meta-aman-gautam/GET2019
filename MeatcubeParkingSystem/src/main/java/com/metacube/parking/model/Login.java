package com.metacube.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The Class Login contains all the login details
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class Login {
	
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email;

	private String password;
	
	/**
	 * Instantiates a new login Plan.
	 *
	 * @param email the email
	 * @param password the password
	 */
	public Login(String email , String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Instantiates a new login plan.
	 */
	public Login() {}

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

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
}