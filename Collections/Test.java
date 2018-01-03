package first.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		Hashtable hs = new Hashtable<>();
		
		HashMap<String, String> hs2 = new HashMap<>();
		
		TreeMap<String, String> treeMap = new TreeMap<>();
	//	treeMap.put(null, null);
		
		HashMap<String, String> linkedHaspMap = new LinkedHashMap<>();
		linkedHaspMap.put(null, null);
		linkedHaspMap.put("String", null);
		
		//hs.put(1, null);
		hs2.put(null, null);
		hs2.put(null, null);
		
		TreeSet<String> ts = new TreeSet<>();
		
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add(null);
		
		List<String> lList = new LinkedList<>();
		lList.add(null);
		
	}
}
