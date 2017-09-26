package java8.functional.interfaces.testing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTesting {

	public static void main(String[] args) {
		printDate();
		printList();
		// ----->>
	}

	private static void printList() {
		Supplier<ArrayList<String>> listSupplier = ArrayList::new; // constructor references
		Supplier<ArrayList<String>> listSupplier1 = () -> new ArrayList<>(); // equivalent lambda expression
		
		ArrayList<String> list = listSupplier.get();
		list.add("A");
		list.add("B");
		System.out.println(list);
		System.out.println(listSupplier1.get().add("list2"));
	}

	private static void printDate() {
		Supplier<LocalDate> s1 = LocalDate::now; // static method references
		Supplier<LocalDate> s2 = () -> LocalDate.now(); // equivalent lambda
														// expression

		System.out.println(s1.get());
		System.out.println(s2.get());
	}
}
