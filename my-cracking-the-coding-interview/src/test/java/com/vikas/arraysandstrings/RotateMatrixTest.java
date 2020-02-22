package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RotateMatrixTest {

	@Test
	void testRotateMatrixNullArray() {
		int a[][] = null;
		assertThrows(UnsupportedOperationException.class, () -> RotateMatrix.rotateMatrix(a, 5));
	}

	@Test
	void testRotateMatrixIncorrectLength() {
		int a[][] = ArrayStringUtitlity.createRandom2DArray(5);
		assertThrows(UnsupportedOperationException.class, () -> RotateMatrix.rotateMatrix(a, 4));
		assertThrows(UnsupportedOperationException.class, () -> RotateMatrix.rotateMatrix(a, -4));
	}

	@Test
	void testRotateMatrix() {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] rotatedMatrix = RotateMatrix.rotateMatrix(a, 3);

		assertEquals(rotatedMatrix[0][0], 7);
		assertEquals(rotatedMatrix[0][1], 4);
		assertEquals(rotatedMatrix[0][2], 1);
		assertEquals(rotatedMatrix[1][0], 8);
		assertEquals(rotatedMatrix[1][1], 5);
		assertEquals(rotatedMatrix[1][2], 2);
		assertEquals(rotatedMatrix[2][0], 9);
		assertEquals(rotatedMatrix[2][1], 6);
		assertEquals(rotatedMatrix[2][2], 3);
	}

	@Test
	void testRotateMatrixInPlace() {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RotateMatrix.rotateMatrixInplace(a, 3);

		assertEquals(a[0][0], 7);
		assertEquals(a[0][1], 4);
		assertEquals(a[0][2], 1);
		assertEquals(a[1][0], 8);
		assertEquals(a[1][1], 5);
		assertEquals(a[1][2], 2);
		assertEquals(a[2][0], 9);
		assertEquals(a[2][1], 6);
		assertEquals(a[2][2], 3);
	}
}
