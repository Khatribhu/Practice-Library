package coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class NonRepeatingCharacter {

	public static int firstNonRepeating(String str) {
		Map<Character, Integer> hs = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if(!hs.containsKey(str.charAt(i))) {
				hs.put(str.charAt(i), 1);
			}else {
				int val = hs.get(str.charAt(i));
				hs.put(str.charAt(i), ++val);
			}
		}
		
		hs = sortByValue(hs);
		
		Set<Entry<Character, Integer>> set = hs.entrySet();
		
		outer:
		for(int i = 0; i < str.length(); i++) {
			for(Object obj : set) {
				Entry<Character, Integer> entry = (Entry<Character, Integer>)obj;
				if(entry.getKey() == str.charAt(i) && entry.getValue() == 1) {
					System.out.println("First non Repeating value is: "+ entry.getKey());
					break outer;
				}
			}
		}
		return 1;
	}
	
	
	public static Map<Character, Integer> sortByValue(Map<Character, Integer> hs) {
		
		List<Map.Entry<Character, Integer>> list = new LinkedList<>(hs.entrySet());
				
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o1.getValue() > o2.getValue()) ? 1 : -1; 
			}
		});
		
		Map<Character, Integer> sortedMap = new LinkedHashMap<>();
		
		for(Map.Entry<Character, Integer> entry : list ) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	
	/**
	 * First non repeating char
	 * @param str
	 */
	public static void nonRepeatingChar(String str) {
		int freq[] = new int[105];
	//	Arrays.fill(freq, 0);
		
		str = str.toUpperCase();
		
		for(int i = 0; i < str.length(); i++) {
			int val = freq[str.charAt(i)];
			freq[str.charAt(i)] = ++val;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(freq[str.charAt(i)] == 1) {
				System.out.println("first non repeating char is: "+str.charAt(i));
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
	//	int index = firstNonRepeating(str);
		nonRepeatingChar(str);
//		System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " + " or string is empty"
//				: "First non-repeating character is " + str.charAt(index));

	}

}
