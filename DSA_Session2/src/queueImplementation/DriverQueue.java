package queueImplementation;

public class DriverQueue {

	public static void main(String[] args) {
		MyQueue me =new MyQueue();
		
		me.enqueue(3);
		me.enqueue(4);
		me.enqueue(5);
		me.enqueue(6);
		me.enqueue(8);
		me.enqueue(9);
		me.dequeue();
		me.dequeue();
		me.enqueue(8);
		me.enqueue(9);
		me.enqueue(10);

		
	}

}
