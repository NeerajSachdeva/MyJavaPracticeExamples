package my.custom.collection.impl;

interface Queue<T> {
	void offer(T object);

	T poll();

	int size();

}

class MyQueueNode<T> {
	T obj;

	public MyQueueNode(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}

class QueueImpl<T> implements Queue<T> {
	private static int queueSize;
	private MyQueueNode<T>[] nodeArray;
	private int index;

	public QueueImpl() {
		queueSize = 3;
		nodeArray = new MyQueueNode[queueSize];
	}

	public QueueImpl(int size) {
		queueSize = size;
	}

	@Override
	public void offer(T object) {
		if (index < queueSize) {
			nodeArray[index++] = new MyQueueNode(object);
		} else {
			throw new RuntimeException("You need to pay for extra services");
		}
	}

	@Override
	public T poll() {
		if (queueSize == 0) {
			throw new RuntimeException("Give first then take it bro");
		} else {
			T obj = nodeArray[0].getObj();
			adjustContainer();
			return obj;
		}
	}

	@Override
	public int size() {
		return index;
	}

	private void adjustContainer() {
		for (int i = 1; i < index; i++) {
			nodeArray[i - 1] = nodeArray[i];
		}
		--index;

		for (int i = index; i < nodeArray.length; i++) {
			nodeArray[i] = null;
		}
	}

}

public class MyQueue {

	public static void main(String[] args) {
		stringQueueExample();
		// charQueueExample();
		// integerQueueExample();
	}

	private static void stringQueueExample() {
		Queue<String> myQueue = new QueueImpl<>();
		myQueue.offer("Neeraj");
		myQueue.offer("Sachdeva");
		System.out.println("size " + myQueue.size());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		System.out.println("size " + myQueue.size());
	}

	private static void charQueueExample() {
		Queue<Character> myQueue = new QueueImpl<>();
		myQueue.offer('n');
		myQueue.offer('s');
		System.out.println(myQueue.size());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
	}

	private static void integerQueueExample() {
		Queue<Integer> myQueue = new QueueImpl<>();
		myQueue.offer(26);
		myQueue.offer(4);
		System.out.println(myQueue.size());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
	}
}
