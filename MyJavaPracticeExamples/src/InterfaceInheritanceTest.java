import java.util.ArrayList;
import java.util.List;

interface A {

	void callMe();
}

interface B {

	default void callMe() {
		System.out.println("B");
	}
}

class C implements A, B {

	@Override
	public void callMe() {
		System.out.println("A B call me");
	}

}

public class InterfaceInheritanceTest {

	public static void main(String[] args) {
		A a = new C();
		B b = new C();
		C c = new C();
		a.callMe();
		b.callMe();

		List<A> l1 = new ArrayList<>();
		List<B> l2 = new ArrayList<>();
		List<C> l3 = new ArrayList<>();

		l1.add(c);
		l3.add((C) a);

		List<? extends Number> number = new ArrayList<>();
		List<Integer> integer = new ArrayList<>();
		number = integer;

	}
}
