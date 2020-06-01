package com.vikas.linkedlist;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

/**
 * For two linked lists, each node containing a number. Calculate the sum of the
 * nodes:
 * 
 * Input: (7->1->6) + (5->9->2) Output: (2->1->9)
 * 
 */
public class SumList {

	private static final String INVALID_INPUT = "Please check the input";

	private SumList() {
	}

	public static MySinglyLinkedList<Integer> findSum(MySinglyLinkedList<Integer> inputListOne,
			MySinglyLinkedList<Integer> inputListTwo) {

		if (inputListOne == null && inputListTwo == null) {
			throw new IllegalArgumentException(INVALID_INPUT);
		} else if (inputListOne == null) {
			return inputListTwo;
		} else if (inputListTwo == null) {
			return inputListOne;
		}

		MySinglyLinkedList<Integer> finalResult = new MySinglyLinkedList<>();
		int carry = 0;
		Node<Integer> headInput1 = inputListOne.getHead();
		Node<Integer> headInput2 = inputListTwo.getHead();

		while ((headInput1 != null && headInput2 != null) || carry != 0) {
			int sum = sumOfTwoNodes(headInput1, headInput2, carry);
			carry = sum >= 10 ? 1 : 0;
			finalResult.appendToTail(carry == 1 ? sum - 10 : sum);
			if (headInput1 != null)
				headInput1 = headInput1.next;
			if (headInput2 != null)
				headInput2 = headInput2.next;
		}

		return finalResult;
	}

	private static int sumOfTwoNodes(Node<Integer> nodeOne, Node<Integer> nodeTwo, int carry) {
		return (nodeOne == null ? 0 : nodeOne.data) + (nodeTwo == null ? 0 : nodeTwo.data) + carry;
	}
	
	
	
}
