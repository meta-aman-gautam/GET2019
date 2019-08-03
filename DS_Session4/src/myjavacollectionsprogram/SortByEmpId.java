package myjavacollectionsprogram;

import java.util.Comparator;

/**
 * This class is use Sort the Employee by their EMP_ID

 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class SortByEmpId implements Comparator<Employee> {

	@Override
	public int compare(Employee empId1, Employee empId2) {
		return empId1.empId - empId2.empId;
	}

}
