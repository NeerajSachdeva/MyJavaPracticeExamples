package practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPractice4 {

	public static void main(String[] args) throws InterruptedException {
		PrintNumbersss pn = new PrintNumbersss();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(() -> {
			try {
				pn.printEven();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		Future<Integer> future = executorService.submit(() -> {
			try {
				pn.printOdd();
				return 26;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		executorService.shutdown();
		System.out.println("List:" + pn.getTempList());
	}
}

class PrintNumbersss {

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
				Thread.sleep(100);
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
				Thread.sleep(100);
			}
		}
	}

}
