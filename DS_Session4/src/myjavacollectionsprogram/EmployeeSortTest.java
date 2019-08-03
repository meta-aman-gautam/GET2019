package myjavacollectionsprogram;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Test class for the Employee sort .
 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class EmployeeSortTest {

	List<Employee> listOfEmployee= new ArrayList<Employee>();
	List<Employee> expectedListById= new ArrayList<Employee>();
	List<Employee> expectedListByName= new ArrayList<Employee>();
	List<Employee> expectedListByAddress= new ArrayList<Employee>();
	
	public EmployeeSortTest() {
		
		listOfEmployee.add(new Employee(1,"AAA","thisDDDDD"));
		listOfEmployee.add(new Employee(3,"BBB","thisBBBBB"));
		listOfEmployee.add(new Employee(4,"BAB","thisEEEEE"));
		listOfEmployee.add(new Employee(2,"DDD","thisCCCCC"));
		
		expectedListById.add(new Employee(1,"AAA","thisDDDDD"));
		expectedListById.add(new Employee(2,"DDD","thisCCCCC"));
		expectedListById.add(new Employee(3,"BBB","thisBBBBB"));
		expectedListById.add(new Employee(4,"BAB","thisEEEEE"));
		
		
		expectedListByName.add(new Employee(1,"AAA","thisDDDDD"));
		expectedListByName.add(new Employee(4,"BAB","thisEEEEE"));
		expectedListByName.add(new Employee(3,"BBB","thisBBBBB"));
		expectedListByName.add(new Employee(2,"DDD","thisCCCCC"));
	
		expectedListByAddress.add(new Employee(3,"BBB","thisBBBBB"));
		expectedListByAddress.add(new Employee(2,"DDD","thisCCCCC"));
		expectedListByAddress.add(new Employee(1,"AAA","thisDDDDD"));
		expectedListByAddress.add(new Employee(4,"BAB","thisEEEEE"));
	};

	//Positive test case
	@Test  
	public void testforClass_SortedByEmpId() {
		Collections.sort(listOfEmployee, new SortByEmpId());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListById.get(count_i).empId, listOfEmployee.get(count_i).empId);
		}
	}
	
	//Positive test case
	@Test
	public void testforClass_SortedByEmpName() {
		Collections.sort(listOfEmployee, new SortByName());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListByName.get(count_i).empName, listOfEmployee.get(count_i).empName);
		}
	}
	//Positive test case
	@Test
	public void testforClass_SortedByEmpAddress() {
		Collections.sort(listOfEmployee, new SortByAddress());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListByAddress.get(count_i).address, listOfEmployee.get(count_i).address);
		}
	}
	//Negative test case
	@Test (expected=AssertionError.class)
	public void testforClass_SortedByEmpId_AssertionError() {
		Collections.sort(listOfEmployee, new SortByEmpId());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListByAddress.get(count_i).empId, listOfEmployee.get(count_i).empId);
		}
	}
	//Negative test case
	@Test  (expected=AssertionError.class)
	public void testforClass_SortedByEmpName_AssertionError() {
		Collections.sort(listOfEmployee, new SortByName());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListById.get(count_i).empName, listOfEmployee.get(count_i).empName);
		}
	}
	//Negative test case
	@Test (expected=AssertionError.class)
	public void testforClass_SortedByEmpAddress_AssertionError() {
		Collections.sort(listOfEmployee, new SortByAddress());
	
		for(int count_i=0;count_i<listOfEmployee.size();count_i++){
			assertEquals(expectedListByName.get(count_i).address, listOfEmployee.get(count_i).address);
		}
	}

}
