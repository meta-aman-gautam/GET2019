/**
* This class is designed to make a sparse matrix.
* 
* @author Aman Gautam
* 
*/
public final class SparseMatrix {

	private int[][] sparseMatrix;
	private int rows;
	private int columns;
	
	private static final int VALUE = 0;
    private static final int ROW_NUMBER = 1;
    private static final int COL_NUMBER = 2;
	
    /*
     * This class represents the Sparse matrix where most
     * of the elements are zero .
     */
	public SparseMatrix(int[][] givenArray) {
		int length = 0;
		int maxColLength = 0;														
		
		if(givenArray == null) {
			throw new AssertionError("Cant be null.");
		}
		
		if(givenArray.length == 0) {
		    throw new AssertionError("Cant be empty.");
		}
		
		//to count length of non zero numbers
		for(int row = 0; row < givenArray.length; row++) {
			for(int col = 0; col < givenArray[row].length; col++) {
				if(givenArray[row][col] != 0) {
					length++;
				}
				if(givenArray[row].length > maxColLength) {
					maxColLength = givenArray[row].length;
				}
			}
		}
		
		//create array of size of non zero elements
		int[][] matrix = new int[length][3];
		int index = 0;
		for(int row = 0; row < givenArray.length; row++) {
			for(int col = 0; col < givenArray[row].length; col++) {
				if(givenArray[row][col] != 0) {
					matrix[index][VALUE] = givenArray[row][col];
					matrix[index][ROW_NUMBER] = row;
					matrix[index][COL_NUMBER] = col;
					index++;
				}
			}
		}
		
		this.rows = givenArray.length;
		this.columns = maxColLength;
		this.sparseMatrix = matrix;
		
	}
	
	/**Calculates the transpose of an array
	 * 
	 * @return transpose of array
	 */
	public int[][] transpose() {
		int[][] transposeArray = new int[sparseMatrix.length][3];
		
		for(int count_i = 0; count_i < sparseMatrix.length; count_i++) {
			transposeArray[count_i][VALUE] = sparseMatrix[count_i][VALUE];
			transposeArray[count_i][ROW_NUMBER] = sparseMatrix[count_i][COL_NUMBER];			//row to col
			transposeArray[count_i][COL_NUMBER] = sparseMatrix[count_i][ROW_NUMBER];			//col to row
		}		
		return transposeArray;
	}
	
	/**Calculates the Symmetry of an array
	 * 
	 * @return true if matrix is symmetrical else false.
	 */
	public boolean isSymmetrical() {
		if(rows != columns) {
			return false;
		}
		
		int[][] sparseTranspose = transpose();
		int tempRow, tempCol;
		
		for(int count_i = 0; count_i < sparseMatrix.length; count_i++) {
			tempRow = sparseTranspose[count_i][ROW_NUMBER];
			tempCol = sparseTranspose[count_i][COL_NUMBER];
			if(sparseTranspose[count_i][VALUE] != getValue(tempRow, tempCol)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return matrix after converting from sparse matrix.
	 */
	public int[][] getMatrix() {
		int[][] matrix = new int[rows][columns];
		int row, column;
		for(int count_i = 0; count_i < sparseMatrix.length; count_i++) {
			row = sparseMatrix[count_i][ROW_NUMBER];
			column = sparseMatrix[count_i][COL_NUMBER];
			matrix[row][column] = sparseMatrix[count_i][VALUE];
		}
		return matrix;
	}
	
	/**
	 * @param row is row number
	 * @param col is column number
	 * @return value at given row and column
	 */
	private int getValue(int row, int col) {
		for(int count_i = 0; count_i < sparseMatrix.length; count_i++) {
			if(sparseMatrix[count_i][1] == row && sparseMatrix[count_i][2] == col) {
				return sparseMatrix[count_i][0];
			}
		}
		return 0;
	}
	
	/**
	 * @param sm1 is sparse matrix 1
	 * @param sm2 is sparse matrix 2
	 * @return matrix after adding two sparse matrices
	 */
	public static int[][] addMatrices(SparseMatrix sm_1, SparseMatrix sm_2) {
		if(sm_1.rows != sm_2.rows || sm_1.columns != sm_2.columns) {
			throw new AssertionError("Array Size Mismatch.");
		}
		
		int[][] sumArray = new int[sm_1.rows][sm_1.columns];
		
		for(int count_i = 0; count_i < sm_1.rows; count_i++) {
			for(int count_j = 0; count_j < sm_1.columns; count_j++) {
				sumArray[count_i][count_j] = sm_1.getValue(count_i, count_j) + sm_2.getValue(count_i, count_j);
			}
		}
		
		int[][] FinalSumArray = new SparseMatrix(sumArray).getMatrix();
		return FinalSumArray;
	}
	
	/**
	 * @param sm1 is sparse matrix 1
	 * @param sm2 is sparse matrix 2
	 * @return matrix after multiplying two sparse matrices
	 */
	public static int[][] multiplyMatrices(SparseMatrix sm_1, SparseMatrix sm_2) {
		
		if(sm_1.columns != sm_2.rows) {			
			throw new AssertionError("Cant be multiplied");
		}
		
		int[][] mulArray = new int[sm_1.rows][sm_2.columns];
		
		for(int count_i = 0; count_i < sm_1.rows; count_i++) {											//row of 1st = a
			for(int count_j = 0; count_j < sm_2.columns; count_j++) {									//col of 2nd = c
				for(int count_k = 0; count_k <= sm_1.columns; count_k++) {								
					//same value for both = b
					mulArray[count_i][count_j] += sm_1.getValue(count_i, count_k) * sm_2.getValue(count_k, count_j);
				}				
			}
		}
		
		int[][] FinalMulArray = new SparseMatrix(mulArray).getMatrix();
		return FinalMulArray;
	}
}