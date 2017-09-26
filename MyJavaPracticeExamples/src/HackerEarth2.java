/* IMPORTANT: Multiple classes and nested static classes are supported */

// import for Scanner and other utility classes
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HackerEarth2 {

	public static void main(String args[]) throws Exception {
		/*
		 * Please provide input "Provide custom input" link below,
		 * which will be stdin.
		 *
		 * Sample optional helper code has been provided below only
		 * for parsing the input.
		 */

		// Read input
		Scanner sc = new Scanner(System.in);
		// Read the first line.
		int N = Integer.valueOf(sc.nextLine());

		// Iterate over the next lines

		// Iterate over the next lines
		int i = 1;
		String line;
		Map<String, String> map = new HashMap<>();
		int count = 0;
		while (sc.hasNext() && i < N) {
			i++;
			line = sc.nextLine();
			String[] lineArray = line.split("\\s+");
			
			if(lineArray.length ==2){
			if (map.containsKey(lineArray[1]) && !map.get(lineArray[1]).equals(lineArray[0])) {
				++count;
			}
			map.put(lineArray[1], lineArray[0]);
			}
		}
		System.out.println(count);

	}
}
