package com.vikas.arraysandstrings;

import java.util.Arrays;
import java.util.Objects;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */
public class CheckUniqueCharacter {

	private CheckUniqueCharacter() {
	}

	public static boolean isUniqueUsingArrayBuffer(String input) {

		if (Objects.isNull(input) || input.isEmpty() || input.length() > 256)
			return Boolean.FALSE;

		/* Assumption: Extended ASCII characters */
		int[] buffer = new int[256];

		/* Storing the characters inside a buffer */
		for (int i = 0; i < input.length(); i++) {
			buffer[input.charAt(i)]++;
			if (buffer[input.charAt(i)] > 1) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	public static boolean isUniqueUsingSorting(String input) {

		if (Objects.isNull(input) || input.isEmpty())
			return Boolean.FALSE;

		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);

		for (int i = 0; i < input.length() - 1; i++) {
			if (inputArray[i] == inputArray[i + 1]) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

	/*
	 * Assumption: No special characters or numbers are allowed and case insensitive
	 * i.e. A == a. Here, a and A = 1, b and B = 2 and so on To reduce space we have
	 * used int bitVector each bit of which will indicate if the character was found
	 * before.
	 */
	public static boolean isUniqueUsingBitVector(String input) {

		if (Objects.isNull(input) || input.isEmpty())
			return Boolean.FALSE;

		input = input.toLowerCase();

		int bitVector = 0;
		for (int i = 0; i < input.length(); i++) {
			if ((bitVector & 1 << (input.charAt(i) - 'a')) > 0) {
				return Boolean.FALSE;
			}
			bitVector += 1 << (input.charAt(i) - 'a');
		}

		return Boolean.TRUE;
	}
}
