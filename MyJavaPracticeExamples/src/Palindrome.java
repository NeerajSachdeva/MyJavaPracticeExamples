/* IMPORTANT: Multiple classes and nested static classes are supported */

// uncomment this if you want to read input.
// imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
// import for Scanner and other utility classes
import java.util.ArrayList;
import java.util.List;

class Palindrome {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		try {
			ArrayList<ArrayList<String>> partition = new Palindrome().partition(line.toUpperCase());
			partition.forEach(System.out::println);
			int size = partition.size();
			System.out.println(size);
		} catch (Exception e) {
			System.out.println(0);
		}
	}

	private ArrayList<ArrayList<String>> partition(String input) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (input == null || input.isEmpty()) {
			return result;
		}

		List<String> partition = new ArrayList<String>();
		addPalindrome(input, 0, partition, result);

		return result;
	}

	private void addPalindrome(String input, int start, List<String> partition, ArrayList<ArrayList<String>> result) {
		// terminal condition
		if (start == input.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}

		for (int index = start + 1; index <= input.length(); index++) {
			String str = input.substring(start, index);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(input, index, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
