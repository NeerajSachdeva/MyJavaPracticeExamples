package java8;

import java.util.Optional;

public class OptionalPractice {

	public static void main(String[] args) {
		String obj = null;

		Optional<String> str = Optional.ofNullable(obj);

		System.out.println(str.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

		Object obj2 = "abs";

		Optional<Object> objectOptional = Optional.ofNullable(obj2);

		System.out.println(objectOptional.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

	}

}
