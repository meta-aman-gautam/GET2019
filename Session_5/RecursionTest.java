import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;

/**Recursion ,Nqueen ,Search Test cases
 * 
 * @author Aman Gautam
 *
 */
public class RecursionTest {

	Recursion obj = new Recursion() ;
	Search obj2 = new Search();
	Nqueen solve = new Nqueen();
	
	private int[] inputArray;
	private int[] inputArray1;
	private int[][] inputArray2;
	private boolean A;
	private int startRow;
	private int dimensionOfChessBoard;
	private int x;
	private int y;
	private int element;
	private Recursion recursion;
	private Search search;
	private int expectedOutput_LCM;
	private int expectedOutput_HCF;
	int expectedOutput_Binary;
	int expectedOutput_Linear;
	
	public RecursionTest(int [] inputArray,int []inputArray1, boolean A, int [][]inputArray2 ,int startRow,int dimensionOfChessBoard, int element,
							int expectedOutput_Linear,int expectedOutput_Binary ,int x, int y, int expectedOutput_LCM ,int expectedOutput_HCF) {
		this.inputArray = inputArray;
		this.inputArray2 = inputArray2;
		this.element = element ;
		this.startRow =startRow;
		this.A =A;
		this.dimensionOfChessBoard = dimensionOfChessBoard;
		this.x = x;
		this.y = y;
		this.expectedOutput_LCM = expectedOutput_LCM;
		this.expectedOutput_HCF = expectedOutput_HCF;
		this.expectedOutput_Binary = expectedOutput_Binary;
		this.expectedOutput_Linear = expectedOutput_Linear;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1,2,3,4,5,6}, new int[] { 1, 2,4,5,8 } ,false ,new int[][] {{0,0,0},{0,0,0},{0,0,0}},0 ,3, 4, 3 ,5,6,7,42,1 },
				
				
				{ new int[] { 2,3,5,8,9 }, new int[] { 1, 2, 5, 9}, true,new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 0,4,5, 2, 2,4,5,20,1 },
				
				
				{ new int[] { 1, 4, 5, 18 },  new int[] { 1, 4,  5,8 },true,new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}} ,0,8, 5, 5, 2,14,7,14,7 },
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
	@Test     //Linear Search
	public void linearSearchtest() {
		assertEquals(expectedOutput_Linear,search.linearSearch(inputArray, element));
	}
	
	@Test     //Binary search
	public void binarSearchTest() {
		assertEquals(expectedOutput_Binary,search.binarySearch(inputArray1, element));
	}
	
	@Test  //Nqueen Problem
	public void nQueenProblemTest() {
		assertEquals(A, solve.nQueen(new int[][] {{0,0,0},{0,0,0},{0,0,0}},0,3));
	}
}


