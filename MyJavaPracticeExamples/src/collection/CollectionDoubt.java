package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CollectionDoubt {

	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		// hashSet.add(null);
		System.out.println(hashSet.add(null));
		System.out.println(hashSet.add(null));
		System.out.println(hashSet.size());
		// Collections.sort(hashSet);

		// Special about this line is, queue is parent of linkedlist
		Queue<Emp> emps = new LinkedList<>();

		HashMap<String, String> map = new HashMap<>();
		map.put("1", "ok1");
		map.put("2", "ok2");
		map.put(null, "ok3");
		map.put(null, "ok4");
		System.out.println(map.get(null));
	}

	class Emp {

	}
}
