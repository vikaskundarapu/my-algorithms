package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

import jdk.nashorn.internal.ir.annotations.Ignore;

class PartitionListTest {

	@Test
	void partitionListNullCheck() {
		MySinglyLinkedList<Integer> list = null;
		PartitionList partitionList = new PartitionList();
		assertThrows(IllegalArgumentException.class, () -> partitionList.partitionList(list, 2));
		assertThrows(IllegalArgumentException.class, () -> partitionList.partition(list, 2));
	}
	
	@Test
	void partitionListSingleValue() {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
		list.appendToTail(11);
		PartitionList partitionList = new PartitionList();
		assertEquals(partitionList.partitionList(list, 5).data, 11);
		assertEquals(partitionList.partitionList(list, 11).data, 11);
		assertEquals(partitionList.partition(list, 5).data, 11);
		assertEquals(partitionList.partition(list, 11).data, 11);
	}
	
	
	@Test
	void partitionListMultipleValues() {
		MySinglyLinkedList<Integer> list = TestUtility.createList();
		PartitionList partitionList = new PartitionList();
		Node<Integer> result = partitionList.partitionList(list, 15);
		assertEquals(result.data, 11);
		assertEquals(result.next.data, 12);
		assertEquals(result.next.next.data, 12);
		assertEquals(result.next.next.next.data, 11);
		assertEquals(result.next.next.next.next.data, 15);
		assertEquals(result.next.next.next.next.next.data, 15);
		assertEquals(result.next.next.next.next.next.next.data, 18);
		assertEquals(result.next.next.next.next.next.next.next.data, 15);
		
		result = partitionList.partition(list, 15);
		System.out.println(result);
		assertEquals(result.data, 11);
		assertEquals(result.next.data, 12);
		assertEquals(result.next.next.data, 12);
		assertEquals(result.next.next.next.data, 11);
		assertEquals(result.next.next.next.next.data, 15);
		assertEquals(result.next.next.next.next.next.data, 15);
		assertEquals(result.next.next.next.next.next.next.data, 18);
		assertEquals(result.next.next.next.next.next.next.next.data, 15);
	}

}
