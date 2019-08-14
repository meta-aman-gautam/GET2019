package stackImplementation;

import java.util.Scanner;
/**
 * This class provide the UI interface
 * 
 * @author Aman Gautam
 * 
 * Dated 01/08/2019
 */
public class Driver {

	public static void main(String[] args) {

		Scanner inputObj = new Scanner(System.in);
		EvaluateExpression evaluate=new EvaluateExpression();
		String expression,postfix;
		System.out.println("Enter the expression.. ");
		expression=inputObj.nextLine();
		postfix=evaluate.infixToPostfix(expression);
		System.out.println("postfix expression is : "+postfix);
		System.out.println("Result is : "+evaluate.evaluatePostfix(postfix));
		inputObj.close();
	}
}
