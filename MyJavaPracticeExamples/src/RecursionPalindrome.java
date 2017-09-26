import java.util.Scanner;

public class RecursionPalindrome {

	public static void main(String[] args) {

		// System.out.println(palin(NIT1TIN));

		Scanner scanner = new Scanner(System.in);
		System.out.println(palin(scanner.next()));

	}

	static boolean palin(String input) {
		if (input.length() < 2) {
			return true;
		}
		return input.substring(0, 1).equalsIgnoreCase(input.substring(input.length() - 1))
				&& palin(input.substring(1, input.length() - 1));
	}

}
