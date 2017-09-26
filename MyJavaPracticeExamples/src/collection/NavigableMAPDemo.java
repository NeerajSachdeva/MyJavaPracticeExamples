package collection;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMAPDemo {

	public static void main(String[] args) {
		NavigableMap original = new TreeMap();
		original.put(1.0, "1");
		original.put(11.0, "2");
		original.put(3.0, "3");
		original.put(4.0, "4");
		original.put(5.0, "5");
		original.put(6.0, "6");

		Object ceilingKey = original.ceilingKey(6.4);
		System.out.println(ceilingKey.toString());

		String key = "2.2";
		System.out.println(key.hashCode());
		Object floorKey = original.floorKey(2.2);
		System.out.println(floorKey.toString());
	}
}
