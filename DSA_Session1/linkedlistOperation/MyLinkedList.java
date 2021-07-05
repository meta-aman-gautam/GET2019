package linkedlistOperation ;

import java.util.*;

/**this is class to create a Linked list and rotate is sublist 
 * with the given L and R positions.
 * 
 * @author Aman Gautam
 *
 */
public class MyLinkedList {
	
	Node head ,head2 ;
	
	public static class Node{
		int data ;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next =null;
		}
	}

	/**add element to the list
	 * 
	 * @param list
	 * @param data
	 * @return
	 */
	public MyLinkedList addToList(MyLinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}
	/**
	 * displays the linked list 
	 * @param list
	 */
	public void display(MyLinkedList list) {
		Node last = head;
		if (last == null) {
			System.out.println("No element in the list");
		}
		while(last != null ){
			System.out.print(last.data);
			last = last.next ;
			System.out.print("->");
		}
		System.out.println("\n");
	}
	
	/**
	 * Gives the address of the nodes
	 * @param list
	 * @param position
	 * @return
	 */
	public Node checkReference(MyLinkedList list ,int position) {
		Node reference = head;
		while(position!=1) {
			reference = reference.next; 
			position--;
		}
		return reference;
	}
	
	/**
	 * Rotates the sub List of the linked list 
	 * @param list
	 * @param L
	 * @param R
	 * @param N
	 * @return list 
	 */
	public MyLinkedList rotateSubString(MyLinkedList list , int L , int R , int N) {
		
		if(L>R) {
			throw new AssertionError("Invalid values of L and R entered") ;
		}
		int traverse = N%(R-L+1) ;
		Node fly ,fly2,link;
		fly= checkReference(list,L-1) ;
		fly2= checkReference(list,R+1);
		link = checkReference(list,L+traverse);
	
		
		if(traverse ==0 || (traverse==0 && L==1)){
			//do nothing
		}
		else{
			checkReference(list,R).next = checkReference(list,L);
			checkReference(list,L+traverse-1).next= fly2;
			fly.next =link;
		}
		return list ;
	}
	
	/**Creates a manual looped linked list 
	 * 
	 * @param pos
	 */
	public void createLoop(int pos) {
		int i = 1;
		Node temporaryNode = head;
		Node fly = temporaryNode ;
		while (i != pos) {
			temporaryNode = temporaryNode.next;
			i++;
		}
		fly.next = temporaryNode;
	
	}
	
	/**
	 * Checks loop in the linked list 
	 * @return boolean value
	 */
	public boolean checkLoop() {
		List <Node> nodeList = new ArrayList<>();
		Node temporaryNode = head;
		while (temporaryNode.next != null) {
			if (nodeList.contains(temporaryNode))
				return true;
			else {
				nodeList.add(temporaryNode);
				temporaryNode = temporaryNode.next;
			}
		}
		return false;
	}

}
