package first.concurrency;

class Table {
	public static synchronized void printTable(int n) {
		for(int i = 0; i < 10; i++) {
			System.out.println(n*1);
			try {
				Thread.sleep(400);
			}catch(Exception e) {
				
			}
		}
	}
}
public class StaticSynchronization {
	public static void main(String[] args) {
		
		Thread t1 = new Thread() {
			public void run() {
				 new Table().printTable(1);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				new Table().printTable(10);
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				new Table().printTable(100);
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				new Table().printTable(200);
			}
		};
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
