package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseProblem {

	public static void main(String[] args) {
		String line = "newWorldExampleYouRock";

		String pattern = "[A-Z]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		int count = 0;
		while (m.find()) {
			++count;
		}

		System.out.println(count + 1);
	}

}
