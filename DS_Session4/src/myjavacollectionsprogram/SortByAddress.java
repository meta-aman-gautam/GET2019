package myjavacollectionsprogram;

import java.util.Comparator;

/**
 * This class is use Sort the Employee by their Address

 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class SortByAddress implements Comparator<Employee>{

	@Override
	public int compare(Employee address1, Employee address2) {
		
		return address1.address.compareTo(address2.address);
	}
}
