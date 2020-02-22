package com.vikas.arraysandstrings;

public class URLify {

	public static void urlify(char[] input, int trueLength) {

		int countOfSpaces = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i]== ' ') {
				countOfSpaces++;
			}
		}

		int actualLengthOfResult = trueLength + countOfSpaces * 2;// Since %20 is 3 chars and space takes one char
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i]== ' ') {
				input[actualLengthOfResult - 1] = '0';
				input[actualLengthOfResult - 2] = '2';
				input[actualLengthOfResult - 3] = '%';
				actualLengthOfResult = actualLengthOfResult - 3;
			}else {
				input[actualLengthOfResult - 1] = input[i];
				actualLengthOfResult = actualLengthOfResult - 1;
			}
		}
		System.out.println(new String(input));
	}

	public static void main(String[] args) {
		String input= "AB AC CD";
		char[] a = new char[100];
		
		for(int i = 0 ; i < input.length();i++) {
			a[i] = input.charAt(i);
		}
		
		urlify(a,8);
	}

}
