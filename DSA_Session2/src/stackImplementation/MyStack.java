package stackImplementation;

public class MyStack {
	final int MAX= 100;
	String[] stack = new String[MAX];
	int top;
	public MyStack(){
		top=-1;
	}
	
	boolean push(String data){
		boolean answer=false ;
		if(top>=(MAX-1)){
			System.out.println("Stack overflow");
			answer= false;
		}
		else{
			stack[++top]=data;
			System.out.println(data+" added");
			answer =true;
		}
		return answer;
	}
	
	String pop(){
		String x = null ;
		if(top<0){
			System.out.println("Stack underflow");
		}
		else{
			x= stack[top--];
			System.out.println(x+" removed");
		}
		return x;
	}

	String peek() {
		String x = null;
		if (top < 0) {
			System.out.println("Stack Underflow");
		} else {
			x = stack[top];
		}
		return x;
	}
}
