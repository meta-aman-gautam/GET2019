package myjavacollectionsprogram;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Driver class which has main for this package "myjavacollectionsprogram";
 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class Driver {
	
	public static void main(String [] args){
		
		List<Employee> listOfEmployee= new ArrayList<Employee>();
		
		listOfEmployee.add(new Employee(1,"AAA","thisDDDDD"));
		listOfEmployee.add(new Employee(3,"BBB","thisBBBBB"));
		listOfEmployee.add(new Employee(4,"BAB","thisEEEEE"));
		listOfEmployee.add(new Employee(2,"DDD","thisCCCCC"));
		
		//sorting by id
		Collections.sort(listOfEmployee, new SortByEmpId());
		
		for(int i=0;i<listOfEmployee.size();i++){
			System.out.println(listOfEmployee.get(i).empId+"__"
							+ listOfEmployee.get(i).empName + "__"
							+ listOfEmployee.get(i).address);
		}
		System.out.println();
		
		//sorting by Name
		Collections.sort(listOfEmployee, new SortByName());

		for (int i = 0; i < listOfEmployee.size(); i++) {
			System.out.println(listOfEmployee.get(i).empId + "__"
							+ listOfEmployee.get(i).empName + "__"
							+ listOfEmployee.get(i).address);
		}
		System.out.println();
		
		//sorting by Address
		Collections.sort(listOfEmployee, new SortByAddress());

		for (int i = 0; i < listOfEmployee.size(); i++) {
			System.out.println(listOfEmployee.get(i).empId + "__"
							+ listOfEmployee.get(i).empName + "__"
							+ listOfEmployee.get(i).address);
		}
	}
}
