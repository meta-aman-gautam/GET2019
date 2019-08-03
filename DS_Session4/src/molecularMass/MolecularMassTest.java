package molecularMass;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * this is Test class for MolecularMass Test
 * 
 * @author Aman Gautam
 * dated -3/8/2019
 *
 */
public class MolecularMassTest {

	MolecularMass Obj =new MolecularMass();
	int expected;
	
	//Positive Test case
	@Test
	public void testForMolecularMass() {
		expected=Obj.evaluate("H2OCO4(CO2)14");
		assertEquals(expected, 710);
		
		expected=Obj.evaluate("H2OCO4");
		assertEquals(expected, 94);
		
		expected=Obj.evaluate("(C22H)H2O");
		assertEquals(expected, 283);
	}

	
	//Negative test case
	@Test 
	public void testForMolecularMass_Failed() {
		expected=Obj.evaluate("(C22H1)13H2O");
		assertNotEquals(expected, 344);
		
		expected=Obj.evaluate("(C22H)H2O");
		assertNotEquals(expected, 31);
		
		expected=Obj.evaluate("H2O");
		assertNotEquals(expected, 31);
		
		expected=Obj.evaluate("(C22H)");
		assertNotEquals(expected, 264);
	}
	
	//Assertion Error
	@Test (expected = AssertionError.class)
	public void testForMolecularMass_AssertionError() {
		expected=Obj.evaluate(null);
		assertEquals("Input Cannot be Null", expected);

		
	
	}

}
