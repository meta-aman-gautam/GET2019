package com.metacube.ead.session8.springmvc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.ead.session8.springmvc.controller.HomeController;
import com.metacube.ead.session8.springmvc.model.StudentDetails;

/**
 * The Class SpringMvcTest , is used for test some basi fuctionalities of the homecontroller 
 * method 
 * 
 * @author Aman Gautam
 * 
 * Dated :13/9/19
 */
public class SpringMvcTest {

	HomeController controller= new HomeController() ;
	
	/**
	 * Test for add student in the data.
	 */
	@Test
	public void testForAddStudent() {
		StudentDetails sDetails = new StudentDetails("Aman","Gautam","Mr Gautam","aman73463@gmail.com",22,12);
		System.out.println(sDetails);
		
		assertNotEquals(sDetails.getAge(),"Aman");
		assertNotEquals(sDetails.getAge(),"aman73463@gmail.com");
		assertEquals(sDetails.getFatherName(),"Mr Gautam");
		assertEquals(sDetails.getLastName(),"Gautam");
		assertEquals(sDetails.getEmail(),"aman73463@gmail.com");
		
	}
	
	/**
	 * Test for list of student which is hard coded .
	 */
	@Test
	public void testForListOfStudent() {
		StudentDetails sDetails = new StudentDetails("Aman","Gautam","Mr Ravindra Kumar","aman73463@gmail.com",22,12);
		System.out.println(sDetails);
		String FirstName = controller.preparedList().get(0).getFirstName();
		String FatherName = controller.preparedList().get(0).getFatherName();
		
		assertEquals(sDetails.getFirstName(),FirstName);
		assertEquals(sDetails.getFatherName(),FatherName);
		assertNotEquals(sDetails.getFirstName(),FatherName);
	}

}
