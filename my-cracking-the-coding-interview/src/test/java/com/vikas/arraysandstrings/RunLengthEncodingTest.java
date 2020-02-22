package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RunLengthEncodingTest {

	@Test()
	void testRunLengthEncodingNullCheck() {
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.runLengthEncoding(null));
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.runLengthEncodingBetter(null));
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.compressString(null));
		
	}

	@Test()
	void testRunLengthEncodingEmptyCheck() {
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.runLengthEncoding(""));
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.runLengthEncodingBetter(""));
		assertThrows(UnsupportedOperationException.class, () -> RunLengthEncoding.compressString(""));
	}

	@Test
	void testRunLengthEncoding() {
		assertTrue(RunLengthEncoding.runLengthEncoding("aabbbbccccddeddfffghhhhhhaaa").equals("a2b4c4d2e1d2f3g1h6a3"));
		assertTrue(RunLengthEncoding.runLengthEncoding("aabbhhaaa").equals("a2b2h2a3"));
		assertTrue(RunLengthEncoding.runLengthEncoding("aabbhhaaaaaaab").equals("a2b2h2a7b1"));
		assertTrue(RunLengthEncoding.runLengthEncoding("aabbhhab").equals("aabbhhab"));
		
		assertTrue(RunLengthEncoding.runLengthEncodingBetter("aabbbbccccddeddfffghhhhhhaaa").equals("a2b4c4d2e1d2f3g1h6a3"));
		assertTrue(RunLengthEncoding.runLengthEncodingBetter("aabbhhaaa").equals("a2b2h2a3"));
		assertTrue(RunLengthEncoding.runLengthEncodingBetter("aabbhhaaaaaaab").equals("a2b2h2a7b1"));
		assertTrue(RunLengthEncoding.runLengthEncodingBetter("aabbhhab").equals("aabbhhab"));
		
		assertTrue(RunLengthEncoding.compressString("aabbbbccccddeddfffghhhhhhaaa").equals("a2b4c4d2e1d2f3g1h6a3"));
		assertTrue(RunLengthEncoding.compressString("aabbhhaaa").equals("a2b2h2a3"));
		assertTrue(RunLengthEncoding.compressString("aabbhhaaaaaaab").equals("a2b2h2a7b1"));
		assertTrue(RunLengthEncoding.compressString("aabbhhab").equals("aabbhhab"));
	}

}
