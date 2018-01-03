package first.graph;

public class FindMedianOfTwoArray {
	
	public static int getMedianDivideAndConquer(int arr1[], int arr2[], int n) {
		if(n <= 0) {
			return -1;
		}
		
		if(n == 1) {
			return (arr1[0]+arr2[0])/2;
		}
		
		if(n == 2) {
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[0], arr2[0]))/2;
		}
		
		int m1 = median(arr1, n);
		int m2 = median(arr2, n);
		
		if(m1 == m2) {
			return m1;
		}//If m1 > m2 then median must present in arr1[0] to m1 and m2 to arr2[n-1]
		else if(m1 > m2) {
			if( n % 2 == 0) {
				return getMedian(arr1, arr2, n - n/2 +1);
			}else {
				return getMedian(arr1, arr2, n );
			}
		}else {
			return 0;
		}
		
	}
	
	/*
	 * Find the median of the single array.
	 */
	public static int median(int[] arr, int n) {
		if(n % 2 == 0) {
			return (arr[n/2]+arr[n/2-1])/2;
		}else {
			return arr[n/2];
		}
	}
	/*
	 * Normal approch to find the median of the merged array.
	 * This approch will take O(n) time.
	 */
	public static int getMedian(int [] arr1, int[] arr2, int n) {
		int m1 = -1, m2 = -1;
		int i = 0, j = 0;
		for(int c = 0; c <= n; c++) {
			
			if(i == n) {
				m2 = m1;
				m1 = arr2[0];
				break;
			}else if(j == n) {
				m2 = m1;
				m1 = arr1[0];
				break;
			}
			if(arr1[i] < arr2[j]) {
				m2 = m1;
				m1 = arr1[i];
				i++;
			}else{
				m2 = m1;
				m1 = arr2[j];
				j++;
			}
		}
		
		return ((m1+m2)/2);
		
	}
    public static void main (String[] args)
    {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
      
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 == n2)
            System.out.println("Median is " +
                        getMedian(ar1, ar2, n1));
        else
            System.out.println("arrays are of unequal size");
    }  
}
