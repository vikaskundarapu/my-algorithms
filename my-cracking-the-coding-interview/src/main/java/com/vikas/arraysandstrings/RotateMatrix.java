package com.vikas.arraysandstrings;

import java.util.Objects;

/**
 * Given an image of NXN matrix, where each pixel is 4 bytes(int), write a
 * method to rotate image by 90 degrees. Can you do this in place
 */
public class RotateMatrix {

	/*
	 * Last column become first row in temporary matrix. Second last column becomes
	 * second row and so on.
	 * 
	 * Space Complexity: O(n) Time Complexity: O(n^2).
	 * 
	 * This is not in-place rotation, it takes extra buffer.
	 */
	public static int[][] rotateMatrix(int[][] image, int n) {

		if (Objects.isNull(image) || n < 0 || image.length != n) {
			throw new UnsupportedOperationException("Please check the input");
		}

		int temp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[j][i] = image[n - 1 - i][j];
			}
		}
		image = temp;
		return image;
	}

	/**
	 * Rotate one element from each side at a time.
	 * 
	 * Algorithm: 1) Take back-up of top elements 2) Copy left elements to the top
	 * 3) Copy bottom elements to the left 4) Copy right elements to the bottom 5)
	 * Copy top elements from the backup to the right
	 * 
	 * We need to repeat the above algorithm for all the layers starting from the
	 * outer layer to the inner layer(or we can try other way around). This we do
	 * using first loop. Second, loop is needed to iterate through all the elements
	 * in each layers.
	 * 
	 * We will consider one element at a time. So, in one iteration one element will
	 * be swapped i.e 2 elements are already in place. For first layer with an array
	 * of length 4, j will take values 0,1,2(NOTE: 3 should not be considered
	 * because in each iteration all the four elements on each sides are already
	 * swapped)
	 * 
	 * Space Complexity: O(1) Time Complexity: O(n^2).
	 * 
	 * This is in-place rotation.
	 */
	public static void rotateMatrixInplace(int[][] image, int n) {

		if (Objects.isNull(image) || n < 0 || image.length != n) {
			throw new UnsupportedOperationException("Please check the input");
		}

		for (int layer = 0; layer < n / 2; ++layer) {
			for (int j = layer; j < n - layer - 1; j++) {
				/* Take backup of top element */
				int temp = image[layer][j];
				/* Replace the top element with left element */
				image[layer][j] = image[n - 1 - j][layer];
				/* Replace the left element with bottom element */
				image[n - 1 - j][layer] = image[n - 1 - layer][n - 1 - j];
				/* Replace the bottom element with right element */
				image[n - 1 - layer][n - 1 - j] = image[j][n - 1 - layer];
				/* Replace the right element with top element using backup value */
				image[j][n - 1 - layer] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int length = 4;
		int a[][] = ArrayStringUtitlity.createRandom2DArray(length);
		ArrayStringUtitlity.display(a);
		System.out.println();
		ArrayStringUtitlity.display(rotateMatrix(a, length));
		System.out.println();
		rotateMatrixInplace(a, length);
		ArrayStringUtitlity.display(a);
	}
}
