package employee;

/**
 * program to get employee list based on their salary
 * 
 * @author Aman Gautam
 * 
 * Dated -11/08/2019 
 */
public class LinkedList {

	private Node head,newNode ;

	/**
	 * method to get list of employee sorted by salary
	 * 
	 * @param employeeList {data} list of employees (unsorted)
	 */
	public void insertEmployee(Employee data) {
		
		newNode = new Node(data);
		
		if(head==null) {
			head = newNode;
		}
		else {
			
			Node temp =head ;
			
			while(temp.next!=null) {	
				temp= temp.next;
			}
			temp.next = newNode;
		}
	}
	
	/**
	 * Method to display the Employee data 
	 * 
	 */
 	public void show() {
		 Node temp = head;
		 while(temp!=null) {
			 System.out.println("Name- " + temp.data.empName
				+ "  Age- "	+ temp.data.age
		        + "  Salary- " + temp.data.salary);
			 temp=temp.next;
		 }
	 }
	
	/**
	 * method to get list of employee sorted by salary and age too .
	 * 
	 * @return {Node}
	 */
	public Node sortBySalary() {
		
		Node temp = this.head;
		Node prev = this.head;
		
		//while we do no reach the last node of the list
		while(temp.next!=null) {
			
			Node ref2 =this.head ;
			Node prevRef2 = this.head;			
			
			// Until the salary of current element is greater than the previous elements.
			while(ref2 != temp && temp.data.salary < ref2.data.salary) {
				prevRef2 = ref2;
				ref2 = ref2.next;
			}
			
			// If the list before temp is sorted, then move temp to next node.
			if(ref2 == temp) {
				prev = temp;
				temp = temp.next;
				
			}
			
			// When salary of two employees are equal.
			if(temp.data.salary == ref2.data.salary) {
				
				if(ref2.data.age < temp.data.age) {
					prev.next = temp.next;
					temp.next = ref2.next;
					ref2.next = temp;
				} else {
					prev.next = temp.next;
					if(head == ref2) {
						head = temp;
					}
					else {
						prevRef2.next = temp;
					}
					temp.next = ref2;
				}
				temp = prev;
			}
			
			// If salary of current element is greater than the previous one.
			if(temp.data.salary > ref2.data.salary) {
				prev.next = temp.next;
				temp.next = ref2;
				if(head == ref2) {
					head = temp;
				}
				else {
					prevRef2.next = temp;
				}
				temp = prev;						
			}	
			prev = temp;
			temp = temp.next;
		}
		return head;	
		}

}
