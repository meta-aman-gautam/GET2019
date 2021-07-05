package myjavacollectionsprogram;
/**
 * this is Employee class which is used to collect data of students 
 * 
 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class Employee {

	String empName , address;
	int empId ;
	//constructor
	public Employee(int empId ,String empName , String address ){
		this.address =address;
		this.empId = empId ;
		this.empName = empName ;
	}
}
