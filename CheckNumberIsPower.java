package first;

public class CheckNumberIsPower {
	
	static void checkPower(int a, int b) {
		boolean yes = false;
		if(a == 1) {
			if( b == 1) {
				yes = true;
			}
		}
		
		int pow = a;
		while (pow < b)
			pow = pow * pow;
		
		if (pow == b) {
			yes = true;
		}
		
		if(yes) 
		System.out.println("yes numbner is power");
		else
			System.out.println("No number is not a power");
	}
	public static void main(String[] args) {
		checkPower(3, 81);
	}
}
