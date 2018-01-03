package first;

public class CountPerfectSquare {

	static void countPerfectSquare(int m, int n) {
		int count = 0;
		for(int i = m; i <= n; i++) {
			
			//check if q is perfect square
			for(int j =1; j*j <= i; j++) {
				if(j*j == i) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	public static void main(String[] args) {
		countPerfectSquare(9, 25);
	}
}
