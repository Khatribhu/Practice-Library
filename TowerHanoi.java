package first;

public class TowerHanoi {

	static void towerOfHanoi(int n, char from, char to, char aux) {
		if(n == 1) {
			System.out.println("Move disk 1 from "+from+" to "+to);
			return;
		}
		
		towerOfHanoi(n-1, from, aux, to);
		System.out.println("Moving "+n+" disk from "+from+" to "+to);
		towerOfHanoi(n-1, aux, to, from);
	}
	
	
	public static void main(String[] args) {
		int n = 4; // Number of disks
		towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
	}
}
