package first.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class MergeLL {

	public static LocalNode merge(LocalNode n1, LocalNode n2) {
		LocalNode mergedNode;
		linkedListClassStack mergedLL = new linkedListClassStack();
		if (n1 == null) {
			return n2;
		}
		
		if(n2 == null) {
			return n1;
		}
		
		while (n1 != null && n2 != null) {
			if (n1.data < n2.data) {
				mergedLL.push(n1.data);
				n1 = n1.next;
			} else {
				mergedLL.push(n2.data);
				n2 = n2.next;
			}
		}
		
		while(n1 != null) {
			mergedLL.push(n1.data);
			n1 = n1.next;
		}
		
		while(n2 != null) {
			mergedLL.push(n2.data);
			n2 = n2.next;
		}
		
		return mergedLL.head;
	}

	public static void main(String[] args) {
		linkedListClassStack ll = new linkedListClassStack();
		
		ll.push(20);
		ll.push(13);
		ll.push(5);
		ll.push(2);
		ll.push(1);

		linkedListClassStack ll2 = new linkedListClassStack();
		ll2.push(99);
		ll2.push(66);
		ll2.push(8);
		ll2.push(6);
		ll2.push(7);
		ll2.push(4);

		System.out.println("Your linked list one is :");
		ll.display(ll.head);
		System.out.println();

		System.out.println("Your linked list two is :");
		ll2.display(ll2.head);
		System.out.println();

		System.out.println("Printing linkedlist after merging:");
		LocalNode mergedHead = merge(ll.head , ll2.head);
		ll2.display(mergedHead);
	}

}
