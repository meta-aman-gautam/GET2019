package com.metacube.parking.service;

import static org.junit.Assert.*;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.metacube.parking.model.Employee;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;

/**
 * The Class MeatcubeParkingSystemTest.
 */
public class MeatcubeParkingSystemTest {

private Employee employee = new Employee("/images/download.jpg","Aman","Male","amangautam780@gmail.com","1234","1234","8318963298","metacube");

private Vehicle vehicle = new Vehicle("amangautam780@gmail.com","alto","car","8965","03","black car");

private Plan plan = new Plan("USD","6.98");

ParkingService service = new ParkingService();

	/**
	 * Test for add employee.
	 *
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Test
	public void testForAddEmployee() throws SQLIntegrityConstraintViolationException {
		assertEquals(true,service.addEmployee(employee));
	}
	
	/**
	 * Test for add vehicle.
	 */
	@Test
	public void testForAddVehicle() {
		assertEquals(true,service.addVehicle(vehicle, employee.getEmail()));
	}
	
	/**
	 * Test for add plan.
	 */
	@Test
	public void testForAddPlan() {
		assertEquals(true,service.addPlan(plan,employee.getEmail(), 2));
	}
	
	/**
	 * Test for check authantication.
	 */
	@Test
	public void testForCheckAuthantication() {
		assertEquals(true,service.checkAuthentication(employee.getEmail(), employee.getPassword()));
	}
	
	/**
	 * Test for update.
	 */
	@Test
	public void testForUpdate() {
		assertEquals(true,service.updatePhotoUrl("/images/download1.jpg", employee.getEmail()));
	}
}
