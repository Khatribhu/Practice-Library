package first.java8Features;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class Lambda {
	public static void main(String[] args) {
		Lambda lambda = new Lambda();
		
		//with type declaration
		MathOperation addition = (int a, int b) -> a + b;
		
		//without type declaration
		MathOperation substraction = (a, b) -> a - b;
		
		//with return statement along with curly braces.
		MathOperation multiplication = (int a, int b) -> {return a*b;};
		
		MathOperation division = (int a, int b) -> a/b;
		
		System.out.println("10+5 = "+lambda.operate(10, 5, addition));
		System.out.println("10-5 = "+ lambda.operate(10, 5, substraction));
		System.out.println("10 * 5 = "+ lambda.operate(10, 5, multiplication));
		System.out.println("10 / 5 = "+lambda.operate(10, 5, division));
		
		//with parenthesis
		GreetinService greetinService1 = message -> System.out.println("Hello "+message);

		GreetinService greetinService2 = message -> System.out.println("How are you "+message);

		greetinService1.sayMessaage("bhupendra");
		
		greetinService2.sayMessaage("khatri ji ");

		MyInterface myInterface = value -> System.out.println("is working "+ value);
		
		myInterface.checking(true);
		
	}
	
	@FunctionalInterface
	interface MathOperation {
		int operation(int a, int b);
	}
	
	@FunctionalInterface
	interface GreetinService {
		void sayMessaage(String message);
	}
	
	@FunctionalInterface
	interface MyInterface {
		void checking(boolean working);
	}
	
	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a,b);
	}
}
