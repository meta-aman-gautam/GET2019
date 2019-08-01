package studentCouncelling;

public class MyQueue {

	int rear,front;
	final int MAX=30;
	
	Student student ;
	
	Student[] myQueue = new Student[MAX];
	public MyQueue(){
		this.rear=-1;
		this.front=-1;
		
	}
	
	
	public boolean isEmpty(){
		if(rear==-1 && front==-1){
			return true;
		}
		else{
			return false;
		}
	}

	public void enqueue(Student student) {
		if ((rear + 1) % MAX == front) {
			System.out.println("Queue is full");
		} 
		else {
			if (isEmpty()) {
				rear = 0;
				front = 0;
			} else {
				rear = (rear + 1) % MAX;
			}
			myQueue[rear] = student;
			//System.out.println(student + " Enqueued");
		}
	}
	
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is already empty");
		} 
		else {
			if (front == rear) {
				this.rear = -1;
				this.front = -1;
			}
			else {
				front = (front + 1) % MAX;
			}
			//System.out.println(" Dequeued");
		}
	}
}