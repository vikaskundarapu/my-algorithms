package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCheckPermutation {

	@Test
	void testCheckPermutationUsingSortNullCheck() {
		assertFalse(CheckPermutation.checkPermutationUsingSort(null, null));
	}

	@Test
	void testCheckPermutationUsingSortEmptyCheck() {
		assertFalse(CheckPermutation.checkPermutationUsingSort("", ""));
	}

	@Test
	void testCheckPermutationUsingSortDifferentLengths() {
		assertFalse(CheckPermutation.checkPermutationUsingSort("CSD", "ASDSADSA"));
	}

	@Test
	void testCheckPermutationUsingSort() {
		assertTrue(CheckPermutation.checkPermutationUsingSort("ABCDEFGG", "GGFEDCBA"));
	}

	@Test
	void testSortString() {
		String sortedString = CheckPermutation.sortString("CAB");
		assertEquals(sortedString, "ABC");
	}

	@Test
	void testCheckPermutationUsingCharCountNullCheck() {
		assertFalse(CheckPermutation.checkPermutationUsingCharCount(null, null));
	}

	@Test
	void testCheckPermutationUsingCharCountEmptyCheck() {
		assertFalse(CheckPermutation.checkPermutationUsingCharCount("", ""));
	}

	@Test
	void testCheckPermutationUsingCharCountDifferentLengths() {
		assertFalse(CheckPermutation.checkPermutationUsingCharCount("CSD", "ASDSADSA"));
	}

	@Test
	void testCheckPermutationUsingCharCount() {
		assertTrue(CheckPermutation.checkPermutationUsingCharCount("ABCDEFGG", "GGFEDCBA"));
	}

}
