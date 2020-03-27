package com.vikas.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class ListsIntersectionTest {

	public static List<LinkedListNode<Integer>> createLists() {
		ArrayList<LinkedListNode<Integer>> result = new ArrayList<>(2);
		LinkedListNode<Integer> list1 = new LinkedListNode<>(11);
		LinkedListNode<Integer> list2 = new LinkedListNode<>(12);
		LinkedListNode<Integer> list3 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list4 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list5 = new LinkedListNode<>(18);
		LinkedListNode<Integer> list6 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list7 = new LinkedListNode<>(12);
		LinkedListNode<Integer> list8 = new LinkedListNode<>(11);
		list8.setNext(list7);
		list7.setNext(list6);
		list6.setNext(list5);
		list5.setNext(list4);
		list4.setNext(list3);
		list3.setNext(list2);
		list2.setNext(list1);
		result.add(list8);

		LinkedListNode<Integer> anotherList1 = new LinkedListNode<>(10020);
		anotherList1.setNext(new LinkedListNode<>(30));
		anotherList1.next.setNext(list8);
		result.add(anotherList1);
		return result;
	}

	@Test
	void testIntersectionOfTwoListsNullCheck() {

		LinkedListNode<Integer> list1 = null;
		LinkedListNode<Integer> list2 = null;
		assertEquals(Optional.empty(), ListsIntersection.intersectionOfTwoLists(list1, list2));
		assertEquals(Optional.empty(), ListsIntersection.getInsectionUsingLoops(list1, list2));
		assertEquals(Optional.empty(), ListsIntersection.getInsectionUsingBuffer(list1, list2));
	}

	@Test
	void testIntersectionOfTwoListsDifferentTails() {

		ArrayList<LinkedListNode<Integer>> lists = new ArrayList<>(2);

		LinkedListNode<Integer> list1 = new LinkedListNode<>(19);
		LinkedListNode<Integer> list2 = new LinkedListNode<>(12);
		LinkedListNode<Integer> list3 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list4 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list5 = new LinkedListNode<>(18);
		LinkedListNode<Integer> list6 = new LinkedListNode<>(15);
		LinkedListNode<Integer> list7 = new LinkedListNode<>(12);
		LinkedListNode<Integer> list8 = new LinkedListNode<>(15);
		list8.setNext(list7);
		list7.setNext(list6);
		list6.setNext(list5);
		list5.setNext(list4);
		list4.setNext(list3);
		list3.setNext(list2);
		list2.setNext(list1);
		lists.add(list8);

		LinkedListNode<Integer> anotherList1 = new LinkedListNode<>(10020);
		anotherList1.setNext(list3);
		anotherList1.setNext(new LinkedListNode<>(10030));
		lists.add(anotherList1);

		assertEquals(Optional.empty(), ListsIntersection.intersectionOfTwoLists(lists.get(0), lists.get(1)));
		assertEquals(Optional.empty(), ListsIntersection.getInsectionUsingLoops(lists.get(0), lists.get(1)));
		assertEquals(Optional.empty(), ListsIntersection.getInsectionUsingBuffer(lists.get(0), lists.get(1)));
	}

	@Test
	void testIntersectionOfTwoLists() {
		List<LinkedListNode<Integer>> createLists = ListsIntersectionTest.createLists();
		LinkedListNode<Integer> list1 = createLists.get(0);
		LinkedListNode<Integer> list2 = createLists.get(1);
		Optional<LinkedListNode<Integer>> result = ListsIntersection.intersectionOfTwoLists(list1, list2);
		Optional<LinkedListNode<Integer>> result1 = ListsIntersection.getInsectionUsingLoops(list1, list2);
		Optional<LinkedListNode<Integer>> result2 = ListsIntersection.getInsectionUsingBuffer(list1, list2);

		assertEquals(11, result.get().data);
		assertEquals(12, result.get().next.data);

		assertEquals(11, result1.get().data);
		assertEquals(12, result1.get().next.data);
		
		assertEquals(11, result2.get().data);
		assertEquals(12, result2.get().next.data);
	}

	@Test
	void testGetLengthAndTail() {
		LinkedListNode<Integer> createLinkedList = TestUtility.createLinkedList();
		LinkedListNode<Integer> anotherLinkedList = null;
		assertEquals(8, ListsIntersection.getLengthAndTail(createLinkedList).length);
		assertEquals(0, ListsIntersection.getLengthAndTail(anotherLinkedList).length);
	}

}
