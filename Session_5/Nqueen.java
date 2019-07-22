public class Nqueen {

	int[][] chessBoard;

	/**
	 * Checks that the specified position is safe or not for placing Queen
	 * 
	 * @param board all elements of board are initially initialized to zero
	 * 
	 * @param row index of row where queen is placed
	 * @param column index of column where queen is placed
	 * @param dimensionOfChessBoard
	 * @return returns true if specified position is safe or false if specified position is not safe
	 */
	public boolean isSafe(int[][] board, int row, int column,
			int dimensionOfChessBoard) {
		chessBoard = board;
		// check if Queen is present in same column
		for (int count_row = 0; count_row < row; count_row++) {
			if (chessBoard[count_row][column] == 1) {
				return false;
			}
		}
		// check if Queen is present in upper left diagonal
		for (int count_row = row, count_col = column; count_row >= 0 && count_col >= 0; count_row--, count_col--) {
			if (chessBoard[count_row][count_col] == 1) {
				return false;
			}
		}
		// check if Queen is present in upper right diagonal
		for (int count_row = row, count_col = column; count_row >= 0 && count_col < dimensionOfChessBoard; count_row--, count_col++) {
			if (chessBoard[count_row][count_col] == 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The N Queen is the problem of placing N chess queens on an N×N chess
	 * board so that no two queens attack each other.
	 * 
	 * @param board
	 *            board all elements of board are initially initialized to zero
	 * @param startRow
	 * @param dimensionOfChessBoard
	 * @return
	 */

	public boolean nQueen(int[][] board, int startRow, int dimensionOfChessBoard) {
		chessBoard = board;
		if (startRow >= dimensionOfChessBoard) {
			// print final queen location
			for (int count_row = 0; count_row < dimensionOfChessBoard; count_row++) {
				for (int count_col = 0; count_col < dimensionOfChessBoard; count_col++) {
					System.out.print(chessBoard[count_row][count_col] + " ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			return true;

		}
		for (int count_row = 0; count_row < dimensionOfChessBoard; count_row++) {
			if (isSafe(chessBoard, startRow, count_row, dimensionOfChessBoard)) {
				chessBoard[startRow][count_row] = 1;
				if (nQueen(chessBoard, startRow + 1, dimensionOfChessBoard)) {
					return true;
				}
				chessBoard[startRow][count_row] = 0;
			}
		}
		return false;
	}
}
