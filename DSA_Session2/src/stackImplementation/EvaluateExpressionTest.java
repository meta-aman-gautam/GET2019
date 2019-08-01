package stackImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluateExpressionTest {

	@Test
	public void testForConversion()
	{
	String infixExpression = "( 1 + 2 ) * ( 3 + 4 )";
	EvaluateExpression evaluationObject = new EvaluateExpression();
	String postfixExpression = evaluationObject.infixToPostfix(infixExpression);
	String expectedPostfixExpression = "1 2 + 3 4 + * ";
	assertEquals(expectedPostfixExpression, postfixExpression);
	}

	@Test
	public void testForEvaluation()
	{
	String infixExpression = "( 1 + 2 ) * ( 3 + 4 )";
	EvaluateExpression evaluationObject = new EvaluateExpression();
	String postfixExpression = evaluationObject.infixToPostfix(infixExpression);
	assertEquals("21", evaluationObject.evaluatePostfix(postfixExpression));
	}

}
