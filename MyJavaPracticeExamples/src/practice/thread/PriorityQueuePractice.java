package practice.thread;

import java.util.PriorityQueue;

/**
 * The PriorityQueue is like other collections as in, it is unbounded and we can specify the starting size. Also, it is not threadsafe in a
 * multi-threaded environment. Returns element on the basis of comparator
 *
 * @author neerajsachdeva
 *
 */
public class PriorityQueuePractice {

	public static void main(String[] args) {

		PriorityQueue<Request> queueExample = new PriorityQueue<>();

		queueExample.offer(new Request("ABC", 2));
		queueExample.offer(new Request("ABC", 5));
		queueExample.offer(new Request("ABC", 1));

		while (!queueExample.isEmpty()) {
			System.out.println(queueExample.poll());
		}
		System.out.println(queueExample.comparator());

	}

}

class Request implements Comparable<Request> {

	private String requestName = "";

	private int priorityStatus = 0;

	/**
	 * @param requestName
	 * @param priorityStatus
	 */
	public Request(String requestName, int priorityStatus) {
		this.requestName = requestName;
		this.priorityStatus = priorityStatus;
	}

	@Override
	public int compareTo(Request otherRequest) {
		return Integer.compare(priorityStatus, otherRequest.priorityStatus);
	}

	@Override
	public String toString() {
		return "Request [requestName= " + requestName + ", priorityStatus=" + priorityStatus + "]";
	}

}