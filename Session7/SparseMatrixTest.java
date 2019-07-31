import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SparseMatrixTest {
	
	private int[][] transpose_expected ,transpose_input,isSymmetricalInput,additionExpected ,add1,add2,mulExpected,mul1,mul2;

	public SparseMatrixTest(int[][] transpose_expected ,int[][]transpose_input,int[][]isSymmetricalInput,
			int [][]additionExpected,int[][]add1,int[][]add2 ,int [][]mulExpected,int[][]mul1,int[][]mul2 ) {
		this.transpose_expected = transpose_expected ;
		this.transpose_input = transpose_input ;
		this.isSymmetricalInput =isSymmetricalInput ;
		this.additionExpected =additionExpected ;
		this.add1 =add1 ;
		this.add2 =add2 ;
		this.mulExpected =mulExpected ;
		this.mul1 =mul1 ;
		this.mul2 =mul2 ;
	}
	
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{   new int[][]{{4, 3, 0}, {5 ,0 ,1}} ,new int[][]{{0, 0, 0, 4}, {5, 0 ,0 ,0}, {0, 0, 0, 0}},
					new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}},
					new int[][]{{8, 0, 0}, {0, 10, 0}, {0, 0, 4}},new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}},new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}},
					new int[][]{{0, 0, 0}, {20, 0, 0}, {0, 10, 0}},new int[][]{{0, 0}, {5, 0}, {0, 2}},new int[][]{{4, 0, 0}, {0, 5, 0}}},
		});
	}

	/**
     * Test for null input
     */
    @Test(expected = AssertionError.class)
    public void testForNullSparseMatrix() {
        new SparseMatrix(null);
              
    }
    
    /**
     * Test for empty input
     */
    @Test(expected = AssertionError.class)
    public void testForEmptySparseMatrix() {
        new SparseMatrix(new int[][] {});
              
    }
    
    /**
     * Test case for transpose of the matrix
     */
    @Test
    public void testForTranspose() {
        SparseMatrix matrix = new SparseMatrix(transpose_input);
        int[][] transpose = matrix.transpose();
        
        assertArrayEquals(transpose_expected, transpose);   
    }
    

    /**
     * Positive test case for isSymmetrical()
     */
    @Test
    public void testForSymmetrical() {
        SparseMatrix matrix = new SparseMatrix(isSymmetricalInput);
        boolean isSymmetrical = matrix.isSymmetrical();
      
        assertTrue(isSymmetrical);
        
    }
    
    
    /**
     * Negative test case for isSymmetrical()
     */
    @Test (expected = AssertionError.class )
    public void testForSymmetrical_AssertionError() {
        SparseMatrix matrix = new SparseMatrix(isSymmetricalInput);
        boolean isSymmetrical = matrix.isSymmetrical();

        assertFalse(isSymmetrical);
        
    }
    
    
    /**
     * Test case for addMatrices when matrices have same dimensions
     */
    @Test
    public void testForAddition() {
        SparseMatrix matrix1 = new SparseMatrix(add1);
        SparseMatrix matrix2 = new SparseMatrix(add2);
        
        int[][] addition = SparseMatrix.addMatrices(matrix1, matrix2);;
        assertArrayEquals(additionExpected, addition);
    }
    
    /**
     * Test case for addMatrices when matrices don't have same dimensions
     */
    @Test(expected = AssertionError.class)
    public void testForAddition_AssertionError() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0}, {0, 5}, {0, 0}});
        
        SparseMatrix.addMatrices(matrix1, matrix2);
    }
    
    /**
     * Test case for multiplyMatrices when matrices have multiplication compatible dimensions
     */
    @Test
    public void testForMultiplication() {
        SparseMatrix matrix1 = new SparseMatrix(mul1);
        SparseMatrix matrix2 = new SparseMatrix(mul2);
        
        int[][] multiplication = SparseMatrix.multiplyMatrices(matrix1, matrix2);
        assertArrayEquals(mulExpected, multiplication);
    }
    
    /**
     * Test case for multiplyMatrices when matrices don't have multiplication compatible dimensions
     */
    @Test(expected = AssertionError.class)
    public void testForMultiplication_AssertionError() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{0}, {5}, {0}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}});
        
        SparseMatrix.multiplyMatrices(matrix1, matrix2);
    }
}
