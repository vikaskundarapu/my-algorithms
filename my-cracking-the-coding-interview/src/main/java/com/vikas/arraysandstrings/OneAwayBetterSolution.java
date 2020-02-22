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
public class OneAwayBetterSolution {

	/**
	 * Idea: One Replace is when there is only character difference between two
	 * strings at the same index. One delete is when 2 strings differ by only one
	 * character and index of character is different. Insertion is opposite of
	 * deletion
	 */
	public static boolean oneEditAway(String first, String second) {

		if (Objects.isNull(first) || Objects.isNull(second) || first.isEmpty() || second.isEmpty()
				|| Math.abs(first.length() - second.length()) > 1 || first.equals(second)) {
			return Boolean.FALSE;
		}

		int firstLength = first.length();
		int secondLength = second.length();

		if (firstLength == secondLength) {
			return oneReplaceAway(first, second);
		} else if (firstLength + 1 == secondLength) {
			return oneInsertAway(first, second);
		} else if (firstLength - 1 == secondLength) {
			return oneDeleteAway(first, second);
		}

		return Boolean.FALSE;
	}

	/**
	 * Check if you add a character in first string to make second string i.e first
	 * should be the smallest string and second should the greatest string. "ale
	 * bale" "bae bale"
	 */
	private static boolean oneInsertAway(String first, String second) {
		int indexFirst = 0;
		int indexSecond = 0;

		while (indexFirst < first.length() && indexSecond < second.length()) {

			if (first.charAt(indexFirst) != second.charAt(indexSecond)) {
				/* Characters are different and indexes are also different */
				if (indexFirst != indexSecond) {
					return Boolean.FALSE;
				}
				indexSecond++;
			} else {
				indexFirst++;
				indexSecond++;
			}
		}

		return Boolean.TRUE;
	}

	private static boolean oneDeleteAway(String first, String second) {
		return oneInsertAway(second, first);
	}

	private static boolean oneReplaceAway(String first, String second) {
		boolean isCharacterDifferent = false;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				if (isCharacterDifferent) {
					return Boolean.FALSE;
				}
				isCharacterDifferent = true;
			}
		}
		return Boolean.TRUE;
	}

}
