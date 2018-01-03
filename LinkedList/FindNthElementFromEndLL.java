package first.LinkedList;

import java.util.Scanner;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class FindNthElementFromEndLL {

	/**
	 * This method will set a temp variable when current pointer reaches to the
	 * size which is equals to desired element from the end and initialized it
	 * with head of the LL then for next element start incrementing the value of
	 * temp var and when it reached end of the LL then print value of that temp
	 * variable.
	 * 
	 * @param head
	 * @param N
	 */
	public static void findNthElement(LocalNode head, int N) {
		LocalNode temp = head;
		LocalNode temp2 = null;
		int count = 1;
		while (temp != null) {
			if (count >= N) {
				if (count > N) {
					temp2 = temp2.next;
				} else {
					//Initlizes the value when count == N.
					temp2 = head;
				}
			}
			temp = temp.next;
			count++;
		}

		System.out.println("Desired output is : -> " + temp2.data);
	}

	public static void main(String[] args) {
		linkedListClassStack ll = new linkedListClassStack();
		ll.push(1);
		ll.push(4);
		ll.push(6);
		ll.push(9);
		ll.push(0);
		ll.push(1);
		ll.push(4);
		ll.push(6);
		ll.push(9);
		ll.push(0);

		System.out.println("Your linked list is :");
		ll.display(ll.head);
		System.out.println();
		System.out.println("Enter the element position to find (from end) :");
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		findNthElement(ll.head, N);

	}
}