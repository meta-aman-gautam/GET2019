package charaterSequence;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class creation for - method Calculating and Check
 * 
 * @author Aman Gautam
 * Date- 11/8/2019 
 */
public class StringCountingTest {

	StringCounting SC = new StringCounting();


	
	//Positive Test Cases 
	@Test 
	public void testForCalculating() {
		assertEquals(6, SC.calculation("AMAN GAUTAM"));
		assertEquals(3, SC.calculation("AMAN"));
		assertEquals(5, SC.calculation("A GAUT AM"));

	}
	
	//Negative Test cases
	@Test  
	public void testForCalculating_Negative() {
		assertNotEquals(4, SC.calculation("AMAN GAUTAM"));
		assertNotEquals(1, SC.calculation("AMAN"));
		assertNotEquals(8, SC.calculation("A GAUT AM"));

	}

	//Assertion Error
	@Test (expected = AssertionError.class)
	public void testForCheck_AssertionError() {
		assertEquals("Input Invalid", SC.calculation(null));
	
	}
}
