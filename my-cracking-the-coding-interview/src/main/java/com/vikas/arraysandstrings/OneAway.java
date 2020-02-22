package com.vikas.arraysandstrings;

import java.util.Objects;

/**
 * Problem Statement: There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero
 * edits) away. EXAMPLE pale, ple -> true; pales, pale -> true; pale, bale ->
 * true; pale, bae -> false
 * 
 */
public class OneAway {

	private OneAway() {
	}

	/**
	 * The following solution represents the brute force method which is very slow.
	 * Here, in one replace, we will check all the elements of the strings except
	 * for the one character we are currently iterating. Delete/Insert would mean
	 * that the strings differ only one character.
	 */
	public static boolean isOneAway(String input1, String input2) {

		if (Objects.isNull(input2) || Objects.isNull(input1) || input1.isEmpty() || input2.isEmpty()
				|| Math.abs(input1.length() - input2.length()) > 1) {
			return Boolean.FALSE;
		}

		int lengthOfString1 = input1.length();
		int lengthOfString2 = input2.length();

		String shortString = lengthOfString1 < lengthOfString2 ? input1 : input2;
		String longString = lengthOfString1 > lengthOfString2 ? input1 : input2;

		if (lengthOfString1 == lengthOfString2) {
			return checkOneReplaceAway(shortString, longString);
		} else if (lengthOfString1 < lengthOfString2) {
			return checkOneDeleteAway(shortString, longString);
		} else {
			return checkOneInsertAway(shortString, longString);
		}
	}

	private static boolean checkOneInsertAway(String shortString, String longString) {
		return checkOneDeleteAway(shortString, longString);
	}

	private static boolean checkOneDeleteAway(String shortString, String longString) {
		for (int i = 0; i < longString.length(); i++) {
			if (shortString.equals(longString.substring(0, i) + "" + longString.substring(i + 1, longString.length())))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private static boolean checkOneReplaceAway(String shortString, String longString) {

		for (int i = 0; i < longString.length() - 1; i++) {
			if ((shortString.substring(0, i) + "" + shortString.substring(i + 1, shortString.length()))
					.equals(longString.substring(0, i) + "" + longString.substring(i + 1, longString.length())))
				return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
