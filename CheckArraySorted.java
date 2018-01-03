package first;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class CheckArraySorted {
	
	public static int checkSort(int[] arr, int N) {
		if(N == 1 ) {
			return 1;
		}else {
			return (arr[N-1] > arr[N-2]) ? checkSort(arr, N-1): 0;
		}
	}
	
	public static void main(String[] args) {
		int arr[]  = {1,2,3,4,5,6,7,8,9};
		System.out.println(checkSort(arr,arr.length));
	}
}
