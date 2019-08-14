package employee;

/**
 * Node class for employee data
 * 
 * @author Aman Gautam
 * 
 * Dated -11/08/2019
 *
 */
public class Node {

	Employee data;
	
	Node next ;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param data of employee
	 */
	public Node(Employee data) {
		this.data = data;
		next = null;
	}
}
