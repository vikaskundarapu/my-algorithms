package com.vikas.sortingandsearching;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSearchElementInSortedDisplacedArray {

	@Test
	void testSearchSorted() {
		int[] input = { 5, 6, 8, 9, 11, 13, 14, 1, 2, 3, 4 };
		assertEquals(9, SearchElementInSortedDisplacedArray.searchSorted(input, 0, input.length - 1, 3));
	}

}
