
// package whatever; // don't place package name!

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class myCode {
	public static void main(String[] args) throws java.lang.Exception {

		/*
		 * Correct output:
		 *
		 * 1.1 will occur 2 time(s). 3.3 will occur 1 time(s). 1.0 will occur 1 time(s). 4.0 will occur 1 time(s). 5.1 will occur 1 time(s).
		 * 3.2 will occur 2 time(s). 6.2 will occur 1 time(s). 4.1 will occur 1 time(s). 5.5 will occur 1 time(s). 3.7 will occur 1 time(s).
		 * 7.1 will occur 1 time(s). 3.9 will occur 1 time(s). 4.2 will occur 1 time(s). 1 will occur 2 time(s). 2 will occur 1 time(s). 3
		 * will occur 4 time(s). 4 will occur 3 time(s). 5 will occur 2 time(s). 6 will occur 1 time(s). 7 will occur 1 time(s). 8 will
		 * occur 1 time(s). test1 test1 will occur 2 time(s). test2 test2 will occur 1 time(s).
		 *
		 *
		 */

		CountIt<Double> counter = new CountIt<Double>();
		Map<Double, Integer> map = counter
				.getCount(new Double[] { 1.1, 1.1, 3.2, 4.1, 3.7, 3.3, 5.1, 7.1, 3.2, 1.0, 4.0, 5.5, 6.2, 4.2, 3.9 });
		for (Double key : map.keySet()) {
			int occurrence = map.get(key);
			System.out.println(key + " will occur " + occurrence + " time(s).");
		}

		CountIt<Integer> counter2 = new CountIt<Integer>();
		Map<Integer, Integer> map2 = counter2.getCount(new Integer[] { 1, 8, 3, 4, 3, 2, 5, 7, 3, 1, 4, 5, 6, 4, 3 });
		for (Integer key : map2.keySet()) {
			int occurrence = map2.get(key);
			System.out.println(key + " will occur " + occurrence + " time(s).");
		}

		CountIt<Person> counter3 = new CountIt<Person>();
		Person p1 = new Person("test1", "test1");
		Person p2 = new Person("test2", "test2");
		Person p3 = new Person("test1", "test1");

		Map<Person, Integer> map3 = counter3.getCount(new Person[] { p1, p2, p3 });
		for (Person key : map3.keySet()) {
			int occurrence = map3.get(key);
			System.out.println(key + " Person will occur " + occurrence + " time(s).");
		}

	}

}

class Person {
	public String firstName;
	public String lastName;

	public Person(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null)
			return false;

		if (getClass() != o.getClass())
			return false;

		Person p = (Person) o;
		return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName);
	}

}

// generic class CountIt with a getCount method
class CountIt<T> {

	public Map<T, Integer> getCount(T[] array) {
		Map<T, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			Integer value = map.get(array[i]);
			if (value != null) {
				map.put(array[i], ++value);
			} else {
				map.put(array[i], 1);
			}
		}

		System.out.println("Map size: " + map);

		return map;
	}

}