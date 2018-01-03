package first.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class PrintListFromEnd {
	public void printListEnd(LocalNode head) {
		if (head == null) {
			return;
		}
		printListEnd(head.next);
		System.out.println(" --> " + head.data);
	}
	
	public int isLengthEven(LocalNode head) {
		while(head != null && head.next != null)
			head = head.next.next;
			if(head == null){
				return 1;
			}
			return 0;
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
		ll.push(04);

		System.out.println("Your linked list is :");
		ll.display(ll.head);
		System.out.println();
		//System.out.println("Priting list form end :");
		//PrintListFromEnd pLend = new PrintListFromEnd();
		//pLend.printListEnd(ll.head);
		
		System.out.println("Printing linkedlist is even or odd:");
		PrintListFromEnd pLend = new PrintListFromEnd();
		System.out.println("ans: "+pLend.isLengthEven(ll.head));
	}
}
