package java8.lambda.expressions;

public class LambdaTesting {

	public static void main(String[] args) {
		new Elephant().playAll(true);
	}

}

class Elephant {
	String walk = "walk";

	void playAll(boolean isBaby) {
		String approach = "slow walk";
		// isBaby = false;
		// walk = "abc";
		// approach = "run"; cannot use this in lambda expression as approach
		// will not be effectively final

		play(() -> walk);
		play(() -> approach);
		play(() -> isBaby ? approach : "run");
	}

	void play(Animal a) {
		a.move();
	}
}

interface Animal {
	String move();
}
