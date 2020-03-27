package com.vikas.linkedlist;

import java.util.Objects;
import java.util.Optional;
import java.util.Stack;


/**
 * Reverse a singly linked list.
 * 
 * Approaches: Stack, recursion and iteration
 * */
public class ReverseAList {

	private ReverseAList() {
	}

	/**
	 * Reverse a linked list using using Stack.
	 * 
	 * Algorithm:
	 * 1) Put all but the last value into a stack.
	 * 2) Point the last element to the header. 
	 * 3) Pop these values into the next elements of the header
	 * 4) Make the first element of original list(or last element in the reversed list as null).
	 * This is needed else there will be loop
	 * 
	 * */
	public static <E> Optional<LinkedListNode<E>> reverseUsingStack(LinkedListNode<E> list) {

		Utility.checkInvalidInput(list);

		Stack<LinkedListNode<E>> stack = new Stack<>();
		LinkedListNode<E> pointer = list;

		while (Objects.nonNull(pointer.next)) {
			stack.push(pointer);
			pointer = pointer.next;
		}

		list = pointer;// Last element will be our first node. Now list has the head element.

		while (!stack.isEmpty()) {
			pointer.next = stack.pop();
			pointer = pointer.next;
		}
		
		pointer.next = null;// Erase the next of last element else there will be a loop.
		return Optional.ofNullable(list);
	}
	
	
	/**
	 * Find the reverse of a linked list using recursion.
	 */
	public static <E> Optional<LinkedListNode<E>> reverseUsingRecursion(LinkedListNode<E> list) {
		Utility.checkInvalidInput(list);
		LinkedListNode<E> result = recursiveReverse(list);
		
		return Objects.nonNull(result) ? Optional.ofNullable(result) : Optional.ofNullable(null);
	}

	private static <E> LinkedListNode<E> recursiveReverse(LinkedListNode<E> list) {
		if (list.next == null)
			return list;

		LinkedListNode<E> result = recursiveReverse(list.next);
		list.next.next = list;
		list.next = null;

		return result;
	}
	
	
	/**
	 * Find the reverse using iteration. We have used three pointers.
	 * 
	 * Convert the forward links to backward links. 
	 * For example: 1 -> 2 -> 3 should be 1 <-2 <- 3 and return 3
	 * 
	 * */
	public static <E> Optional<LinkedListNode<E>> reverse(LinkedListNode<E> list) {
		Utility.checkInvalidInput(list);
		
		LinkedListNode<E> head = list;
		LinkedListNode<E> previous = null;
		LinkedListNode<E> temp = null;
		
		while(head != null) {
			temp = head.next;
			head.next = previous;
			previous = head;
			head = temp;
		}
		
		return previous!= null? Optional.ofNullable(previous): Optional.ofNullable(null);
	}
	
	
}
