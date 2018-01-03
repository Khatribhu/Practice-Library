package first.LinkedList;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class SwapPairsLL {
	
	public static LocalNode swap(LocalNode head) {
		LocalNode temp = head;
		if(head == null) {
			return null;
		}
		while (temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			//temp = temp.next.next;
			temp = swap(temp.next.next);
		}
		return head;
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
		System.out.println("Printing linkedlist after swapping:");
		LocalNode result = swap(ll2.head);
		ll2.display(result);
		
	}
}
