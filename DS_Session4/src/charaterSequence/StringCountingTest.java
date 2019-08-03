package charaterSequence;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class creation for - method Calculating and Check
 * 
 * @author Aman Gautam
 * Date- 3/8/2019 
 */
public class StringCountingTest {

	StringCounting SC = new StringCounting();

	//Positive Test cases
	@Test
	public void testForCheck() {
		assertEquals(0, SC.check("AMAN GAUTAM"));
		assertEquals(0, SC.check("AMAN KUMAR GAUTAM"));
		assertEquals(6, SC.check("AMAN GAUTAM"));
		assertEquals(0, SC.check("AMAN"));
		assertEquals(0, SC.check("A"));
		assertEquals(3, SC.check("AMAN"));
	}
	
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
	//Negative Test Cases
	@Test 
	public void testForCheck_Negative() {
		//wrong expected values
		assertNotEquals(6, SC.check("AMAN GAUTAM"));
		assertNotEquals(8, SC.check("AMAN KUMAR GAUTAM"));
		assertNotEquals(3, SC.check("AMAN"));
	}
	
	//Assertion Error
	@Test (expected = AssertionError.class)
	public void testForCheck_AssertionError() {
		assertEquals("Input Invalid", SC.check(null));
	
	}
}
