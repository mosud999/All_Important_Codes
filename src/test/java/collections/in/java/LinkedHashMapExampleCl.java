package collections.in.java;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class LinkedHashMapExampleCl {

	@Test

	// Java LinkedHashMap Example
	public void m() {
		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

	// Java LinkedHashMap Example: Key-Value pair
	public void m1() {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		// Fetching key
		System.out.println("Keys: " + map.keySet());
		// Fetching value
		System.out.println("Values: " + map.values());
		// Fetching key-value pair
		System.out.println("Key-Value pairs: " + map.entrySet());
	}

	// Java LinkedHashMap Example:remove()
	public void m2() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(101, "Amit");
		map.put(102, "Vijay");
		map.put(103, "Rahul");
		System.out.println("Before invoking remove() method: " + map);
		map.remove(102);
		System.out.println("After invoking remove() method: " + map);
	}

}
