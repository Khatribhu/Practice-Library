package first.java8Features;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodReference {
	public static void main(String[] args) {
		List names = new ArrayList();
		
		names.add("tinku");
		names.add("chintu");
		names.add("pinki");
		names.add("neelu");
		
		names.forEach(System.out::println);
		
		MethodRef staticClass = new MethodRef();

		String l = "someone";
		
		
		
		
		
	}
	
	public static void callme(){
		System.out.println("Thank you..");
	}
	
}
