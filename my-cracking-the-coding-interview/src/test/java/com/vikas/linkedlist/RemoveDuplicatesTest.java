package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

	@Test
	void testRemoveDuplicatesNullCheck() {
		MySinglyLinkedList<Integer> list = null;
		LinkedListNode<Integer> linkedListNode = null;
		assertThrows(IllegalArgumentException.class, () -> RemoveDuplicates.removeDuplicates(list));
		assertThrows(IllegalArgumentException.class, () -> RemoveDuplicates.removeDuplicates(linkedListNode));
	}

	@Test
	void testRemoveDuplicates() {
		MySinglyLinkedList<Integer> list = TestUtility.createList();
		RemoveDuplicates.removeDuplicates(list);
		assertEquals(11, list.getHead().data);
		assertEquals(12, list.getHead().next.data);
		assertEquals(15, list.getHead().next.next.data);
		assertEquals(18, list.getHead().next.next.next.data);

		LinkedListNode<Integer> linkedListNode = TestUtility.createLinkedList();
		RemoveDuplicates.removeDuplicates(linkedListNode);
		assertEquals(11, linkedListNode.data);
		assertEquals(12, linkedListNode.next.data);
		assertEquals(15, linkedListNode.next.next.data);
		assertEquals(18, linkedListNode.next.next.next.data);
	}

}
