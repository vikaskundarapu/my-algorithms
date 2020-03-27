package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

class ReverseAListTest {

	public static LinkedListNode<Integer> defaultList;
	public static LinkedListNode<Integer> anotherList;

	@BeforeEach
	public void init() {
		defaultList = TestUtility.createLinkedList();
		System.out.println(defaultList);
	}
	
	@BeforeAll
	public static void initAgain() {
		anotherList = TestUtility.createAnotherLinkedList();
	}

	@Test
	void testReverseNullCheck() {
		LinkedListNode<Integer> list = null;
		assertThrows(IllegalArgumentException.class, ()-> ReverseAList.reverseUsingStack(list));
		assertThrows(IllegalArgumentException.class, ()-> ReverseAList.reverseUsingRecursion(list));
		assertThrows(IllegalArgumentException.class, ()-> ReverseAList.reverse(list));
	}

	@Test
	void testReverseUsingStack() {
		LinkedListNode<Integer> result = ReverseAList.reverseUsingStack(defaultList).get();
		assertEquals(19, result.data);
		assertEquals(12, result.next.data);
		assertEquals(15, result.next.next.data);
	}
	
	@Test
	void testReverse() {
		LinkedListNode<Integer> result = ReverseAList.reverse(defaultList).get();
		System.out.println("Result: "+result);
		assertEquals(19, result.data);
		assertEquals(12, result.next.data);
		assertEquals(15, result.next.next.data);
	}
	
	@Test
	@Ignore
	void testReverseRecursive() {
		
		LinkedListNode<Integer> result = ReverseAList.reverseUsingRecursion(defaultList).get();
		assertEquals(19, result.data);
		assertEquals(12, result.next.data);
		assertEquals(15, result.next.next.data);
		
		LinkedListNode<Integer> anotherResult = ReverseAList.reverseUsingRecursion(anotherList).get();
		assertEquals(1, anotherResult.data);
		assertEquals(2, anotherResult.next.data);
		assertEquals(3, anotherResult.next.next.data);
	}

}
