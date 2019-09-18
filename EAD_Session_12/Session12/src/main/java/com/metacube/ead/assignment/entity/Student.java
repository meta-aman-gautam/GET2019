package com.metacube.ead.assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Entity class for student {persistance layer} for my application
 * 
 * @author Aman Gautam
 *
 * Dated :19/9/19
 */
@Entity
@Table(name="student")
public class Student{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="studentId")
	Integer studentId;

	@Pattern(regexp="^[a-zA-Z ]{0,15}",message="first name should be alphabetical")
	@Size(min = 2, max =  15)
	@Column(name="firstName")
	String firstName;

	@Pattern(regexp="^[a-zA-Z ]{0,15}",message="last name should be alphabetical")
	@Size(min=2, max =15)
	@Column(name="lastName")
	String lastName ;

	@Pattern(regexp="^[a-zA-Z ]{0,50}",message="father name should be alphabetical")
	@Size(min = 2, max = 50)
	@Column(name="fatherName")
	String fatherName;

	@NotBlank
	@Email
	@Column(name="email")
	String email ;

	@NotNull(message= "class can not be empty")
	@Range(min = 1,max=12)
	@Column(name="studentClass")
	Integer studentClass;

	@NotNull(message= "age can not be empty")
	@Range(min = 1,max=100)
	@Column(name="age")
	Integer age;

	public Student() {

	}

	public Student(Integer studentId,String firstName,String lastName,String fatherName,String email,Integer studentClass,Integer age) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}

	//Getter Setter
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
