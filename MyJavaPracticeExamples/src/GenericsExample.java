import java.util.Arrays;
import java.util.List;

public class GenericsExample {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2);
		List<? extends Number> l2 = Arrays.asList(3, 4);
		List<Number> l3 = Arrays.asList(5, 6);
		// l1 = l2;
		l2 = l1;
		// l3.addAll(l1);
		l2.stream().forEach(System.out::println);
	}

}
