package com.vikas.linkedlist;

import java.util.Objects;

public class Utility {
	
	private Utility() {}
	
	private static final String INVALID_INPUT = "Please check the input";

	@SuppressWarnings("rawtypes")
	public static void checkInvalidInput(CustomLinkedList list) {
		if (Objects.isNull(list)) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}
	
}
