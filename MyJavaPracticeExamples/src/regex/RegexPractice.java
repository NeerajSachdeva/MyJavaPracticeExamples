package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {

		String pattern = "^[0-9A-Fa-f]+$";

		Pattern pattern2 = Pattern.compile(pattern);

		String input = "312";
		Matcher matcher = pattern2.matcher(input);

		if (matcher.find()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
}
