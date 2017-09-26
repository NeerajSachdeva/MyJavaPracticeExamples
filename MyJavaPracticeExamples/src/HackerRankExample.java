
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
// import for Scanner and other utility classes
import java.util.Scanner;

class HackerRankExample {

	private static String DivideBy15 = "FizzBuzz";
	private static String DivideBy3 = "Fizz";
	private static String DivideBy5 = "Buzz";

	public static void main(String args[]) throws Exception {

		// Read input from stdin and provide input before running
		// Use either of these methods for input

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		// Scanner

		Scanner s = new Scanner(br.readLine());
		for (int j = 0; j < N; j++) {
			int range = s.nextInt();
			
			for (int i = 1; i <= range; i++) {
				if (i % 15 == 0) {
					System.out.println(DivideBy15);
				} else if (i % 3 == 0) {
					System.out.println(DivideBy3);
				} else if (i % 5 == 0) {
					System.out.println(DivideBy5);
				} else {
					System.out.println(i);
				}
			}
		}

	}
}
