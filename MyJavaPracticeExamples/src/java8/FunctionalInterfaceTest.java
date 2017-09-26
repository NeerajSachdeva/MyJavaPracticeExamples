package java8;

@FunctionalInterface
public interface FirstInterface {
	void a();

	void b();
}

@FunctionalInterface
interface SecondInterface extends FirstInterface {

	void c();
}

class FunctionalInterfaceTest {
	public static void main(String[] args) {
		// SecondInterface sc = () -> System.out.print("a");

		Runnable r = () -> System.out.print("a");
	}
}