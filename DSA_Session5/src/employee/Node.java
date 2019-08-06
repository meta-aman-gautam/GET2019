package employee;
/**
 * Node class for employee data
 * 
 * @author Aman Gautam
 * 
 * Dated -06/08/2019
 *
 */
public class Node {
	Employee data;
	Node next;

	Node(Employee data) {
		this.data = data;
		this.next = null;
	}
}
