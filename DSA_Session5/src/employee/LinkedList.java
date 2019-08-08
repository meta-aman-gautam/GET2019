package employee;
/**
 * program to get employee list based on their salary
 * 
 * @author Aman Gautam
 * 
 * Dated -06/08/2019 
 */
public class LinkedList {
	Node headNode;

	/**
	 * method to insert data into linked list
	 * 
	 * @param list {LinkedList} contain employee's data
	 * @param data of employee
	 * @return list{List} of employee
	 */
	public LinkedList insert(LinkedList list, Employee data) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (list.headNode == null) {
			list.headNode = newNode;
		} else {
			Node last = list.headNode;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	/**
	 * method to get list of employee sorted by salary
	 * 
	 * @param employeeList {LinkedList} list of employees (unsorted)
	 * @return sorted list {LinkedList}
	 */
	public LinkedList sortBySalary(LinkedList employeeList) {

		Node currentNode = employeeList.headNode;
		Node nextNode = null;
		Employee swap;
		while (currentNode != null) {
			nextNode = currentNode.next;
			while (nextNode != null) {
				
				if (nextNode.data.getEmployeeSalary() > currentNode.data.getEmployeeSalary()) {
					swap = currentNode.data;
					currentNode.data = nextNode.data;
					nextNode.data = swap;
				}
				// for sorting on age basis when salary of two employees are equal
				if (nextNode.data.getEmployeeSalary() == currentNode.data.getEmployeeSalary()) {
					if (nextNode.data.getEmployeeAge() <= currentNode.data.getEmployeeAge()) {
						swap = currentNode.data;
						currentNode.data = nextNode.data;
						nextNode.data = swap;
					}
				}
				nextNode = nextNode.next;
			}
			currentNode = currentNode.next;
		}
		return employeeList;
	}
}
