import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YogitaAddressProblem {

	public static void main(String[] args) {
		List<String> addresses = new LinkedList<>();// Arrays.asList("Sector 18 ,12 UdyogVihar 371", "Something, 2 nice",
													// "somemoreinput 2" , "200 broadway" ,"200, avenue" ,"avenue 40,30"
													// );
		addresses.add("Winterallee 3");
		addresses.add("Am Bächle 23");
		addresses.add("Auf der Vogelwiese 23 b");
		addresses.add("4, rue de la revolution");
		addresses.add("200 Broadway Av");
		addresses.add("Calle Aduana, 29");
		addresses.add("Calle 39 No 1540");
		addresses.add("avenue 3, 2b");
		addresses.add("Blaufeldweg 11 123B");

		List<String> outputList = new YogitaAddressProblem().parseAddress(addresses);
		// outputList.forEach(str -> System.out.println(str));

//		for (int i = 0; i < addresses.size(); i++) {
//			System.out.println(addresses.get(i) + " -> " + outputList.get(i));
//		}
	}

	List<String> parseAddress(List<String> addresses) {
		List<String> resultList = new LinkedList<>();
		Pattern p = Pattern.compile("\\d+");

		Iterator<String> iterator = addresses.iterator();
		while (iterator.hasNext()) {
			String address = iterator.next();

			System.out.print(address + "  ->  ");
			
			if (address.indexOf(",") != -1) {
				LinkedList<String> numbers = getNumbers(p, address);
				String e;
				if (address.indexOf(numbers.get(0)) == 0) {
					e = address.substring(address.indexOf(",") + 1) + ", " + address.substring(0, address.indexOf(","));
				} else {
					e = address.substring(0, address.indexOf(",")) + ", " + address.substring(address.indexOf(",") + 1);
				}
				resultList.add(e);
				System.out.println(e);

			} else {

				LinkedList<String> numbers = getNumbers(p, address);

				if (!numbers.isEmpty()) {
					if (numbers.size() == 1) {
						// 200 Broadway Av
						if (address.indexOf(numbers.get(0)) == 0) {
							String first = address.substring(0, numbers.get(0).length()).trim();
							String second = address.substring(numbers.get(0).length() + 1).trim();
							resultList.add(second + ", " + first);
							System.out.println(second + ", " + first);
						} else {
							// Calle Aduana, 29
							int indexOfNumber = address.indexOf(numbers.get(0));
							String first = address.substring(0, indexOfNumber).trim();
							String second = address.substring(indexOfNumber).trim();
							resultList.add(first + ", " + second);
							System.out.println(first + ", " + second);
						}
					} else if (numbers.size() == 2) {
						// Calle 39 No 1540
						int indexOfFirstNumber = address.indexOf(numbers.get(0));
						String first = address.substring(0, indexOfFirstNumber + numbers.get(0).length()).trim();
						String second = address.substring(indexOfFirstNumber + numbers.get(1).length()-1).trim();
						resultList.add(first + ", " + second);
						System.out.println(first + ", " + second);
					}
				}
			}
		}
		return resultList;
	}

	private LinkedList<String> getNumbers(Pattern p, String address) {
		Matcher m = p.matcher(address);
		LinkedList<String> numbers = new LinkedList<String>();
		while (m.find()) {
			numbers.add(m.group());
		}
		return numbers;
	}
}
