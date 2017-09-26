package classloader;

public class SingletonClass {
	private static SingletonClass INSTANCE;

	private SingletonClass() {

	}

	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
			System.out.println("Instance created " + INSTANCE.toString());
		}
		return INSTANCE;
	}

}
