package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOneAwayBetterSolution {

	@Test
	void testOneEditAwayNullCheck() {
		assertFalse(OneAwayBetterSolution.oneEditAway(null, "ACD"));
		assertFalse(OneAwayBetterSolution.oneEditAway("ACD", null));
	}

	@Test
	void testOneEditAwayEmptyCheck() {
		assertFalse(OneAwayBetterSolution.oneEditAway("", "ACD"));
		assertFalse(OneAwayBetterSolution.oneEditAway("ACD", ""));
	}

	@Test
	void testOneEditAway() {
		assertFalse(OneAwayBetterSolution.oneEditAway("ASXC", "ACD"));
		assertFalse(OneAwayBetterSolution.oneEditAway("ACD", "SAD"));
		assertFalse(OneAwayBetterSolution.oneEditAway("PALED", "PALED"));
		assertTrue(OneAwayBetterSolution.oneEditAway("PALED", "PALE"));
		assertTrue(OneAwayBetterSolution.oneEditAway("PALE", "PALED"));
		assertTrue(OneAwayBetterSolution.oneEditAway("PAE", "PALE"));
		assertTrue(OneAwayBetterSolution.oneEditAway("PALE", "PARE"));
		assertTrue(OneAwayBetterSolution.oneEditAway("PE", "PAE"));
	}

}
