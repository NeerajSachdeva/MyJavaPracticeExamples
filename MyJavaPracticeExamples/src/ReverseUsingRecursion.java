
public class ReverseUsingRecursion {

	public static void main(String[] args) {
		System.out.println(new ReverseUsingRecursion().reverse("Neeraj"));
	}

	String reverseOutput = "";

	private String reverse(String input) {
		if (input.length() == 1) {
			return input;

		} else {
			reverseOutput += input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
		}
		return reverseOutput;
	}

}
