package employee;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for DictionaryImp Class methods
 * 
 * @author Aman Gautam
 * 
 * Dated - 11/08/2019
 */
public class EmployeeTest {

	@Test
	public void testOfSortBySalary() {
		LinkedList employeeList = new LinkedList();
		
		employeeList.insertEmployee(new Employee("A", 20, 12000));
	
		employeeList.insertEmployee( new Employee("B",  23,30000));

		employeeList.insertEmployee(new Employee("C",26, 6000));
		//Sorting 
		employeeList.sortBySalary();
		Node currentNode = employeeList.sortBySalary();
		
		assertEquals("B", currentNode.data.empName);
		currentNode = currentNode.next;
		assertEquals("A", currentNode.data.empName);
		currentNode = currentNode.next;
		assertEquals("C", currentNode.data.empName);
	}
	
	// test case for equal salary condition then sort by age
	@Test
	public void testOfSortByAge() {
		LinkedList employeeList = new LinkedList();
		
		employeeList.insertEmployee(new Employee("A", 23, 12000));
		
		employeeList.insertEmployee(new Employee("B",  20,12000));
		
		employeeList.insertEmployee(new Employee("C", 18, 12000));
		//Sorting 
		employeeList.sortBySalary();
		Node currentNode = employeeList.sortBySalary();
		
		assertEquals("C", currentNode.data.empName);
		currentNode = currentNode.next;
		assertEquals("B", currentNode.data.empName);
		currentNode = currentNode.next;
		assertEquals("A", currentNode.data.empName);
	}

}
