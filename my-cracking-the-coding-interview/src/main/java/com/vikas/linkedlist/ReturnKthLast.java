package com.vikas.linkedlist;

import java.util.Objects;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

/** Return kth last element from a linked list */
public class ReturnKthLast<E> {

	private ReturnKthLast() {
	}

	public static class Index {
		int index;
	}

	public static <E> MySinglyLinkedList.Node<E> getKthLatElementUsingLength(MySinglyLinkedList<E> list, int k) {

		Utility.checkInvalidInput(list);

		int length = 0;
		Node<E> node = list.getHead();

		/* Find the length */
		while (Objects.nonNull(node)) {
			length++;
			node = node.next;
		}

		node = list.getHead();
		for (int i = 0; i < length - k; i++) {
			node = node.next;
		}

		return node;
	}

	public static <E> Node<E> getKthLatElementRecursion(MySinglyLinkedList<E> list, int k) {
		Utility.checkInvalidInput(list);
		Index index = new Index();
		return getKthLastElementRecursive(list.getHead(), k, index);
	}

	private static <E> Node<E> getKthLastElementRecursive(Node<E> head, int k, Index idx) {

		if (Objects.isNull(head))
			return null;

		Node<E> resultNode = getKthLastElementRecursive(head.next, k, idx);
		idx.index = 1 + idx.index;

		if (idx.index == k) {
			return head;
		}

		return resultNode;
	}

	public static <E> Node<E> getKthLast2Pointers(MySinglyLinkedList<E> list, int k) {
		Utility.checkInvalidInput(list);

		Node<E> pointer1 = list.getHead();
		Node<E> pointer2 = list.getHead();

		for (int i = 0; i < k; i++) {
			pointer1 = pointer1.next;
		}

		while (Objects.nonNull(pointer1)) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer2;
	}

	public static <E> LinkedListNode<E> getKthLatElementUsingLength(LinkedListNode<E> list, int k) {

		Utility.checkInvalidInput(list);

		LinkedListNode<E> node = list;
		int length = 0;

		while (Objects.nonNull(node)) {
			length++;
			node = node.next;
		}

		node = list;
		for (int i = 0; i < length - k; i++) {
			node = node.next;
		}

		return node;
	}

	public static <E> LinkedListNode<E> getKthLatElementRecursion(LinkedListNode<E> list, int k) {
		Utility.checkInvalidInput(list);
		Index index = new Index();
		return getKthLastElementRecursive(list, k, index);
	}

	private static <E> LinkedListNode<E> getKthLastElementRecursive(LinkedListNode<E> head, int k, Index idx) {

		if (Objects.isNull(head))
			return null;

		LinkedListNode<E> resultNode = getKthLastElementRecursive(head.next, k, idx);
		idx.index = idx.index + 1;

		if (idx.index == k) {
			return head;
		}

		return resultNode;
	}

	public static <E> LinkedListNode<E> getKthLast2Pointers(LinkedListNode<E> list, int k) {

		Utility.checkInvalidInput(list);

		LinkedListNode<E> pointer1 = list;
		LinkedListNode<E> pointer2 = list;

		for (int i = 0; i < k; i++) {
			pointer1 = pointer1.next;
		}

		while (Objects.nonNull(pointer1)) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer2;
	}
}
