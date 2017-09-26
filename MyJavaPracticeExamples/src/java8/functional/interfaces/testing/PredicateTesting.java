package java8.functional.interfaces.testing;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTesting {

	public static void main(String[] args) {
		predicateTesting();
		biPredicateTesting();
	}

	private static void biPredicateTesting() {
		BiPredicate<String, String> startsWithPredicate = String::startsWith;
		BiPredicate<String, String> startsWithPredicate1 = (string, prefix) -> string.startsWith(prefix);
		System.out.println(startsWithPredicate.test("Predicate", "Pre"));
		System.out.println(startsWithPredicate1.test("Predicate", "kre"));
	}

	private static void predicateTesting() {
		Predicate<String> emptyString = String::isEmpty;
		System.out.println(emptyString.test(""));
		System.out.println(emptyString.test("testing"));
	}
}
