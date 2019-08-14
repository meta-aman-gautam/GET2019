package queueImplementation;

/**
 * This Interface have operations for Queue
 * 
 * @author Aman Gautam
 * 
 * @date 01/08/2019
 */
interface Queue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	boolean isFull();
	int frontElement();
	int rearElement();
	int queueSize();
	void displayQueue();

}
