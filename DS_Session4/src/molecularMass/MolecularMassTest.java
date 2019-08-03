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
	public void testForMolecularMass1() {
		expected=Obj.evaluate("H2OCO4(CO2)14");
		assertEquals(expected, 710);
	}
	//Positive Test case
	@Test
	public void testForMolecularMass2() {
		expected=Obj.evaluate("H2OCO4");
		assertEquals(expected, 94);
	}
	
	//Positive Test case
	@Test
	public void testForMolecularMass3() {
		expected=Obj.evaluate("(C22H1)13H2O");
		assertEquals(expected, 3463);
	}
	
	//Negative test case
	@Test (expected =AssertionError.class)
	public void testForMolecularMass_AssertionError() {
		expected=Obj.evaluate("(C22H1)13H2O");
		assertEquals(expected, 344);
	}

}
