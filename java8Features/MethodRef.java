package first.java8Features;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;


/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class MethodRef {
	public static void myStaticMethod(String value) {
		System.out.println("hello dear..."+value);
	}
	
	public void instanceMethod(String arg) {
		System.out.println("I am instance method by "+arg);
	}

	public void NewCheck(HashSet hs) {
		System.out.println(hs.getClass());
	}
	public static void main(String[] args) {
		//By below way we can reference a functional interface method as a static method in class.
		//static method ref done using method reference
		myInterface myIntRef = MethodRef::myStaticMethod;
		myIntRef.interfaceMethod("static method ref using method ref");
		
		//Static method ref done using Lambda exp.
		myInterface myRef = method -> MethodRef.myStaticMethod(method);
		myRef.interfaceMethod("static method ref using lambda");
		
		
		//instance methodd ref done using method ref
		MethodRef ref = new MethodRef();
		secondInterface myintRef2 = ref::instanceMethod;
		myintRef2.interface2Method("ref method");
		
		//instance methodd ref done using lambda
		secondInterface myintRef3 = value -> ref.instanceMethod(value);
		myintRef2.interface2Method("lambda");
		
		//instance method creating using method ref
		final Car car = Car.create(Car :: new);
		final List<Car> cars = Arrays.asList(car);
		
		//calling the method of class
		cars.forEach(Car::callMe);
		
		
	}
	
	public static class Car {
		public static Car create( final Supplier<Car> supplier) {
			return supplier.get();
		}
		
		public void callMe() {
			System.out.println("wake up its mrng");
		}
	}
	
	
	@FunctionalInterface
	interface myInterface {
		void interfaceMethod(String arg);
	}

	@FunctionalInterface
	interface secondInterface {
		void interface2Method(String arg);
	}
	
	@FunctionalInterface
	interface thirdInterface {
		void thirdMethod(HashSet hs);
	}
}
