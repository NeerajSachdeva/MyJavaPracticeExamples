package practice.thread;

import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author neerajsachdeva In ThreadPractice1, we managed printing 1-10 using a templist and checking whether last no. was odd then print
 *         even & vice versa. Basically we needed a "templist" to solve this problem of printing 1-10
 *
 *         Queues help us in keeping this sync of producer and consumer. if producer has produced something only then consumer can pick
 *         something is handled without any additional temp variable.
 *
 *
 *
 *         **** The SynchronousQueue is a queue that can only contain a single element internally.****
 */
public class SynchronousQueuePractice {

	public static void main(String args[]) {
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		// start producer thread
		new Thread(new QueueProducer(queue)).start();
		// start consumer thread
		new Thread(new QueueConsumer(queue)).start();
	}
}

class QueueProducer implements Runnable {

	private SynchronousQueue<String> queue;

	public QueueProducer(SynchronousQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String event = String.valueOf(Math.random());
				queue.put(event);
				System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class QueueConsumer implements Runnable {

	private SynchronousQueue<String> queue;

	public QueueConsumer(SynchronousQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			String event = queue.poll();
			// thread will block here until producer adds something to queue
			System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
