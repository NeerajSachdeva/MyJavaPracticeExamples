package my.custom.collection.impl;

import java.lang.reflect.Array;

interface Queue2<T> {
	void offer(T object);

	T poll();

	int size();

}

class Queue1Impl<T> implements Queue2<T> {
	private static int queueSize;
	private T[] nodeArray;
	private int index;

	public Queue1Impl(Class<T> clazz) {
		this(clazz, 3);
	}

	public Queue1Impl(Class<T> clazz, int size) {
		nodeArray = (T[]) Array.newInstance(clazz, size);
		queueSize = size;
	}

	@Override
	public void offer(T object) {
		if (index < queueSize) {
			nodeArray[index++] = object;
		} else {
			throw new RuntimeException("You need to pay for extra services");
		}
	}

	@Override
	public T poll() {
		if (queueSize == 0) {
			throw new RuntimeException("Give first then take it bro");
		} else {
			T obj = nodeArray[0];
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

public class MyQueue2 {

	public static void main(String[] args) {
		stringQueue1Example();
		charQueue1Example();
		integerQueue1Example();
	}

	private static void stringQueue1Example() {
		Queue2<String> myQueue1 = new Queue1Impl<>(String.class);
		myQueue1.offer("Neeraj");
		myQueue1.offer("Sachdeva");
		System.out.println("size " + myQueue1.size());
		System.out.println(myQueue1.poll());
		System.out.println(myQueue1.poll());
		System.out.println("size " + myQueue1.size());
	}

	private static void charQueue1Example() {
		Queue2<Character> myQueue1 = new Queue1Impl<>(Character.class);
		myQueue1.offer('n');
		myQueue1.offer('s');
		System.out.println(myQueue1.size());
		System.out.println(myQueue1.poll());
		System.out.println(myQueue1.poll());
	}

	private static void integerQueue1Example() {
		Queue2<Integer> myQueue1 = new Queue1Impl<>(Integer.class);
		myQueue1.offer(26);
		myQueue1.offer(4);
		System.out.println(myQueue1.size());
		System.out.println(myQueue1.poll());
		System.out.println(myQueue1.poll());
	}
}
