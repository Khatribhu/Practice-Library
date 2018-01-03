package first.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class ReverseKNodes {

	public static LocalNode reverse(LocalNode head, int K) {

		LocalNode prev = null, current = head, next = null;
		int count = K;
		while (current != null && count != 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}

		if (next != null) {
			head.setNext(reverse(next, K));
		}

		return prev;
	}

	public static void main(String[] args) {

		linkedListClassStack ll2 = new linkedListClassStack();
		ll2.push(99);
		ll2.push(66);
		ll2.push(8);
		ll2.push(6);
		ll2.push(7);
		ll2.push(4);

		System.out.println("Your linked list two is :");
		ll2.display(ll2.head);
		System.out.println();
		System.out.println("Printing linkedlist after K node reverse:");
		LocalNode result = reverse(ll2.head, 4);
		ll2.display(result);

	}

}
