package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPalindromePermutation {

	@Test
	void testIsPalindromePermutationNullCheck() {
		assertFalse(PalindromePermutation.isPalindromePermutationUsingCharacterCount(null));
	}

	@Test
	void testIsPalindromePermutationEmptyCheck() {
		assertFalse(PalindromePermutation.isPalindromePermutationUsingCharacterCount(""));
	}

	@Test
	void testIsPalindromePermutationEvenData() {
		assertTrue(PalindromePermutation.isPalindromePermutationUsingCharacterCount("AABBCC"));
	}
	
	@Test
	void testIsPalindromePermutationOddData() {
		assertTrue(PalindromePermutation.isPalindromePermutationUsingCharacterCount("AABCBCC"));
	}
	
	
	@Test
	void testIsPalindromePermutationSolution2NullCheck() {
		assertFalse(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters(null));
	}

	@Test
	void testIsPalindromePermutationSolution2EmptyCheck() {
		assertFalse(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters(""));
	}

	@Test
	void testIsPalindromePermutationSolution2EvenData() {
		assertTrue(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters("AABBCC"));
	}
	
	@Test
	void testIsPalindromePermutationSolution2OddData() {
		assertTrue(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters("AABCBCC"));
	}
	@Test
	void testIsPalindromePermutationSolution2WithSpecialCharacters() {
		assertTrue(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters("AAB**,,;[CBCC"));
	}
	
	@Test
	void testIsPalindromePermutation() {
		assertTrue(PalindromePermutation.isPalindromePermutationUsingBitSet("AAB**,,;[CBCC"));
		
	}
	
	@Test
	void testIsPalindromePermutationNegativeTesting() {
		assertFalse(PalindromePermutation.isPalindromePermutationUsingCharacterCount("AABCDBCC"));
		assertFalse(PalindromePermutation.isPalindromePermutationExcludingSpecialCharacters("ABCFS"));
		assertFalse(PalindromePermutation.isPalindromePermutationUsingBitSet("AAB**,,;[CDEBCC"));
	}
	
	
}
