package linkedlistOperation;

import linkedlistOperation.MyLinkedList;
import linkedlistOperation.MyLinkedList.Node;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * This class contains the test methods for testing methods of class LinkedList
 * 
 * @author Aman Gautam
 */
public class MyLinkedListTest {

	/*
	 * test Rotation
	 */
	@Test
	public void testRotation1() {
		MyLinkedList list = new MyLinkedList();
		for(int count_i=2;count_i<8;count_i++) {
			list.addToList(list, count_i);
		}
		
		MyLinkedList temporaryNode = list.rotateSubString(list, 2, 5, 2); 
		Node tempNode = temporaryNode.head;
		
		int i=0;
		int[] captureData = new int[6];
		while (tempNode != null) {
			captureData[i]=tempNode.data;
			tempNode = tempNode.next;
			i++;
		}
		int[] expectedData = { 2, 5, 6, 3, 4, 7};

		assertArrayEquals(expectedData, captureData);
	}

	/*
	 * test Rotation with assertion error
	 */
	@Test(expected = AssertionError.class)
	public void testRotation_AssertionError() {
		MyLinkedList list = new MyLinkedList();
		MyLinkedList temporaryNode = list.rotateSubString(list, 6, 5, 2); 
		Node tempNode = temporaryNode.head;
	}

	/*
	 * test for Loop in the linked list 
	 */
	@Test
	public void testforLoop() {

		MyLinkedList list = new MyLinkedList();
		for(int count_i=2;count_i<8;count_i++) {
			list.addToList(list, count_i);
		}
		list.createLoop(1);
		assertEquals(true, list.checkLoop());
	}
	
	/*
	 * test for Loop in the linked list 
	 */
	@Test
	public void testforLoop_NoLoop() {
		MyLinkedList list = new MyLinkedList();
		for(int count_i=2;count_i<8;count_i++) {
			list.addToList(list, count_i);
		}
		
		assertEquals(false, list.checkLoop());
	}



}
