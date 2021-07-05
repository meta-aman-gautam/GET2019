package linkedlistOperation ;
/**
 * Initialization of the main class .
 
 * @author Aman Gautam
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();

		list.addToList(list, 1);
		list.addToList(list, 2);
		list.addToList(list, 3);
		list.addToList(list, 4);
		list.addToList(list, 5);
		list.addToList(list, 6);
		list.addToList(list, 7);
		
		list.display(list);
		
		list.rotateSubString(list, 2, 3,1);
		list.display(list);
		System.out.println("____________\n");
	
		list.createLoop(1);
		System.out.println(list.checkLoop());
	}

}
