package myjavacollectionsprogram;

import java.util.Comparator;

/**
 * This class is use Sort the Employee By their Name
 * 
 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee name1, Employee name2) {
		
		return name1.empName.compareTo(name2.empName);
	}
}
