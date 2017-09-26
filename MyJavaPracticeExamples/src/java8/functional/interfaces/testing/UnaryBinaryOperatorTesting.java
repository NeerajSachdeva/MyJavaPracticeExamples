package java8.functional.interfaces.testing;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperatorTesting {

	public static void main(String[] args) {
		UnaryOperator<String> upperCase = String::toUpperCase;
		System.out.println(upperCase.apply("console log"));

		BinaryOperator<Integer> sum = Integer::sum;// similarly for string concat
		System.out.println(sum.apply(20, 30));
	}
}
