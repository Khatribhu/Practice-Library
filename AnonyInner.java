package first;

class Outside {
	int n = 12;
	void show() {
		System.out.println("Called from outside class...");
	}
}

interface inter {
	public void showing();
}
public class AnonyInner {
	
	static Outside out = new Outside() {
		void show() {
			n = 15;
			System.out.println(n);
			super.show();
			System.out.println("Call coming from Anonymous inner class");
		}
	};
	
	static inter in = new inter() {
		public void showing() {
			System.out.println("This is implementation of the anonymous class ");
		}
	};
	
	public static void main(String[] args) {
		out.show();
		//in.showing();
	}
}
