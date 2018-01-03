package dp;

import java.util.Arrays;

public class CoinChange {
	
	// Solution using recursion.
	public int calculatePermute(int[] set, int m, int n) {
		
		//sum is less than zero
		if(n < 0 ) {
			return 0;
		}
		//No coins are zero but sum is not zero.
		if(m == 0 && n != 0) {
			return 0;
		}
		
		//if sum is zero.
		if(n == 0) {
			return 1;
		}
		
		//excluding or including the last element.
		return (calculatePermute(set, m-1, n) + calculatePermute(set, m, n-set[m-1]));
	}
	
	public long[] calculatePermuteDP(int[] set, int m, int n) {
		
		// n = sum required.
		// m = size of the set.
		long[] table = new long[n+1];
		
		Arrays.fill(table, 0);
		
		table[0] = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = set[i]; j <= n; j++) {
				table[j] += table[j - set[i]];
			}
		}
		
		return table;
	}
	
	public static void main(String[] args) {
		
		CoinChange cc = new CoinChange();
		int[] input = {1,2,3,4};
		int N = 4;
		int size = input.length;
		long[] table = cc.calculatePermuteDP(input, size, N);
		/*for(int i = 0; i < table.length; i++) {
			System.out.print(table[i] +" ");
		}*/
		
		System.out.println(table[table.length-1]);
		
		//System.out.println(cc.calculatePermute(input, size, N));
		
	}
}
