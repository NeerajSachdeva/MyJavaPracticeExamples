
public class AsciiToHexa {

	public static void main(String[] args) {
		char c = '€';
		String hexaValue = String.format("%H", c);
		System.out.println("ascii to hexa: " + hexaValue);
		System.out.println("hexa to ascii" + (char) (Integer.parseInt(hexaValue, 16)));

		String character = "20";
		System.out.println("ascii" + (char) (Integer.parseInt(character, 16)));
	}
}