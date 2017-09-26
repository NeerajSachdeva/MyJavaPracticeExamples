import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class WordSwipe2 {

	private static final String DICTIONARY_FILE_PATH = "D:/Personal_Project/my_personal_workspace/Words.txt";
	private static final List<String> WORDS_DICTIONARY = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		createWordsDictionary();
		// System.out.println("WORDS_DICTIONARY size" + WORDS_DICTIONARY.size());

		Scanner sc = new Scanner(System.in);
		String letters = sc.nextLine();

		CountDownLatch latch = new CountDownLatch(2);
		// Combinations combobj = new Combinations(letters);

		// Combinations combobjReverse = new Combinations(new StringBuilder(letters).reverse().toString());

		Combinations2 combobj = new Combinations2(letters);
		Combinations2 combobjReverse = new Combinations2(new StringBuilder(letters).reverse().toString());
		Thread t1 = new Thread(() -> {
			combobj.combine();
			latch.countDown();
		});
		Thread t2 = new Thread(() -> {
			combobjReverse.combine();
			latch.countDown();
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		// combobj.combine();
		// combobjReverse.combine();

		// if (latch.await(0, TimeUnit.SECONDS)) {

		Collection<String> finalCombinations = combobj.getMyCharactersCombinations();
		finalCombinations.addAll(combobjReverse.getMyCharactersCombinations());
		// System.out.println("finalCombinations size" + finalCombinations.size());

		List<String> list = finalCombinations.stream().parallel().filter(e -> e.length() >= 3)
				.filter(e -> WORDS_DICTIONARY.contains(e)).collect(Collectors.toList());

		Collections.sort(list);
		list.forEach(System.out::println);
		// }

	}

	private static List<String> createWordsDictionary() throws FileNotFoundException, IOException {
		String line;
		try (InputStream fis = new FileInputStream(DICTIONARY_FILE_PATH);
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				WORDS_DICTIONARY.add(line);
			}
		}

		// WORDS_DICTIONARY.forEach(System.out::println);
		return WORDS_DICTIONARY;
	}
}

class Combinations2 {
	private StringBuilder output = new StringBuilder();
	private final String inputstring;
	Collection<String> myCharactersCombinations = new HashSet<>();

	public Combinations2(final String str) {
		inputstring = str;
		// System.out.println("The input string is : " + inputstring);
	}

	public void combine() {
		combine(0);
	}

	private void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			myCharactersCombinations.add(output.toString());
			if (i < inputstring.length())
				combine(i + 1);
			output.setLength(output.length() - 1);
		}
	}

	public Collection<String> getMyCharactersCombinations() {
		return myCharactersCombinations;
	}

}