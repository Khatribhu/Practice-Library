package first.java8Features;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class StreamExample {
	public static void main(String[] args) {
	
		System.out.println("Using Java 8");
		List<String> strings = Arrays.asList("abc", "", "abcd", "", "efg", "jkl");
		System.out.println("list : "+strings);
		
		//find empty strings 
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Number of empty strings : "+count);
		
		//string of length 3
		count = strings.stream().filter(str -> str.length() == 3).count();
		System.out.println("String of length 3 :"+ count);
		
		//filter out list with strings which are non empty and length greater than 3
		List<String> filtered = strings.stream().filter(str -> !str.isEmpty() && str.length() > 3).collect(Collectors.toList());
		
		//merging all the strings 
		String mergeredString = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged string of all the string with , "+mergeredString);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		
		//square list
		List<Integer> sqList = numbers.stream().map(num -> num*num).collect(Collectors.toList());
		System.out.println("list : "+numbers);
		System.out.println("sqList : "+ sqList);
		
		//Statictics
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) ->x).summaryStatistics();
		System.out.println("Highest number in list: "+ stats.getMax());
		System.out.println("lowest: "+ stats.getMin());
		System.out.println("sum: "+stats.getSum());
		System.out.println("avg:"+ stats.getAverage());
		
		System.out.println("Random numbers");
		
		//print ten random numbers
	    Random random = new Random();
	    random.ints().limit(10).sorted().forEach(System.out::println);
	    
	    
	    //parallel processing
	    count = strings.parallelStream().filter(str -> str.isEmpty()).count();
	    System.out.println("Empty strings: "+ count);
		
		
	}
}
