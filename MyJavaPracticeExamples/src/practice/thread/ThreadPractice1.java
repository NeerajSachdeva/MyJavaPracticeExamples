package practice.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neerajsachdeva
 *
 */
public class ThreadPractice1 {

	public static void main(String[] args) throws InterruptedException {
		PrintNumbers pn = new PrintNumbers();

		Thread t1 = new Thread(() -> {
			try {
				pn.printEven();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				pn.printOdd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println(pn.getTempList());
	}
}

class PrintNumbers {

	final int printTill = 10;
	List<Integer> tempList = new ArrayList<>(printTill);

	public List<Integer> getTempList() {
		return tempList;
	}

	void printOdd() throws InterruptedException {
		synchronized (this) {
			for (int i = 1; i <= printTill;) {
				if (!tempList.isEmpty() && tempList.get(tempList.size() - 1) % 2 != 0) {
					System.out.println("odd waiting");
					wait();
				}
				System.out.println(i);
				tempList.add(i);
				i += 2;
				notify();
				// Thread.sleep(100);
			}
		}
	}

	void printEven() throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i <= printTill;) {
				if (!tempList.isEmpty() && tempList.get(tempList.size() - 1) % 2 == 0) {
					System.out.println("even waiting");
					wait();
				}
				System.out.println(i);
				tempList.add(i);
				i += 2;
				notify();
				// Thread.sleep(100);
			}
		}
	}

}
