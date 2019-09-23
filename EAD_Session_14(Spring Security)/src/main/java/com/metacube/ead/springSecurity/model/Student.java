package com.metacube.ead.springSecurity.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Student is pojo class to save a student object and pass and store the values .
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
 */
@Entity
@Table(name = "detail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Student {

	/** The first name. */
	@NotBlank(message = "{firstNameError}")
	@Column(name = "firstName")
	private String firstName;

	/** The last name. */
	@NotBlank(message = "{lastNameError}")
	@Column(name = "lastName")
	private String lastName;

	/** The father name. */
	@NotBlank(message = "{fatNameError}")
	@Column(name = "fatherName")
	private String fatherName;

	/** The email. */
	@Id
	@NotBlank(message = "{emailBlank}")
	@Pattern(regexp = "^(.+)@(.+)$")
	@Column(name = "email")
	private String email;

	/** The class name. */
	@NotBlank(message = "{classBlank}")
	@Pattern(regexp = "\\d+")
	@Column(name = "class")
	String className;

	/** The age. */
	@NotBlank(message = "{ageBlank}")
	@Pattern(regexp = "\\d+")
	@Column(name = "age")
	String age;

	/**
	 * Instantiates a new student.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param fatherName the father name
	 * @param email the email
	 * @param className the class name
	 * @param age the age
	 */
	public Student(String firstName, String lastName, String fatherName,
			String email, String className, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.className = className;
		this.age = age;
	}

	/**
	 * Instantiates a new student.
	 */
	public Student() {
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
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(String age) {
		this.age = age;
	}

}
