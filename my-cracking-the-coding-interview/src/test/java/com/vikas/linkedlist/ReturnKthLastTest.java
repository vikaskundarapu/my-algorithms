package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReturnKthLastTest {

	@Test
	void getKthLatElementUsingLengthNullCheck() {
		MySinglyLinkedList<Integer> list = null;
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLatElementUsingLength(list, 2));
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLatElementUsingLength(list, 2));
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLast2Pointers(list, 2));

		LinkedListNode<Integer> linkedListNode = null;
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLatElementUsingLength(linkedListNode, 2));
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLatElementRecursion(linkedListNode, 2));
		assertThrows(IllegalArgumentException.class, () -> ReturnKthLast.getKthLast2Pointers(linkedListNode, 2));
	}

	@Test
	void getKthLatElementUsingLength() {
		MySinglyLinkedList<Integer> list = TestUtility.createList();
		assertEquals(12, ReturnKthLast.getKthLatElementUsingLength(list, 2).data);

		LinkedListNode<Integer> linkedListNode = TestUtility.createLinkedList();
		assertEquals(12, ReturnKthLast.getKthLatElementUsingLength(linkedListNode, 2).data);
	}

	@Test
	void getKthLatElementUsingRecursion() {
		MySinglyLinkedList<Integer> list = TestUtility.createList();
		assertEquals(12, ReturnKthLast.getKthLatElementRecursion(list, 2).data);

		LinkedListNode<Integer> linkedListNode = TestUtility.createLinkedList();
		assertEquals(12, ReturnKthLast.getKthLatElementRecursion(linkedListNode, 2).data);
	}

}
