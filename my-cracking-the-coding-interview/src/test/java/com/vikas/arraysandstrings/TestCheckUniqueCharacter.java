package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestCheckUniqueCharacter {

	@Test
	void testIsUniqueUsingArrayBufferNullCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingArrayBuffer(null));
	}

	@Test
	void testIsUniqueUsingArrayBufferEmptyCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingArrayBuffer(""));
	}

	@Test
	void testIsUniqueUsingArrayBufferUsingDuplicateChars() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingArrayBuffer("AXAS"));
	}

	@Test
	void testIsUniqueUsingArrayBuffer() {
		assertTrue(CheckUniqueCharacter.isUniqueUsingArrayBuffer("ACDFGR"));
	}

	@Test
	void testIsUniqueUsingSortingNullCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingSorting(null));
	}

	@Test
	void testIsUniqueUsingSortingEmptyCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingSorting(""));
	}

	@Test
	void testIsUniqueUsingSortingUsingDuplicateChars() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingSorting("AXAS"));
	}

	@Test
	void testIsUniqueUsingSorting() {
		assertTrue(CheckUniqueCharacter.isUniqueUsingSorting("ACDFGR"));
	}

	@Test
	void testIsUniqueUsingBitVectorNullCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingBitVector(null));
	}

	@Test
	void testIsUniqueUsingBitVectorEmptyCheck() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingBitVector(""));
	}

	@Test
	void testIsUniqueUsingBitVectorUsingDuplicateChars() {
		assertFalse(CheckUniqueCharacter.isUniqueUsingBitVector("AXAS"));
	}

	@Test
	void testIsUniqueUsingBitVectorWithUpperCaseString() {
		assertTrue(CheckUniqueCharacter.isUniqueUsingBitVector("ACDFGR"));
	}
	
	@Test
	void testIsUniqueUsingBitVector() {
		assertTrue(CheckUniqueCharacter.isUniqueUsingBitVector("acxdse"));
	}

}
