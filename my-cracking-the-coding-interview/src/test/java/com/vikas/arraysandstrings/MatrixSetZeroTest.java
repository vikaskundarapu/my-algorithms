package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixSetZeroTest {
	@Test
	void testSetZeroNullArray() {
		int input[][] = null;
		assertThrows(UnsupportedOperationException.class, () -> MatrixSetZero.setZero(input));
	}

	@Test
	void testSetZero() {
		int input[][] = { { 4, 3, 0, 6 }, { 7, 4, 2, 1 }, { 5, 2, 0, 3 } };
		MatrixSetZero.setZero(input);

		assertEquals(input[0][0], 0);
		assertEquals(input[0][1], 0);
		assertEquals(input[0][2], 0);
		assertEquals(input[0][3], 0);
		assertEquals(input[1][0], 7);
		assertEquals(input[1][1], 4);
		assertEquals(input[1][2], 0);
		assertEquals(input[1][3], 1);
		assertEquals(input[2][0], 0);
		assertEquals(input[2][1], 0);
		assertEquals(input[2][2], 0);
		assertEquals(input[2][3], 0);

	}
	
	@Test
	void testSetZeroesNullArray() {
		int input[][] = null;
		assertThrows(UnsupportedOperationException.class, () -> MatrixSetZero.setZeroes(input));
	}

	@Test
	void testSetZeroes() {
		int input[][] = { { 4, 3, 0, 6 }, { 7, 4, 2, 1 }, { 5, 2, 0, 3 } };
		MatrixSetZero.setZeroes(input);

		assertEquals(input[0][0], 0);
		assertEquals(input[0][1], 0);
		assertEquals(input[0][2], 0);
		assertEquals(input[0][3], 0);
		assertEquals(input[1][0], 7);
		assertEquals(input[1][1], 4);
		assertEquals(input[1][2], 0);
		assertEquals(input[1][3], 1);
		assertEquals(input[2][0], 0);
		assertEquals(input[2][1], 0);
		assertEquals(input[2][2], 0);
		assertEquals(input[2][3], 0);

	}

}
