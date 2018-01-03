package first.LinkedList;

import java.util.Scanner;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class ReverserLL {
	public static void pattern(LocalNode head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		if (head.next != null) {
			pattern(head.next.next);
			System.out.println(head.data);
		}
	}

	public static LocalNode reverse(LocalNode head) {
		LocalNode prev = null, current = head, next = null;
		while (current != null) {
			next = current.next;// saving the next element.
			current.next = prev;// Changing the reference
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	/**
	 * recursive call to reverse the linkedList O(n), O(n)
	 * 
	 * @param head
	 * @return
	 */
	public static LocalNode reverseTwo(LocalNode head) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		}

		LocalNode second = head.next;
		head.next = null;
		LocalNode reverse = reverseTwo(second);
		second.next = head;
		return reverse;
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

		System.out.println("Your linked list is :");
		ll.display(ll.head);
		System.out.println();
		// LocalNode head = reverse(ll.head);
		LocalNode head = reverseTwo(ll.head);
		System.out.println("linked list after reversing :");
		ll.display(head);

		System.out.println("Printing a pattern:");
		pattern(head);
	}
}
