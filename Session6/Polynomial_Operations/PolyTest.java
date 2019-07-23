package Polynomial_Operations;

package immutable_Polynomial;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PolyTest {
	
	Poly Poly =new Poly();
	Poly input, value , add1 , add2, mul1, mul2 ;
	private float expectedValue, evaluatedValue;
	private String evaluatedValueAdd, evaluatedValueMultiply;
	
	public PolyTest(Poly input,float expectedValue,
				Poly value ,float evaluatedValue ,
				Poly add1,Poly add2 , String evaluatedValueAdd,
				Poly mul1,Poly mul2, String evaluatedValueMultiply ) {

		// is test of degree
		this.input = input;
		this.expectedValue = expectedValue;

		// is test of evaluation of polynomial 
		this.value = value;
		this.evaluatedValue = evaluatedValue;

		// is test of Add of polynomial
		this.evaluatedValueAdd = evaluatedValueAdd;
		this.add1 = add1 ;
		this.add2 = add1;
		
		// is test of multiply of Polynomial
		this.evaluatedValueMultiply = evaluatedValueMultiply;
		this.mul1 =mul1;
		this.mul2 =mul2;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
			{  new Poly(new int[] { 6, 5, 2 }), 2.0,
			   new Poly(new int []{1,2,4}) ,21.0 ,
			   new Poly(new int[]{ 6, 4, 2 }),new Poly(new int[]{ 6,0, 4, 2 }),"[12, 4, 6, 2]",
			   new Poly(new int[]{ 5, 0, 10, 6 }),new Poly(new int[]{ 1, 2, 4 }), "[5, 10, 30, 26, 52, 24]"},	
			
			{  new Poly(new int[] { 1, 1, 2 }), 3.0,
			   new Poly(new int []{1,7,3}),78.0 ,
			   new Poly(new int[]{ 1, 2, 2 }),new Poly(new int[]{ 6,0, 4, 2 }),"[6, 4, 12 ]",
			   new Poly(new int[]{ 5, 10, 6 }),new Poly(new int[]{ 1, 2, 4 }), "[5, 10, 26, 52, 24]"}
		});
	}
	
	//this method tests Degree of Polynomial 
	@Test
	public void testForDegreeOfPolynomial() {
		assertEquals(expectedValue, (float)input.degree() ,(float)0.0);
	}
	
	 //This method tests evaluate method
	@Test
	public void testForEvaluation() {
		assertEquals((float)evaluatedValue,value.evaluate((float)2.0),(float)0.0);	
	}
	
	// This method tests addPolynomial method
	@Test
	public void testForAddition() {
		assertEquals(evaluatedValueAdd, Poly.add(add1, add2));
	}
	
	// This method tests mulPolynomial method
	@Test
	public void testForMultiplicaion() {
		assertEquals(evaluatedValueMultiply,Poly.mul(mul1, mul2));
	}
}
