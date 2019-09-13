package com.metacube.ead.session8.springmvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The Class StudentDetails is POJO class which is used to store the student details.
 * 
 * @author Aman Gautam
 * 
 * Dated : 13/9/19
 */
public class StudentDetails {

	@NotBlank(message= "{error.firstName}")
	private String firstName;
	
	@NotBlank(message= "{error.lastName}")
	private String lastName;
	
	@NotBlank(message= "{error.fatherName}")
	private String fatherName;
	
	@NotBlank(message= "{error.email}")
	private String email;
	
	@NotNull
	@Min(value = 1,message= "{error.studentClass}")
	@Max(value = 12,message= "{error.studentClass}")
	private Integer studentClass;
	
	@NotNull
	@Min(value = 1,message= "{error.age}")
	@Max(value = 100 ,message= "{error.age}")
	private Integer age;

	/**
	 * Instantiates a new student details.
	 * via default constructor
	 */
	public StudentDetails() {
	}

	/**
	 * Instantiates a new student details. via parametrized constructor
	 *
	 * @param firstName
	 * @param lastName 
	 * @param fatherName
	 * @param email
	 * @param studentClass 
	 * @param age 
	 */
	public StudentDetails(
			@NotBlank(message = "{error.firstName}") String firstName,
			@NotBlank(message = "{error.lastName}") String lastName,
			@NotBlank(message = "{error.fatherName}") String fatherName,
			@NotBlank(message = "{error.email}") String email,
			@NotNull @Min(value = 1, message = "{error.studentClass}") @Max(value = 12, message = "{error.studentClass}") Integer studentClass,
			@NotNull @Min(value = 1, message = "{error.age}") @Max(value = 100, message = "{error.age}") Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the father name.
	 *
	 * @return the father name
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * Sets the father name.
	 *
	 * @param fatherName the new father name
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
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
	 * Gets the student class.
	 *
	 * @return the student class
	 */
	public Integer getStudentClass() {
		return studentClass;
	}

	/**
	 * Sets the student class.
	 *
	 * @param studentClass the new student class
	 */
	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * To string method overided as per our own convenience 
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		return "First_Name=" + firstName + ", Last_Name="
				+ lastName + ", Father_Name=" + fatherName + ", Email=" + email
				+ ", Student_Class=" + studentClass + ", Age=" + age + "]";
	}
}
