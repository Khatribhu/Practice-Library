package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

class Fruit implements Comparable<Fruit> {
	private int quantity;
	private String name;

	Fruit(String name) {
		this.name = name;
		this.quantity = 0;
	}

	Fruit(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Fruit frt = (Fruit) obj;
		if (frt.getName().equals(this.getName())) {
			return true;
		} else {
			return false;
		}
	}

	public Fruit[] getMax(Fruit[] fruits) {
		int max = 0;
		Arrays.sort(fruits);
		return fruits;
	}

	@Override
	public int compareTo(Fruit o) {
		return (this.getQuantity() < o.getQuantity()) ? -1 : ((this.getQuantity() == o.getQuantity()) ? 0 : 1);
	}

}

public class arrangeFruits {

	/**
	 * Get the max fruit out of the map.
	 * 
	 * @param hmap
	 * @param frtName
	 * @return
	 */
	public String getMaxFreqFruitName(HashMap<String, Integer> hmap, String frtName) {

		for (Entry<String, Integer> entry : hmap.entrySet()) {
			//if getting value of max fruits for the first time.
			if (frtName == "") {
				int val = entry.getValue();
				if (val > 0) {
					hmap.put(entry.getKey(), --val);
				}
				return entry.getKey();
			} else if (!entry.getKey().equals(frtName)) {
				//if value is not same as previous.
				int val = entry.getValue();
				if (val > 0) {
					hmap.put(entry.getKey(), --val);
				}
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Method to process the fruits.
	 * 
	 * @param inputArray
	 * @return
	 */
	public String[] processFruits(String[] inputArray) {
		HashMap<String, Integer> hmap = new HashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			if (hmap.containsKey(inputArray[i])) {
				int key = hmap.get(inputArray[i]);
				hmap.put(inputArray[i], ++key);
			} else {
				hmap.put(inputArray[i], 1);
			}
		}

		arrangeFruits af = new arrangeFruits();

		hmap = (HashMap<String, Integer>) sortByValue(hmap);
		String stringArray[] = new String[inputArray.length];
		int p = 0;
		int index = 0;
		while (p < inputArray.length) {
			if (p == 0) {
				if (!hmap.isEmpty())
					stringArray[p++] = af.getMaxFreqFruitName(hmap, "");
				else
					break;
			} else {
				if (!hmap.isEmpty()) {
					index = p - 1;
					stringArray[p++] = af.getMaxFreqFruitName(hmap, stringArray[index]);

				} else
					break;
			}
			hmap = (HashMap<String, Integer>) sortByValue(hmap);
		}
		return stringArray;
	}

	/**
	 * Sorting map by value in reverse order.
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Integer> sortByValue(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	public static void main(String[] args) {
		String[] array = { "APPLE", "BANANA", "MANGO", "ORANGE", "JACKFRUIT", "GUVAVA", "APPLE", "APPLE", "APPLE",
				"APPLE", "ORANGE", "JACKFRUIT", "ORANGE", "JACKFRUIT", "ORANGE", "JACKFRUIT" };

		arrangeFruits af = new arrangeFruits();
		String[] result = af.processFruits(array);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
}
