package first.LinkedList;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class MiddleElementLL {
	
	public static LocalNode middleElement(LocalNode head) {
		LocalNode slowPtr, fastPtr;
		slowPtr = head;
		fastPtr = head;
		while(fastPtr != null && fastPtr.next != null && fastPtr.next.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	public static void main(String[] args) {
		linkedListClassStack ll = new linkedListClassStack();
		ll.push(1);
		ll.push(4);
		ll.push(6);
		ll.push(9);
		ll.push(3);
		ll.push(7);
		ll.push(40);
		ll.push(66);
		ll.push(94);
		ll.push(02);
		ll.push(02);
		
		System.out.println("Your linked list is :");
		ll.display(ll.head);
		System.out.println();
		LocalNode mid = middleElement(ll.head);
		System.out.println("Middle element :"+mid.data);

	}
}
