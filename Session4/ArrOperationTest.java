import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	private int[] inputArray;
	private int x;
	private int y;
	private int expectedResult[];
	ArrOperation obj = new ArrOperation();
	
	@Test
	public void maxMirrorTest1() {
		int []inputArray= {1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3,obj.maxMirror(inputArray));  
	}
	@Test
	public void maxMirrorTest2() {
		int []inputArray= {1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3,obj.maxMirror(inputArray));  
	}
	@Test
	public void maxMirrorTest3() {
		int []inputArray= {1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3,obj.maxMirror(inputArray));
	}
		
	
	@Test
	public void testNoOfClumps_WithExpectedOutput1() {
		int []inputArray= {1,2,2,3,4,4};
		assertEquals(2,obj.testNoOfClumps_WithExpectedOutput(inputArray));  
	}
	@Test
	public void testNoOfClumps_WithExpectedOutput2() {
		int []inputArray= {2,1,1,1,2};
		assertEquals(1,obj.testNoOfClumps_WithExpectedOutput(inputArray));  
	}
	@Test
	public void testNoOfClumps_WithExpectedOutput3() {
		int []inputArray= {1,1,2,2,2,1,1};
		assertEquals(3,obj.testNoOfClumps_WithExpectedOutput(inputArray));
	}
	
	
	@Test
	public void fisXYTest1() {
		
	    int []inputArray ={5,4,9,4,9,5};
	    int []outputArray = {9,4,5,4,5,9};
		assertArrayEquals(outputArray, obj.fixXY(inputArray, 4, 5));
		
	}
	@Test
	public void fixXYTest2() {
		int []inputArray= {1,2,5,4,3};
		int []outputArray = {1,2,3,4,5};
		assertArrayEquals(outputArray, obj.fixXY(inputArray, 4, 5));
	}
	@Test
	public void fixXYTest3() {
		int []inputArray= {1,4,1,5};
		int []outputArray = {1,4,5,1};
		assertArrayEquals(outputArray, obj.fixXY(inputArray, 4, 5));
	}
	
	@Test
	public void SplitTest1(){
		int []inputArray = {1,1,1,2,1};
		assertEquals(3, obj.split(inputArray));    
	}
	
	@Test
	public void SplitTest2(){
		int []inputArray = { 2,1,1,2,1};
		assertEquals(-1, obj.split(inputArray));    
	}
	
	@Test
	public void SplitTest3(){
		int []inputArray = { 10,10 };
		assertEquals(1, obj.split(inputArray));    
	}
}
