package com.vikas.arraysandstrings;

import java.util.BitSet;
import java.util.Objects;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a
 * permutation of a Palindrome. A Palindrome is a word or phrase that is the
 * same forwards and backwards. A permutation is a rearrangement of letters. The
 * Palindrome does not need to be limited to just dictionary words. EXAMPLE
 * Input: Tact Coa Output: True (permutations: "taco cat'; "atco eta·; etc.)
 * 
 * 
 * We need to have an even number of almost all characters, so that half can be
 * on one side and half can be on the other side. At most one character (the
 * middle character) can have an odd count.
 */
public class PalindromePermutation {

	private PalindromePermutation() {
	}

	/*
	 * Solution1: This method includes special characters in the Palindrome
	 * permutation.
	 */
	public static boolean isPalindromePermutationUsingCharacterCount(String input) {
		if (Objects.isNull(input) || input.isEmpty())
			return Boolean.FALSE;

		/* Extended ASCII */
		int[] charCount = new int[256];
		int oddCharacterCount = 0;

		for (int i = 0; i < input.length(); i++) {
			charCount[input.charAt(i)]++;
		}

		for (int i = 0; i < charCount.length; i++) {
			if (input.length() % 2 == 0) {
				if (charCount[i] % 2 == 1)
					return Boolean.FALSE;
			} else {
				if (charCount[i] % 2 == 1)
					oddCharacterCount++;
				if (oddCharacterCount > 1)
					return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

	/*
	 * Solution 2: We use a similar technique of counting characters but we ensure
	 * that all special characters are ignored. If we have to ignore the special
	 * characters and consider only alphabetic character set, we use the following
	 * method.
	 */
	public static boolean isPalindromePermutationExcludingSpecialCharacters(String input) {

		if (Objects.isNull(input) || input.isEmpty())
			return Boolean.FALSE;

		int[] countOfCharacters = buildCharacterCountTable(input);
		boolean isOddFound = false;
		for (int i = 0; i < countOfCharacters.length; i++) {
			if (countOfCharacters[i] % 2 == 1) {
				if (isOddFound) {
					return Boolean.FALSE;
				}
				isOddFound = true;
			}
		}
		return Boolean.TRUE;
	}

	/** Build an array with count of all characters. */
	private static int[] buildCharacterCountTable(String input) {
		/* 26 alphabets to be fit in */
		int[] characterCountTable = new int[26];

		for (int i = 0; i < input.length(); i++) {
			int charValue = getCharValue(input.charAt(i));
			if (charValue != -1) {
				characterCountTable[charValue]++;
			}
		}

		return characterCountTable;
	}

	/**
	 * This method maps A and a to 1, B and b to 2 so on and so forth. We will mark
	 * special characters as -1.
	 */
	public static int getCharValue(Character character) {

		int charNumericValue = Character.getNumericValue(character);
		int numericValueOfA = Character.getNumericValue('A');
		int numericValueOfZ = Character.getNumericValue('Z');
		int numericValueOfSmallA = Character.getNumericValue('a');
		int numericValueOfSmallZ = Character.getNumericValue('z');

		if (charNumericValue >= numericValueOfA && charNumericValue <= numericValueOfZ) {
			return charNumericValue - numericValueOfA;
		} else if (charNumericValue >= numericValueOfSmallA && charNumericValue <= numericValueOfSmallZ) {
			return charNumericValue - numericValueOfSmallA;
		}

		return -1;// This indicates special characters which are not in range of a-z and A-Z
	}

	/**
	 * Solution 3 : We don't need to know the counts. We just need to know if the
	 * count is even or odd. Like a switch, we can ON/OFF the switch. If the Switch
	 * is OFF then the operations are definitely odd. We use BitSet class to
	 * demonstrate this technique
	 */
	public static boolean isPalindromePermutationUsingBitSet(String input) {

		BitSet bitSet = new BitSet(26);

		for (int i = 0; i < input.length(); i++) {
			int charValue = getCharValue(input.charAt(i));
			if (charValue != -1) {
				if (bitSet.get(charValue)) {
					bitSet.set(charValue, Boolean.FALSE);
				} else {
					bitSet.set(charValue, Boolean.TRUE);
				}
			}
		}
		return bitSet.cardinality() <= 1;
	}

}
