import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NonRepeatableCharacter {

	public static void main(String[] args) {
		String str = "NeerajN";

		List<Character> list = new ArrayList<>();

		char[] ch = str.toCharArray();

		Consumer<Character> consumer = x -> {
			if (!list.contains(x)) {
				list.add(x);
			} else {
				list.remove(x);
			}
		};

		for (int i = 0; i < ch.length; i++) {
			consumer.accept(ch[i]);
		}

		System.out.println(list.get(0));

	}
}
