package java8.functional.interfaces.testing;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTesting {

	public static void main(String args[]) {
		functionTesting();
		biFunctionTesting();
	}

	private static void biFunctionTesting() {
		Function<String, Integer> f1 = String::length;// x -> x.length();
		int length = f1.apply("hello world");
		System.out.println(length);

	}

	private static void functionTesting() {
		BiFunction<String, String, String> concatFunc = String::concat;// (str1, str2) -> str1.concat(str2);

		String newString = concatFunc.apply("hello", "world");
		System.out.println(newString);
	}
}
