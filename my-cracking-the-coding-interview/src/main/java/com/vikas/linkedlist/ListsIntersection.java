package com.vikas.linkedlist;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Find the intersection of 2 linked list.
 * 
 * Input: List 1: 1 -> 3 -> 5 -> 8 -> 4 -> 12 ; List 2: 1 -> 8 -> 4 -> 12
 * 
 * Output: 8
 * 
 * Note: The node address needs to be checked not data
 * 
 * Algorithm:
 * 
 * Step 1: Find the lengths of lists and check the tails. If tails are equal then there is an intersection, if not return null 
 * Step 2: Ignore the starting elements of the list with greater length.
 * Step 3: Loop and find the intersection by equality check on both the lists 
 */
public class ListsIntersection {

	private ListsIntersection() {
	}

	public static class ResultClass<E> {

		LinkedListNode<E> list;
		int length;

		public ResultClass(int length, LinkedListNode<E> list) {
			this.length = length;
			this.list = list;
		}
	}

	public static <E> Optional<LinkedListNode<E>> intersectionOfTwoLists(LinkedListNode<E> list1,
			LinkedListNode<E> list2) {

		ResultClass<E> result1 = getLengthAndTail(list1);
		ResultClass<E> result2 = getLengthAndTail(list2);

		if (result1.list != result2.list) {
			return Optional.ofNullable(null);
		}

		int length1 = result1.length;
		int length2 = result2.length;

		LinkedListNode<E> longerList = length1 > length2 ? list1 : list2;
		LinkedListNode<E> smallerList = length1 < length2 ? list1 : list2;

		for (int i = 0; i < Math.abs(length1 - length2); i++) {
			longerList = longerList.next;
		}

		while (longerList != smallerList) {
			longerList = longerList.next;
			smallerList = smallerList.next;
		}

		return Optional.ofNullable(smallerList);
	}

	public static <E> ResultClass<E> getLengthAndTail(LinkedListNode<E> node) {

		LinkedListNode<E> previous = null;
		int length = 0;

		while (Objects.nonNull(node)) {
			length++;
			previous = node;
			node = node.next;
		}

		return new ResultClass<>(length, previous);
	}

	public static <E> Optional<LinkedListNode<E>> getInsectionUsingLoops(LinkedListNode<E> list1,
			LinkedListNode<E> list2) {

		LinkedListNode<E> tempList = list2;

		while (Objects.nonNull(list1)) {
			while (Objects.nonNull(tempList)) {
				if (list1 == tempList)
					return Optional.ofNullable(list1);

				tempList = tempList.next;
			}
			tempList = list2;
			list1 = list1.next;
		}

		return Optional.ofNullable(null);
	}
	
	public static <E> Optional<LinkedListNode<E>> getInsectionUsingBuffer(LinkedListNode<E> list1,
			LinkedListNode<E> list2) {

		Set<LinkedListNode<E>> buffer = new LinkedHashSet<>();

		while (Objects.nonNull(list1)) {
			buffer.add(list1);
			list1 = list1.next;
		}

		while (Objects.nonNull(list2)) {
			if(buffer.contains(list2))
				return Optional.ofNullable(list2);
			list2 = list2.next;
		}
		
		return Optional.ofNullable(null);
	}
}
