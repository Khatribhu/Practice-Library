package first.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
class LocalNode {
	
	int data;
	LocalNode next;
	
	public LocalNode() {
	}
	
	public LocalNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}
	public LocalNode getNext() {
		return next;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(LocalNode next) {
		this.next = next;
	}
}

class linkedListClassStack {
	int size;
	LocalNode head;
	LocalNode end;
	
	linkedListClassStack() {
		this.size = 0;
		this.head = null;
		this.end = null;
	}
	
	LocalNode createNewNode(int data) {
		LocalNode newObj = new LocalNode(data);
		return newObj;
	}
	
	void push(int data) {
		LocalNode node = this.createNewNode(data);
		node.next = this.head;
		head = node;
		this.size++;
	}
	
	LocalNode pop() {
		LocalNode temp = this.head;
		this.head = this.head.next;
		this.size--;
		return temp;
	}
	
	void display(LocalNode head) {
		while(head != null) {
			System.out.print(head.data+" <- ");
			head = head.next;
		}
	}
}
public class StackUsingLL {
	public static void main(String[] args) {
		linkedListClassStack ll = new linkedListClassStack();
		ll.push(1);
		ll.push(4);
		ll.push(6);
		ll.push(9);
		ll.push(0);
		
		ll.display(ll.head);
		
		System.out.println("Popping out once: ");
		
		ll.pop();
		
		ll.display(ll.head);
		
		System.out.println("Popping out thrice: ");
		
		ll.pop();
		ll.pop();
		ll.pop();
		
		ll.display(ll.head);
	}	
}
