package first.Sorting;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class BubbleSort {
	public int[] bubbleSort(int[] arr) {
		boolean swapped = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j + 1] + arr[j];
					arr[j + 1] = arr[j] - arr[j + 1];
					arr[j] = arr[j] - arr[j + 1];
					swapped = true;
				}
			}
			
			if(!swapped) {
				break;
			}
		}

		return arr;
	}
}
