
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OrderByValue {

	public static void main(String a[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Unix", 67);
		map.put("MAC", 26);
		map.put("Why this kolavari", 93);

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

		Collections.sort(entryList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		entryList.stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		// entryList = entryList.stream().filter(e -> e.getValue() > 45).collect(Collectors.toList());

		Collections.sort(entryList, (o2, o1) -> o1.getValue().compareTo(o2.getValue()));
		entryList.stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

	}
}