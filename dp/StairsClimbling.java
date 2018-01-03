package dp;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class StairsClimbling {

	// A recursive function used by countWays
	static int countWaysUtilDP(int n, int m) {
		int res[] = new int[n];
		res[0] = 1;
		res[1] = 1;
		printArr(res);
		
		System.out.println("Before starting operations:  ");
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			
			for (int j = 1; j <= m && j <= i; j++)
				res[i] += res[i - j];
			
			printArr(res);
		}
		return res[n - 1];
	}

	// Returns number of ways to reach s'th stair
	static int countWays(int s, int m) {
		int recur = countWaysUtil(s + 1, m);
		//int dp = countWaysUtilDP(s + 1, m);
		return recur;
	}
	
	static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	static int countWaysBK(int n, int m) {
		int res[] = new int[n+1];
		
		res[0] = 1;
		res[1] = 1;
		//lopping through all the numbers 
		for(int i = 2; i < n; i++) {
			res[i] = 0;
			for(int j = 1; j <= m && j <= i; j++) {
				res[i] += res[i-j];
			}
		}
		
		return res[n-1];
	}
	
	static int countWaysUtil(int n, int m)
    {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i<=m && i<=n; i++) {
        	res += countWaysUtil(n-i, m);
        }
            
        return res;
    }

	// Driver method
	public static void main(String[] args) {
		int s = 3, m = 3;
		System.out.println("Nuber of ways = " + countWays(s, m));
	}
}