package EmployeeQuickSort;

public class MyLinkedList {

	private Node head ;


	public Node addNode(Employee data){
		Node newNode = new Node(data);
		if(head ==null){
			head = newNode;
		}
		else{
			Node last =head;
			while(last!=null){
				last=last.next;
			}
			last = newNode;
		}
		return head;
	}
	
	public Node findPivot(Node head){
		Node last =head;
		while(last!=null){
			last=last.next;
		}
		return last;
	}
	
	public Node partition(Node head ,Node start,Node last){
		
		Node temp =head;
		Node ref = head;
		Node prev = head;
		Node link= head;
		
		Node partitionIndex = start;
		Node pivot = findPivot(head);
		 
		while(temp.next.next!=null){
			if(temp.data.salary >pivot.data.salary && temp!=pivot){
				swap()
				partitionIndex = partitionIndex.next;
			}
			else if(temp.data.salary ==pivot.data.salary&& temp!=pivot){
				
			}
			
			temp=temp.next;
		}
		swap ()
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Node quickSort(){
		
		return node;
	}
}
