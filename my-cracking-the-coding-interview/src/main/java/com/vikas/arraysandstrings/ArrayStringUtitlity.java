package com.vikas.arraysandstrings;

import java.util.Arrays;
import java.util.Random;

public class ArrayStringUtitlity {

	private static final Random random = new Random();

	private ArrayStringUtitlity() {
	}

	public static int[][] createRandom2DArray(int length) {

		int[][] a = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				a[i][j] = random.nextInt(10);
			}
		}
		return a;
	}

	public static int[][] createRandom2DArray(int rowLength, int columnLength) {

		int[][] a = new int[rowLength][columnLength];

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				a[i][j] = random.nextInt(10);
			}
		}
		return a;
	}

	public static void display(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] copy2DArray(int input[][]) {
		return Arrays.stream(input).map(int[]::clone).toArray(int[][]::new);
	}
	
}
