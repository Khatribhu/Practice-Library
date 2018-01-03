package first.Sorting;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class SelectionSort {

	public static int[] selectionSort(int[] arr) {
		int min, j;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 34, 5, 6, 6, 4, 6, 7 };
		//int[] result = selectionSort(arr);
//		BubbleSort bbl = new BubbleSort();
//		int[] result = bbl.bubbleSort(arr);
		InsertionSort ins = new InsertionSort();
		int[] result = ins.InsertionSort(arr);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
