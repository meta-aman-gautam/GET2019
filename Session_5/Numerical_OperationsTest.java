import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Numerical_OperationsTest {

	Numerical_Operations recursion = new Numerical_Operations() ;

	private int x;
	private int y;
	private int expectedOutput_LCM;
	private int expectedOutput_HCF;
	
	public Numerical_OperationsTest(int x, int y, int expectedOutput_LCM ,int expectedOutput_HCF) {

		this.x = x;
		this.y = y;
		this.expectedOutput_LCM = expectedOutput_LCM;
		this.expectedOutput_HCF = expectedOutput_HCF;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 6,7,42,1 },
				{ 4,5,20,1 },
				{ 14,7,14,7 },
		    });
	}
	
	@Test	//LCM test case
	public void LCMtest() {
		assertEquals(expectedOutput_LCM,recursion.lcm(x, y));
	}
	
	@Test	//HCF test case
	public void HCFtest() {
		assertEquals(expectedOutput_HCF,recursion.hcf(x, y));
	}
	
}


