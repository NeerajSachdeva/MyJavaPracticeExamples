package collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMap_Demo {

	private static Map map;

	public static void main(String args[]) {
		map = new WeakHashMap();

		final String key = new String("Maine");
		map.put(key, "Augusta");

		Runnable runner = new Runnable() {

			@Override
			public void run() {
				String key1 = key;
				while (!key1.equals("Maine5555")) {
					try {
						System.out.println("Going to sleep");
						Thread.sleep(500);
						key1 += "5";
					} catch (InterruptedException ignored) {
					}
					System.out.println("Thread waiting");
					System.gc();
					System.out.println(map.size());
				}
			}
		};

		Thread t = new Thread(runner);
		t.start();

		System.out.println("Main waiting");
		System.out.println(map.size());

		try {
			t.join();
		} catch (InterruptedException ignored) {
		}
	}
}
