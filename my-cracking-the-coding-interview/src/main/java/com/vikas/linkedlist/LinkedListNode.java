package com.vikas.linkedlist;

import java.util.Objects;

public class LinkedListNode<E> implements CustomLinkedList {

	LinkedListNode<E> next;
	LinkedListNode<E> previous;
	LinkedListNode<E> last;
	E data;

	public LinkedListNode(E data, LinkedListNode<E> n, LinkedListNode<E> p) {
		this.data = data;
		setNext(n);
		setPrevious(p);
	}

	public LinkedListNode(E data) {
		this.data = data;
	}

	public LinkedListNode() {
	}

	public void setNext(LinkedListNode<E> n) {
		next = n;

		if (this == last) {
			last = n;
		}

		if (Objects.nonNull(n) && n.previous != this) {
			n.setPrevious(this);
		}
	}

	public void setPrevious(LinkedListNode<E> p) {
		previous = p;
		if (Objects.nonNull(p) && p.next != this) {
			p.setNext(this);
		}
	}

	public LinkedListNode<E> copy() {
		LinkedListNode<E> next2 = null;
		if (next != null) {
			next2 = next.copy();
		}
		LinkedListNode<E> head2 = new LinkedListNode<>(data, next2, null);
		return head2;
	}
	
	public void display() {
		LinkedListNode<E> node = this;
		
		while(node!= null) {
			System.out.println("Node value: "+node);
			node = node.next;
		}
	}
	
	@Override
	public String toString() {
		return "Node: ["+this.data+", next: "+next+"]";
	}

}
