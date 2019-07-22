package Polynomial_Operations;

import static org.junit.Assert.*;

import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class PolyTest {

	public Poly Poly =new Poly();

	private int input;
	private int expectedValue;
	private float value ;
	private float evaluatedValue;
	private String valueAdd;
	private String evaluatedValueAdd;
	private String valueMultiply;
	private String evaluatedValueMultiply;
	private Poly add1 =new Poly();
	private Poly add2 =new Poly();
	private Poly mul1 =new Poly();
	private Poly mul2 =new Poly();
	
	
	public PolyTest(int expectedValue, int input,
					float value ,float evaluatedValue ,
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
			{   new Poly(new int[] { 6, 5, 2 }).degree(), 2,
				new Poly(new int []{1,2,4}).evaluate(2) ,21.0 ,
				new Poly(new int[]{ 6, 4, 2 }),new Poly(new int[]{ 6,0, 4, 2 }),"[12, 4, 6, 2]",
				new Poly(new int[]{ 5, 0, 10, 6 }),new Poly(new int[]{ 1, 2, 4 }), "[5, 10, 30, 26, 52, 24]"}	

		});
	}
	
	@Test
	public void testForDegreeOfPolynomial() {
		assertEquals(expectedValue, input);
	}

	// This method tests evaluate method
	@Test
	public void testForEvaluation() {
		assertEquals(evaluatedValue,value,(float)0.0);	
	}
	
	// This method tests addPolynomial method
	@Test
	public void testForAddition() {
		valueAdd = Poly.add(add1, add2);
		assertEquals(evaluatedValueAdd, valueAdd);
	}
	
	@Test
	public void testForMultiplicaion() {
		valueMultiply =Poly.mul(mul1, mul2);
		assertEquals(evaluatedValueMultiply,valueMultiply);
	}

}
