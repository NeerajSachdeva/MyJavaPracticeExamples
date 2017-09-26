package problem.game.boggle;

import java.util.HashSet;
import java.util.Set;

public class Solver {
	private char[] puzzle;
	private int maxSize;

	private boolean[] used;
	private StringBuilder stringSoFar;

	private boolean[][] matrix;
	private Trie trie;
	private Set<String> outputList = new HashSet<>();

	public Solver(int size, String puzzle) {
		puzzle = puzzle.toUpperCase();
		trie = Util.getTrie(size);
		matrix = Util.connectivityMatrix(size);

		maxSize = size * size;
		stringSoFar = new StringBuilder(maxSize);
		used = new boolean[maxSize];

		if (puzzle.length() == maxSize) {
			this.puzzle = puzzle.toCharArray();
		} else {
			System.out.println("The puzzle size does not match the size specified: " + puzzle.length());
			this.puzzle = puzzle.substring(0, maxSize).toCharArray();
		}
	}

	public Set<String> solve() {
		for (int i = 0; i < maxSize; i++) {
			traverseAt(i);
		}
		return outputList;
	}

	private void traverseAt(int origin) {
		stringSoFar.append(puzzle[origin]);
		used[origin] = true;

		// Check if we have a valid word
		if ((stringSoFar.length() >= Constants.MINIMUM_WORD_LENGTH) && (trie.containKey(stringSoFar.toString()))) {
			// System.out.println(" Found: " + stringSoFar.toString());
			outputList.add(stringSoFar.toString());
		}

		// Find where to go next
		for (int destination = 0; destination < maxSize; destination++) {
			if (matrix[origin][destination] && !used[destination]
					&& trie.containPrefix(stringSoFar.toString() + puzzle[destination])) {
				traverseAt(destination);
			}
		}

		used[origin] = false;
		stringSoFar.deleteCharAt(stringSoFar.length() - 1);
	}

	public Set<String> getOutputList() {
		return outputList;
	}

}