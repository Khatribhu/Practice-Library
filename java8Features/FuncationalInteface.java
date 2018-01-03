package first.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class FuncationalInteface {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Print all numbers:");

		//pass n as parameter
		eval(list, n->true);
		
		//Predicate<Interger> predicate1 = n -> n%2 =0 
		// n is passsed as parameter to test method of predicate inteface
		//test method will return true if n%2 comes to be zero.
		System.out.println("\nPrint even numbers:");
		eval(list, n->n%2 == 0);
		
		System.out.println("\nPrint numbers greater than 3");
		eval(list, n-> n > 3);
		
	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
	}

}
