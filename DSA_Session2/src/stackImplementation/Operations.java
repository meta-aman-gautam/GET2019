package stackImplementation;

import stackImplementation.MyStack;

public class Operations {
	
	MyStack stack = new MyStack();
	
	public int evaluateExpresion(String data){
		Double answer=0.0, value1=0.0,value2=0.0;
		String[] words = data.split("\\s");
//		for(int i=0;i<words.length;i++){
//			System.out.println(words[i]);
//		}
		for(int i=0;i<words.length;i++){
			if(!words[i].equals("+") || !words[i].equals("-") || !words[i].equals("/") || !words[i].equals("%")  || !words[i].equals("*") ){
				System.out.println(words[i]);
				stack.push(words[i]);
			}
			else{
				switch (words[i]) {
					case "-":
						value1= Double.parseDouble(stack.pop()); 
						value2=Double.parseDouble(stack.pop()); 
						answer = (value1-value2);
						stack.push(answer.toString());
						break;
						
					case "+":
						value1= Double.parseDouble(stack.pop()); 
						value2= Double.parseDouble(stack.pop()); 
						answer = (value1+value2);
						stack.push(answer.toString());
						break;
						
					case "*":
						value1= Double.parseDouble(stack.pop()); 
						value2= Double.parseDouble(stack.pop()); 
						answer = (value1*value2);
						stack.push(answer.toString());
						break;
						
					case "/":
						value1= Double.parseDouble(stack.pop()); 
						value2= Double.parseDouble(stack.pop()); 
						answer = (value1/value2);
						stack.push(answer.toString());
						break;
						
					case "%":
						value1= Double.parseDouble(stack.pop()); 
						value2= Double.parseDouble(stack.pop()); 
						answer = (value1%value2);
						stack.push(answer.toString());
						break;
				}
			}
		}
		return answer.intValue();
	}
	
	
}
