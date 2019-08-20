package EmployeeQuickSort;
/**
 * class to represent a node in linkedList
 * @author Aman Gautam
 */
public class Node {

	public Employee employee;
	public Node next;

	/**
	 * constructor for Node
	 * @param employee
	 */
	public Node(Employee employee) {
		this.employee = employee;
		this.next = null;
	}
}