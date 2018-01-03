package generics;

class Third<T> {
	T name;

	Third(T t) {
		System.out.println("usnig T type as : ");
		System.out.println("Using type as :" + t.getClass().getName());
		calling(t);
	}

	public void calling(T val) {
		name = val;
		System.out.println(name);
	}
}

public class Generics {

	public static void main(String[] args) {
		String str = new String("khatri");
		Integer inn = new Integer(4);
		Object obj = new Object();

		Third th = new Third(obj);

	}

}
