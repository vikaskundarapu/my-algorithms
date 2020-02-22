package com.vikas.arraysandstrings;

import java.util.Objects;

/**
 * Compress String like aaabbvvaaab to a3b2v2a3b. If the compressed string is
 * longer than the input then return the original string else return the
 * compressed string.
 * 
 * Assumption: Only alphabets are present in the input string
 * 
 * Input : aabbbbccccddeddfffghhhhhhaaa Output : a2b4c4d2e1d2f3g1h6a3
 * 
 * Input : aabbhhab Output : aabbhhab
 */
public class RunLengthEncoding {

	private RunLengthEncoding() {
	}

	public static String runLengthEncoding(String input) {

		if (Objects.isNull(input) || input.isEmpty()) {
			throw new UnsupportedOperationException("Please check the input");
		}

		int count = 1;
		StringBuilder output = new StringBuilder();
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == input.charAt(i)) {
				count++;
			} else {
				output.append(input.charAt(i - 1));
				output.append(count);
				count = 1;
			}
		}
		output.append(input.charAt(input.length() - 1) + "" + count);
		return output.length() > input.length() ? input : output.toString();
	}

	public static String runLengthEncodingBetter(String input) {

		if (Objects.isNull(input) || input.isEmpty()) {
			throw new UnsupportedOperationException("Please check the input");
		}

		int count = 0;
		StringBuilder output = new StringBuilder();
		int length = input.length();
		for (int i = 0; i < length; i++) {
			count++;
			/*
			 * Short circuit operation(|| operation) prevents from overflow. Notice that
			 * input.charAt(i + 1) does not overflow because if first check in the "if"
			 * statement evaluates to true, second check is not made
			 */
			if ((i + 1) == length || input.charAt(i) != input.charAt(i + 1)) {
				output.append(input.charAt(i));
				output.append(count);
				count = 0;
			}

			/*
			 * Return input string directly if we find that the length of compressed string
			 * exceeds the length of input string
			 */
			if (output.length() > length)
				return input;
		}
		return output.length() > length ? input : output.toString();
	}

	/**
	 * Here, we will first check if the length of compressed string is greater than
	 * the length of input. If greater, we directly return the input string without
	 * creating StringBuilder. Else we will have to check find the string.
	 * 
	 * Pros: Useful when the string contains a lot of non-repeating characters.
	 * StringBuilder is initialized with the proper length before hand.
	 * 
	 * Cons: We will have to iterate twice instead of once. Also, the code is pretty
	 * repetitive
	 */
	public static String compressString(String input) {

		if (Objects.isNull(input) || input.isEmpty()) {
			throw new UnsupportedOperationException("Please check the input");
		}

		
		int finalLength = findCompressedStringLength(input);
		int length = input.length();

		if (finalLength > length)
			return input;

		StringBuilder output = new StringBuilder(finalLength);
		int count = 0;
		for (int i = 0; i < length; i++) {
			count++;
			/*
			 * Short circuit operation(|| operation) prevents from overflow. Notice that
			 * input.charAt(i + 1) does not overflow because if first check in the "if"
			 * statement evaluates to true, second check is not made
			 */
			if ((i + 1) == length || input.charAt(i) != input.charAt(i + 1)) {
				output.append(input.charAt(i));
				output.append(count);
				count = 0;
			}
		}
		return output.toString();
	}

	private static int findCompressedStringLength(String input) {
		int length = input.length();
		int countConsecutive = 0;
		int countOfCompressedString = 0;

		for (int i = 0; i < length; i++) {
			countConsecutive++;
			/*
			 * Short circuit operation(|| operation) prevents from overflow. Notice that
			 * input.charAt(i + 1) does not overflow because if first check in the "if"
			 * statement evaluates to true, second check is not made
			 */
			if ((i + 1) == length || input.charAt(i) != input.charAt(i + 1)) {
				// Plus one for the character. valueOf usage ensures that the count is converted
				// to proper length. Say if length = 10, 2 characters should be considered
				countOfCompressedString += String.valueOf(countConsecutive).length() + 1;
				countConsecutive = 0;
				
			}
		}

		return countOfCompressedString;
	}

}
