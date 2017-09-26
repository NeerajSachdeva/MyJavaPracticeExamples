package java8.functional.interfaces.testing;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTesting {

	public static void main(String[] args) {
		consumerTest();
		biConsumerTest();
	}

	private static void biConsumerTest() {
		Map<Integer, String> map = new HashMap<>();
		BiConsumer<Integer, String> bi = (key, value) -> map.put(key, value);
	//	BiConsumer<Integer, String> printMap = (key, value) -> System.out.println("key :" + key + "  value :" + value);
	//	Consumer<Map.Entry<Integer, String>> printMapEntries = (entry) -> System.out
		//		.println("key :" + entry.getKey() + "  value :" + entry.getValue());

		bi.accept(20, "Michael");
		bi.accept(30, "Jackson");

		System.out.println(map);
		bi.accept(40, "Dance");
	//	map.forEach(printMap);
	//	map.entrySet().forEach(printMapEntries);
		// forEach takes consumer
		map.entrySet().forEach((entry) -> System.out.println("key :" + entry.getKey() + "  value :" + entry.getValue()));
	}

	private static void consumerTest() {
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);

		c1.accept("hello");
		c2.accept("JAVA 8");
		c1.accept("consumers....");
	}

}
