
public class NonRepeatableCharacter2 {

	public static void main(String[] args) {
		String str = "NeerajN";

		char[] ch = str.toCharArray();

		int indexFound = -1;
		for (int j = 0; j < ch.length; j++) {
			for (int i = j + 1; i < ch.length; i++) {
				if (ch[j] == ' ') {
					break;
				}
				if (ch[j] == ch[i]) {
					ch[i] = ' ';
					break;
				}

				if (i == ch.length - 1 && ch[j] != ' ') {
					indexFound = j;
					break;
				}
			}
			if (indexFound != -1)
				break;
		}
		if (indexFound != -1) {
			System.out.println("Result " + ch[indexFound]);
		}
	}
}
