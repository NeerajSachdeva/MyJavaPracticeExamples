package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(1, 2, 3, 5, 6);

		Stream<Integer> s1 = l.stream();
		Stream<Integer> s2 = s1.map(a -> a + 3);
		s2.forEach(System.out::println);

		s1.forEach(System.out::println);

	}

}
