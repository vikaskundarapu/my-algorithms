package com.vikas.linkedlist;

import java.util.HashSet;
import java.util.Objects;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

/**
 * Remove Duplicates from an unsorted linked list
 */
public class RemoveDuplicates<E> {

	private RemoveDuplicates() {
	}

	/**
	 * Use a buffer to store the values. If we find a duplicate element, we remove
	 * that element. Singly linked list is used here.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public static <E> void removeDuplicates(MySinglyLinkedList<E> list) {

		if (Objects.isNull(list)) {
			throw new IllegalArgumentException("Please check the input");
		}

		HashSet<E> buffer = new HashSet<>();
		Node<E> head = list.getHead();
		Node<E> previous = null;

		while (Objects.nonNull(head)) {
			if (buffer.contains(head.data)) {
				previous.next = head.next;
			} else {
				buffer.add(head.data);
				previous = head;
			}
			head = head.next;
		}
	}

	public static <E> void removeDuplicatesNoBuffer(MySinglyLinkedList<E> list) {

		if (Objects.isNull(list)) {
			throw new IllegalArgumentException("Please check the input");
		}

		Node<E> head = list.getHead();
		Node<E> head2 = head.next;
		Node<E> previous = null;

		while (Objects.nonNull(head)) {
			E currentElementData = head.data;

			while (Objects.nonNull(head2)) {
				if (head2.data.equals(currentElementData)) {
					previous = previous.next;
				}
				previous = head2;
				head2 = head2.next;
			}
			head = head.next;
		}

	}

	/**
	 * Use a buffer to store the values. If we find a duplicate element, we remove
	 * that element. Singly linked list is used here.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public static <E> void removeDuplicates(LinkedListNode<E> list) {

		if (Objects.isNull(list)) {
			throw new IllegalArgumentException("Please check the input");
		}

		HashSet<E> buffer = new HashSet<>();
		LinkedListNode<E> previous = null;

		while (list != null) {
			if (buffer.contains(list.data)) {
				previous.next = list.next;
			} else {
				buffer.add(list.data);
				previous = list;
			}
			list = list.next;
		}

	}

}
