package com.vikas.linkedlist;

import java.util.Objects;

import com.vikas.linkedlist.MySinglyLinkedList.Node;

/**
 * Partition a list around x. List not necessarily be sorted. Elements on either
 * side can be randomly distributed.
 * 
 * Input : 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1(x=5) Output: 3 -> 1 -> 2 -> 10 -> 5
 * -> 5 -> 8
 */
public class PartitionList {

	public Node<Integer> partitionList(MySinglyLinkedList<Integer> list, int partitionPoint) {
		Utility.checkInvalidInput(list);

		Node<Integer> startOfHighest = null;
		Node<Integer> startOfLeast = null;
		Node<Integer> endOfLeast = null;
		Node<Integer> endOfHighest = null;

		Node<Integer> node = list.getHead();

		while (Objects.nonNull(node)) {
			int data = node.data.intValue();
			Node<Integer> temp = new Node<>(data);

			if (data < partitionPoint) {
				if (startOfLeast == null) {
					startOfLeast = temp;
					endOfLeast = startOfLeast;
				} else {
					endOfLeast.next = temp;
					endOfLeast = endOfLeast.next;
				}
			} else {
				if (startOfHighest == null) {
					startOfHighest = temp;
					endOfHighest = startOfHighest;
				} else {
					endOfHighest.next = temp;
					endOfHighest = endOfHighest.next;
				}
			}

			node = node.next;
		}

		if (startOfLeast == null)
			return startOfHighest;
		else
			endOfLeast.next = startOfHighest;

		return startOfLeast;
	}

	public Node<Integer> partition(MySinglyLinkedList<Integer> list, int partitionPoint) {
		Utility.checkInvalidInput(list);

		Node<Integer> head = list.getHead();
		Node<Integer> tail = list.getHead();
		Node<Integer> node = list.getHead();

		while (Objects.nonNull(node)) {
			int data = node.data.intValue();
			Node<Integer> temp = node.next; 

			if (data < partitionPoint) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = temp;
		}

		tail.next = null;
		return head;
	}

}
