package first.LinkedList;

import java.util.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */

public class LinkedListClass {
	int data;
	LinkedListClass next;

	LinkedListClass(){
		
	}
	
	LinkedListClass(int N) {
		this.data = N;
		this.next = null;
	}
	
	LinkedListClass(int N, LinkedListClass obj) {
		this.data = N;
		this.next = obj;
	}
	
	/**
	 * Adding element at the first place of LL
	 * @param head
	 * @param data
	 */
	public void addFirst(LinkedListClass head, int data) {
		LinkedListClass newObj = new LinkedListClass(data);
		newObj.next = head;
		head = newObj;
	}
	
	/**
	 * Adding element at the end of LL
	 * @param head
	 * @param data
	 */
	public void addLast(LinkedListClass head, int data) {
		if(head != null) {
			LinkedListClass temp = new LinkedListClass();
			while(head != null) {
				temp = head;
				head = head.next;
			}
			LinkedListClass newObj = new LinkedListClass(data);
			temp.next = newObj;
		}
	}
	
	
	public void addMid(LinkedListClass head, int data, int pos) {
		LinkedListClass temp = new LinkedListClass();
		int count = 0;
		while(count != pos) {
			head = head.next;
		}
		
		LinkedListClass newObj = new LinkedListClass(data);
		newObj.next = head.next;
		
	}
	public static void main(String[] args) {
		LinkedListClass llc = new LinkedListClass(3);
		LinkedList ll = new LinkedList();
	}
}
