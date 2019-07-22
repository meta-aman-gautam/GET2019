import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NqueenTest {

	Nqueen solve = new Nqueen();
	
	private int[][] inputArray2;
	private boolean Answer;
	private int startRow;
	private int dimensionOfChessBoard;
	
	public NqueenTest(boolean Answer, int [][]inputArray2 ,int startRow,int dimensionOfChessBoard) {
		
		this.inputArray2 = inputArray2;
		this.startRow =startRow;
		this.Answer =Answer;
		this.dimensionOfChessBoard = dimensionOfChessBoard;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ false ,new int[][] {{0,0,0},{0,0,0},{0,0,0}},0 ,3},
				{ false,new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 0,4},	
				{ false,new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}} ,0,8},
		    });
	}
	
	@Test  //Nqueen Problem
	public void nQueenProblemTest() {
		assertEquals(Answer, solve.nQueen(new int[][] {{0,0,0},{0,0,0},{0,0,0}},0,3));
	}
}
