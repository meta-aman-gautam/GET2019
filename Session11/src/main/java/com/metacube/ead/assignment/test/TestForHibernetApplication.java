package com.metacube.ead.assignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.ead.assignment.dao.StudentDao;
import com.metacube.ead.assignment.entity.Student;

/**
 * The Class Test For Hibernet Application at application level . 
 * 
 * @author Aman Gautam
 * 
 * Dated :18/9/19
 */
public class TestForHibernetApplication {

	@Autowired
	StudentDao studentDao;

	/**
	 * Sets the student dao.
	 *
	 * @param studentDao 
	 */
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	Student student;

	/**
	 * Initialization of the user defined method.
	 * setting predefined values
	 */
	@Before
	public void initialize() {
		student = new Student();
		student.setEmail("amangautam780@gmail,com");
		student.setFirstName("Aman");
		student.setLastName("Gautam");
		student.setFatherName("Ravindra Kumar");
		student.setAge(12);
		student.setStudentClass(22);
	}

	/**
	 * Test for add student method .
	 */
	@Test
	public void testForAddStudent() {
		assertEquals(true,studentDao.addStudent(student));
	}

	/**
	 * Test for get students method.
	 */
	@Test
	public void testForShowStudents() {
		assertEquals("amangautam780@gmail,com", student.getEmail());
	}

}
