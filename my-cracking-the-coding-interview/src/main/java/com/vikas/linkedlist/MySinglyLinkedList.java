package com.vikas.linkedlist;

import java.util.Objects;

/** This is a custom made singly linked list with a very few utility methods */
public class MySinglyLinkedList<E> implements CustomLinkedList<E> {

	private Node<E> head;

	static class Node<E> {
		Node<E> next;
		E data;

		Node(E data) {
			next = null;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node: ["+this.data+", next:"+next+"]";
		}
	}

	public void appendToTail(E data) {
		Node<E> newNode = new Node<>(data);

		if (Objects.isNull(head)) {
			head = newNode;
		} else {
			Node<E> temp = head;
			while (Objects.nonNull(temp.next)) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void display() {
		if (Objects.isNull(head)) {
			System.out.println("No data present");
		} else {
			System.out.println(this);
		}
	}

	public Node<E> getHead() {
		return head;
	}

	@Override
	public String toString() {
		return "Head: " + head;
	}

}
