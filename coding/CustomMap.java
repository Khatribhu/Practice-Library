package coding;

import java.util.HashMap;

public class CustomMap<K, V> {

	HashMap<Integer, String> hs1 = new HashMap<>();
	HashMap<String, Integer> hs2 = new HashMap<>();

	public void put(Integer key, String value) {
		this.hs1.put(key, value);
		this.hs2.put(value, key);
	}

	public Object get(Object key, boolean isKey) {
		if (isKey) {
			return this.hs1.get(key);
		} else {
			return this.hs2.get(key);
		}
	}

	public static void main(String[] args) {
		CustomMap<Integer, String> aCustomMap = new CustomMap<>();

		aCustomMap.put(1, "abc");
		aCustomMap.put(2, "bcd");
		aCustomMap.put(3, "xyz");

		System.out.println(aCustomMap.get(1, true));
		System.out.println(aCustomMap.get("xyz", false));

	}

}
