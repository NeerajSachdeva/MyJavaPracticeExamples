
public class Anagram {
	public static void main(String[] args) {
		String str1 = "war";
		String str2 = "raw";

		if (str1.length() == str2.length()) {
			char ch1[] = str1.toCharArray();
			char ch2[] = str2.toCharArray();

			int size1 = 0, size2 = 0;
			for (int i = 0; i < ch1.length; i++) {
				size1 += ch1[i];
				size2 += ch2[i];
			}
			if (size1 == size2) {
				System.out.println("pass");
			} else {
				System.out.println("Not anagram");
			}
		} else {
			System.out.println("size mismatch");
		}
	}
}
