package stackImplementation;

public class Driver {

	public static void main(String[] args) {
		MyStack stack = new MyStack();

//		for (int i = 0; i < 10; i++) {
//			stack.push("" + i);
//		}
//
//		System.out.println(stack.peek());
//		
//		stack.pop();
//		System.out.println(stack.peek());
		
		
		Operations op = new Operations();
		System.out.println(op.evaluateExpresion("1 2 3 4 + *"));
		
	
	}

}
