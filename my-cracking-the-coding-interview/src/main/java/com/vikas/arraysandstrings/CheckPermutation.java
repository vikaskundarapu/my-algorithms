package com.vikas.arraysandstrings;

import java.util.Arrays;
import java.util.Objects;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.
 */
public class CheckPermutation {

	private CheckPermutation() {
	}

	/* We sort the strings and check for equals */
	public static boolean checkPermutationUsingSort(String input1, String input2) {

		if (Objects.isNull(input1) || Objects.isNull(input2) || input1.isEmpty() || input2.isEmpty()
				|| input1.length() != input2.length())
			return Boolean.FALSE;

		return sortString(input1).equals(sortString(input2));
	}

	public static String sortString(String input) {
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);
		return new String(inputArray);
	}

	/*
	 * Assumption: Strings contain only Extended ASCII set. We will check if the
	 * character count in both the strings are same
	 */
	public static boolean checkPermutationUsingCharCount(String input1, String input2) {

		if (Objects.isNull(input1) || Objects.isNull(input2) || input1.isEmpty() || input2.isEmpty()
				|| input1.length() != input2.length())
			return Boolean.FALSE;

		int length = input1.length();
		int[] charCount = new int[256];

		for (int i = 0; i < length; i++) {
			charCount[input1.charAt(i)]++;
		}

		// Check if the character count is same in input2. If we find extra character
		// then return false
		for (int i = 0; i < length; i++) {
			--charCount[input2.charAt(i)];
			if (charCount[input2.charAt(i)] < 0) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

}
