package first.first;

import java.util.Arrays;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class test {

	public static int[] sortArrays(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			c[k++] = a[i];
		}
		
		for (int i = 0; i < b.length; i++) {
			c[k++] = b[i];
		}

		Arrays.sort(c);
		return c;
	}

	public static int[] mergeArray2(int a[], int b[]) {
		int i = 0, j = 0;
		int[] c = new int[a.length + b.length];
		int k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] > b[j]) {
				c[k++] = b[j];
				j++;
			} else {
				c[k++] = a[i];
				i++;
			}
		}
		while (i < a.length) {
			c[k++] = a[i];
			i++;
		}

		while (j < b.length) {
			c[k++] = b[j];
			j++;
		}

		return c;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6, 8 };
		int b[] = { 2, 3, 55, 77, 78, 787, 888, 999 };

		int c[] = new int[a.length + b.length];
		int d[] = new int[a.length + b.length];

		System.out.println();
		c = sortArrays(a, b);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + ", ");
		}

		System.out.println();
		d = mergeArray2(a, b);
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + ", ");
		}
	}
}
