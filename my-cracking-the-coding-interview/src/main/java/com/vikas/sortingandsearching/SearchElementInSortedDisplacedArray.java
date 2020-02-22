package com.vikas.sortingandsearching;

/*
 * Given an array of n elements which are sorted but displaced by an unknown pivot number.
 * Input: Array:{ 5, 6, 8, 9, 11, 13, 14, 1, 2, 3, 4 }; target = 3
 * Output: 9
 * 
 * Algorithm: At a time, one half of the array either left or right is ordered. We need to check that half. 
 * For example: For array {10,15,20,0,5}, if target = 5. We see that 10 < 20 so left array must be ordered properly.
 * And since 5 is not present in that range we have to check in the right part. If we the target was in between 10 and 20, 
 * we could have checked elements in the left side.
 * 
 * Also, for array {50,5,20,30,40}, we see that 50 < 20 i.e start element is less than middle element, so the right side
 * must be ordered. Since, target 5 doesn't fall between 20(middle) and 40(end), we check left part.
 * 
 * Tricky condition is when we have something like {2,2,2,3,4,2} i.e when middle is equal to left. So left part contains
 * only one element. We then check if start and end is different, if different then check the right side. Else we need to
 * check both the parts.
 * 
 * */
public class SearchElementInSortedDisplacedArray {

	public static int searchSorted(int[] a, int start, int end, int target) {

		/* end should be lesser than start. This is the base condition to exit */
		if (end < start) {
			return -1;
		}

		int middle = (end - start) / 2 + start;

		if (a[middle] == target)
			return middle;

		if (a[start] < a[middle]) {
			// Left part is ordered properly
			if (target >= a[start] && target < a[middle])
				return searchSorted(a, start, middle - 1, target);
			else {
				return searchSorted(a, middle + 1, end, target);
			}

		} else if (a[middle] < a[start]) {
			// Right part is sorted
			if (target > a[middle] && target <= a[end]) {
				return searchSorted(a, middle + 1, end, target);
			} else {
				return searchSorted(a, start, middle - 1, target);
			}

		} else if (a[start] == a[middle]) {// All left elements are same
			if (a[start] != a[end]) {
				return searchSorted(a, middle + 1, end, target);
			} else {
				int result = searchSorted(a, start, middle - 1, target);
				if (result == -1)
					return searchSorted(a, middle + 1, end, target);
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int[] input = { 5, 6, 8, 9, 11, 13, 14, 1, 2, 3, 4 };
		System.out.println(searchSorted(input, 0, input.length - 1, 3));
	}
}
