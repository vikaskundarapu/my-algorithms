package com.vikas.arraysandstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOneAway {

	@Test
	void testIsOneAwayNullCheck() {
		assertFalse(OneAway.isOneAway(null, "ACVD"));
		assertFalse(OneAway.isOneAway("ASD", null));
	}
	
	@Test
	void testIsOneAwayEmptyCheck() {
		assertFalse(OneAway.isOneAway("", "ACVD"));
		assertFalse(OneAway.isOneAway("ASD", ""));
	}

	@Test
	void testIsOneAway() {
		assertTrue(OneAway.isOneAway("PALED", "PALED"));
		assertTrue(OneAway.isOneAway("PALED", "PALE"));
		assertTrue(OneAway.isOneAway("PALE", "PALED"));
		assertTrue(OneAway.isOneAway("PAE", "PALE"));
		assertTrue(OneAway.isOneAway("PALE", "PARE"));
		assertTrue(OneAway.isOneAway("PE", "PAE"));
	}
}
