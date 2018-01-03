package zoloStay;
import java.util.Scanner;

public class Solution {
	static int result;

	/**
	 * Method to find if subset is having same sum are passed.
	 * 
	 * @param set
	 * @param size
	 * @param sum
	 * @return
	 */
	public static boolean isSubsetSum(int set[], int size, int sum) {
		
		//when sum is zero
		if (sum == 0)
			return true;
		
		//size of the set is zero but sum is not zero.
		if (size == 0 && sum != 0)
			return false;

		return isSubsetSum(set, size - 1, sum) || isSubsetSum(set, size, sum - set[size - 1]);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int val = scn.nextInt();
		scn.close();

		int[] set = { 3, 7, 14 };

		// Checking if number is divisible by given set.
		for (int i = 0; i < set.length; i++) {
			if (val % set[i] == 0) {
				result++;
			}
		}

		// Checking for subset whose sum is equals to given value.
		if (isSubsetSum(set, 3, val)) {
			result++;
		}

		System.out.println(result);

	}
}
