package question3;

/**
 * Interface of a priority queue
 * @author Aman Gautam
 * Dated 18/08/2019
 */
interface PriorityQueue{
	
	void enQueue(Player data);
	Player deQueue();
	boolean isEmpty();
	int queueSize();

}