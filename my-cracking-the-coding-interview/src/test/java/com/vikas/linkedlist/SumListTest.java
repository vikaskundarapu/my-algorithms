package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

class SumListTest {
	public static MySinglyLinkedList<Integer> inputListOne;
	public static MySinglyLinkedList<Integer> inputListTwo;

	@BeforeEach
	public void init() {
		inputListOne = createLinkedList();
		inputListTwo = createAnotherLinkedList();
	}

	private MySinglyLinkedList<Integer> createLinkedList() {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.appendToTail(6);
		list.appendToTail(1);
		list.appendToTail(7);
		
		return list;
	}
	
	private MySinglyLinkedList<Integer> createAnotherLinkedList() {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.appendToTail(2);
		list.appendToTail(9);
		list.appendToTail(5);
		
		return list;
	}

	@Test
	void testNullCheck() {
		assertThrows(IllegalArgumentException.class, () -> SumList.findSum(null, null));
	}

	@Test
	void testOneInputNullCheck() {
		MySinglyLinkedList<Integer> resultList = SumList.findSum(null, inputListTwo);
		Node<Integer> result = resultList.getHead();
		System.out.println("Result: " + result);
		assertEquals(2, result.data);
		assertEquals(9, result.next.data);
		assertEquals(5, result.next.next.data);

		MySinglyLinkedList<Integer> resultList2 = SumList.findSum(inputListOne, null);
		Node<Integer> result2 = resultList2.getHead();
		System.out.println("Result: " + result2);
		assertEquals(6, result2.data);
		assertEquals(1, result2.next.data);
		assertEquals(7, result2.next.next.data);

	}
	
	@Test
	void testSumList() {
		MySinglyLinkedList<Integer> resultList2 = SumList.findSum(inputListOne, inputListTwo);
		Node<Integer> result2 = resultList2.getHead();
		System.out.println("Result: " + result2);
		assertEquals(8, result2.data);
		assertEquals(0, result2.next.data);
		assertEquals(3, result2.next.next.data);
		assertEquals(1, result2.next.next.next.data);
	}
}
