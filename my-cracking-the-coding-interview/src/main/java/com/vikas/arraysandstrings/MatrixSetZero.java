package com.vikas.arraysandstrings;

import java.util.Objects;

/**
 * Write an algorithm such that if an element in MXN matrix is zero, its entire
 * row and column are set to zero.
 */
public class MatrixSetZero {

	/**
	 * Algorithm:
	 * 1) Find the rows with zero element and place in row buffer 
	 * 2) Find the columns with zero element and place in column buffer 
	 * 3) Nullify row elements using buffer 4) Nullify column elements using buffer
	 * 
	 * Space Complexity: O(MN)
	 */
	public static void setZero(int[][] input) {

		if (Objects.isNull(input) || input.length == 0) {
			throw new UnsupportedOperationException("Please check the input");
		}

		int rowLength = input.length;
		int columnLength = input[0].length;
		/* Buffers to store row and column indexes of element with value 0 */
		boolean[] row = new boolean[rowLength];
		boolean[] column = new boolean[columnLength];

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < column.length; j++) {
				if (input[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		nullifyRows(input, row);
		nullifyColumns(input, column);

	}

	private static void nullifyColumns(int[][] input, boolean[] column) {
		for (int i = 0; i < column.length; i++) {
			if (column[i]) {
				for (int j = 0; j < input.length; j++) {
					input[j][i] = 0;
				}
			}
		}
	}

	private static void nullifyRows(int[][] input, boolean[] row) {
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				for (int j = 0; j < input[0].length; j++) {
					input[i][j] = 0;
				}
			}
		}
	}

	/**
	 * In the previous approach, we used Space of O(MN). We can reduce this space to
	 * O(1). In this technique, we will use 1st row and 1st column as buffers.
	 * 
	 * Algorithm: 
	 * 1) Find if the 1st row has zero element and place in a buffer(rowHasZero) 
	 * 2) Find if the 1st column has zero element and place in buffer(columnHasZero) 
	 * 3) Iterate through the entire matrix and find zero element. If we find any zero element,
	 * replace the corresponding 1st row and 1st column element with zero 
	 * 4) We can now use first row and first column in place of row and column buffers used in
	 * previous approach 
	 * 5) Iterate through the first row and first column. Nullify corresponding row and column.
	 * 6) If columnHasZero and rowHasZero are true, nullify corresponding row and column. 
	 * 
	 * Space Complexity: O(1)
	 */

	public static void setZeroes(int[][] input) {

		if (Objects.isNull(input) || input.length == 0) {
			throw new UnsupportedOperationException("Please check the input");
		}

		int rowLength = input.length;
		int columnLength = input[0].length;

		boolean rowHasZero = false;
		boolean columnHasZero = false;

		/*If First row has any zero value, set rowHasZero*/
		for (int i = 0; i < columnLength; i++) {
			if (input[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}

		/*If First column has any zero value, set columnHasZero*/
		for (int i = 0; i < rowLength; i++) {
			if (input[i][0] == 0) {
				columnHasZero = true;
				break;
			}
		}

		/*
		 * If any value in the rest of the array is zero then make the element on first
		 * row and column equals to zero
		 */
		for (int i = 1; i < rowLength; i++) {
			for (int j = 1; j < columnLength; j++) {
				if (input[i][j] == 0) {
					input[0][j] = 0;
					input[i][0] = 0;
				}
			}
		}

		/*Use the first row as a row buffer and nullify elements*/
		for (int i = 0; i < columnLength; i++) {
			if (input[0][i] == 0) {
				nullifyColumn(input, i);
			}
		}

		/*Use the first column as a column buffer and nullify elements*/
		for (int i = 0; i < rowLength; i++) {
			if (input[i][0] == 0) {
				nullifyRow(input, i);
			}
		}
		
		
		/* If none of the rows have zeros but first row or column had one then nullify elements accordingly*/
		if (rowHasZero) {
			nullifyRow(input, 0);
		}

		if (columnHasZero) {
			nullifyColumn(input, 0);
		}

	}

	private static void nullifyRow(int[][] input, int row) {
		for (int j = 0; j < input[0].length; j++) {
			input[row][j] = 0;
		}
	}

	private static void nullifyColumn(int[][] input, int column) {
		for (int j = 0; j < input.length; j++) {
			input[j][column] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] input = ArrayStringUtitlity.createRandom2DArray(3, 4);
		int[][] input1 = ArrayStringUtitlity.copy2DArray(input);
		ArrayStringUtitlity.display(input);
		System.out.println();
		setZero(input);
		ArrayStringUtitlity.display(input);

		System.out.println();
		setZeroes(input1);
		ArrayStringUtitlity.display(input1);
	}

}
