import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SearchTest {

	Search search = new Search();
	
	private int[] inputArray,inputArray1;
	private int element,expectedOutput_Binary,expectedOutput_Linear;
	
	public SearchTest(int [] inputArray,int []inputArray1,int element,int expectedOutput_Linear,int expectedOutput_Binary ) {
		this.inputArray = inputArray;
		this.inputArray1 = inputArray1;
		this.element = element ;
		this.expectedOutput_Binary = expectedOutput_Binary;
		this.expectedOutput_Linear = expectedOutput_Linear;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1,2,3,4,5,6}, new int[] { 1,2,4,5,8},5 ,4,3},
				{ new int[] { 2,3,5,8,9 }, new int[] { 1, 2, 5,9},5, 2, 2},
				{ new int[] { 1, 4, 5, 18 },  new int[] { 1, 4, 5,18 },18,3, 3},
		    });
	}
	
	@Test     //Linear Search
	public void linearSearchtest() {
		assertEquals(expectedOutput_Linear,search.linearSearch(inputArray, element));
	}
	
	@Test     //Binary search
	public void binarySearchTest() {
		assertEquals(expectedOutput_Binary,search.binarySearch(inputArray1, element));
	}

}
