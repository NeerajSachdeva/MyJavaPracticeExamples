package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ReferenceType {
	public static void main(String[] args) {
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);

		// static method reference
		cars.forEach(Car::collide);

		// method reference
		cars.forEach(Car::repair);
		// cars.forEach(Car::repair2);

		// constructor reference
		final Car police = Car.create(Car::new);

		// object reference
		cars.forEach(police::follow);

	}

	private static class Car {
		public static Car create(final Supplier<Car> supplier) {
			return supplier.get();
		}

		public static void collide(final Car car) {
			System.out.println("Collided " + car.toString());
		}

		public void follow(final Car another) {
			System.out.println("Following the " + another.toString());
		}

		public void repair() {
			System.out.println("Repaired " + this.toString());
		}

		public void repair2(Car car) {
			System.out.println("Repaired ");
		}
	}
}
