package first.java8Features;

import java.util.Optional;


/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class OptionalClass {
	public static void main(String[] args) {
		
		OptionalClass optionalClass = new OptionalClass();
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		//Option of nullable allow passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);
		
		//Optional.of - throws NullPointerException if passed parameter is null.
		Optional<Integer> b = Optional.of(value2);
		
		System.out.println(optionalClass.sum(a,b));
		
	}
	
	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		
		//Optional.isPresent - checks the value is present or not.
		System.out.println("First parameter is present: "+ a.isPresent());
		System.out.println("Second ??"+ b.isPresent());
		
		//Optional.orElse - return the value if present otherwise return the default value passed.
		Integer value1 = a.orElse(new Integer(0));
		
		//Optional.get - gets the value, value should be present.
		Integer value2 = b.get();
		return value1+value2;
	}
}
