import java.util.HashMap;
import java.util.Map;

public class NonRepeatableCharacter3 {

	public static void main(String[] args) {
		String str = "NeerajN";

		Map<Object, Object> map = new HashMap<>();

		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			Object object = map.get(ch[i]);
			if (object == null) {
				map.put(ch[i], " ");
			} else {
				map.remove(ch[i]);
			}
		}

		for (Object o : map.keySet()) {
			System.out.println(o);
			break;
		}

	}
}
