package com.vikas.linkedlist;

public class TestUtility {

	public static MySinglyLinkedList<Integer> createList() {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.appendToTail(11);
		list.appendToTail(12);
		list.appendToTail(15);
		list.appendToTail(15);
		list.appendToTail(18);
		list.appendToTail(15);
		list.appendToTail(12);
		list.appendToTail(11);
		return list;
	}

	public static LinkedListNode<Integer> createLinkedList() {
		LinkedListNode<Integer> list1 = new LinkedListNode<>(19);
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
		return list8;
	}
	
	public static LinkedListNode<Integer> createAnotherLinkedList() {
		LinkedListNode<Integer> list1 = new LinkedListNode<>(1);
		LinkedListNode<Integer> list2 = new LinkedListNode<>(2);
		LinkedListNode<Integer> list3 = new LinkedListNode<>(3);
		LinkedListNode<Integer> list4 = new LinkedListNode<>(4);
		LinkedListNode<Integer> list5 = new LinkedListNode<>(5);
		LinkedListNode<Integer> list6 = new LinkedListNode<>(6);
		LinkedListNode<Integer> list7 = new LinkedListNode<>(7);
		LinkedListNode<Integer> list8 = new LinkedListNode<>(8);
		list8.setNext(list7);
		list7.setNext(list6);
		list6.setNext(list5);
		list5.setNext(list4);
		list4.setNext(list3);
		list3.setNext(list2);
		list2.setNext(list1);
		return list8;
	}
}
