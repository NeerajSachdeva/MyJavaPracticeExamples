package problem.game.boggle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BoggleSolver {

	private final static String T = "TEST_PROGRAM";
	private final static String R = "RUN_PROGRAM";

	public static void main(String[] args) throws InterruptedException {
		long startTime = Calendar.getInstance().getTimeInMillis();

		Solver solver = getSolverObject(R); // you can pass T or R constant

		Set<String> resultSet = solver.solve();
		// printOutput(resultSet);
		// printOutputV2(resultSet);
		printOutputV3(resultSet);

		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n\n\n\nProgram Execution time: " + (endTime - startTime) / 1000);
		System.out.println("Total Word count: " + resultSet.size());
	}

	private static void printOutput(Set<String> outputSet) {
		List<String> output = new ArrayList<>(outputSet);
		Collections.sort(output, (o1, o2) -> Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length())));
		for (int i = 0; i < output.size() - 4; ++i) {
			System.out.println(output.get(i) + "                 " + output.get(++i) + "                 "
					+ output.get(++i) + "                 " + output.get(++i) + "                 " + output.get(++i));

		}
	}

	private static void printOutputV2(Set<String> outputSet) throws InterruptedException {
		List<String> output = new ArrayList<>(outputSet);
		Collections.sort(output, (o1, o2) -> Integer.valueOf(o2.length()).compareTo(Integer.valueOf(o1.length())));
		for (int i = 0; i < output.size() - 4; ++i) {
			System.out.println(output.get(i) + "                 " + output.get(++i) + "                 "
					+ output.get(++i) + "                 " + output.get(++i) + "                 " + output.get(++i));
			Thread.sleep(6000);

		}
	}

	private static void printOutputV3(Set<String> outputSet) throws InterruptedException {
		List<String> output = new ArrayList<>(outputSet);
		Collections.sort(output, Collections.reverseOrder());
		for (int i = 0; i < output.size() - 4; ++i) {
			System.out.println(output.get(i) + "                 " + output.get(++i) + "                 "
					+ output.get(++i) + "                 " + output.get(++i) + "                 " + output.get(++i));
			Thread.sleep(6000);

		}
	}

	private static Solver getSolverObject(String type) {
		Solver solver = null;
		switch (type) {
		case T:
			final String INPUT = "SZFVDLSUSEAOWIGL";
			solver = new Solver(4, INPUT);
			break;
		case R:
			Scanner scanner = new Scanner(System.in);
			solver = new Solver(4, scanner.nextLine());
			break;
		}
		return solver;
	}
}
