package coding;

import java.util.Arrays;
import java.util.HashMap;

public class ExpantionOverlap {

	/**
	 * Method to find the overlapping array size in two integer arrays.
	 * 
	 * @param arrOne
	 * @param arrTwo
	 * @return
	 */
	/*
	 * public int calcOverlapCount(int arrOne[], int arrTwo[]) {
	 * 
	 * // Range of array one if if (arrOne[0] < arrTwo[0]) { if (arrOne[1] >
	 * arrTwo[0]) {
	 * 
	 * // ArrayTwo is full overlapped if (arrOne[1] > arrTwo[1]) {
	 * 
	 * // return the length return (arrTwo[1] - arrTwo[0] + 1); } else if (arrTwo[1]
	 * > arrOne[1]) {
	 * 
	 * // sub array Overlaps then gives the subarray. return (arrOne[1] - arrTwo[0]
	 * + 1); } // No overlapping } else {
	 * 
	 * return arrOne[1]; } } else if (arrOne[0] > arrTwo[0]) { // ArrayOne is full
	 * Overlapped. if (arrTwo[1] > arrOne[0]) { if (arrOne[1] < arrTwo[1]) {
	 * 
	 * return (arrOne[1] - arrOne[0] + 1); } else if (arrOne[1] > arrTwo[1]) { //
	 * Partial overlap. return (arrTwo[1] - arrOne[0] + 1); } // No overlapping }
	 * else { return arrTwo[1]; } } return -1; }
	 */

	public int calcOverlapCount(int arrOne[], int arrTwo[]) {

		int first = Math.max(arrOne[0], arrTwo[0]);
		int last = Math.min(arrOne[1], arrTwo[1]);
		int diff1 = last - first + 1;

		if (diff1 <= 0) {
			return arrOne[1];
		} else {
			return diff1;
		}
	}

	
	public int findMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	/**
	 * Method to find out the nth element in the array after expansion of the
	 * containing arrays.
	 * 
	 * @param inputArr
	 * @param n
	 * @return
	 */
	public int setExpansion(int[][] inputArr, int n) {

		int overlappingCount = 0;
		int colArray[] = new int[inputArr.length];

		// Taking first column in array to find out the starting point of range.
		for (int i = 0; i < inputArr.length; i++) {
			colArray[i] = inputArr[i][0];
		}

		int leftMostRange = this.findMin(colArray);
		// element to store upper limit of the array.
		int intrim = leftMostRange + n;
		int arrOne[] = { leftMostRange, intrim };

		// Looping through all the rows of matrix.
		for (int i = 0; i < inputArr.length; i++) {

			if (inputArr[i][0] != leftMostRange) {

				int[] arrTwo = { inputArr[i][0], inputArr[i][1] };
				// Finding out the overlapping value between the arrays passed.
				overlappingCount = calcOverlapCount(arrOne, arrTwo);

				// if arrays are not overlapped.
				if (overlappingCount == arrOne[1]) {
					arrOne[1] = overlappingCount;
				} else if (overlappingCount != -1) {
					intrim -= overlappingCount / 2;
					arrOne[1] = intrim;
				}
			}
		}

		// returning the right most range of the array.
		return arrOne[1];
	}

	public static void main(String[] args) {

		//int[][] input = { { -100000, 100 }, { -10, 10 }, { 3, 5 },{-100000,-99999}};
		int[][] input2 = { { 1, 3 }, { 0, 5 }, { -5, -3 }, { -2, 10 } };
		ExpantionOverlap sol = new ExpantionOverlap();

		// System.out.println(sol.setExpansion(input, 10));
		System.out.println(sol.setExpansion(input2, 10));
	}

}