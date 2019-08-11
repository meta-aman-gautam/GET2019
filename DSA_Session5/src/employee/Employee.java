package employee;

/**
 * Class employee which contains basic information of each employee
 * 
 * @author Aman Gautam
 * 
 * Dated - 11/08/2019
 */
public class Employee {
	
	String empName ;
	int age ;
	double salary;
	
	public Employee(String empName ,int age ,double salary) {
		this.salary = salary;
		this.age = age ;
		this.empName = empName;
	}
	
}
