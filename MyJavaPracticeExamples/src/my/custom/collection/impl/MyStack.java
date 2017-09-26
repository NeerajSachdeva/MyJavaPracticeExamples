package my.custom.collection.impl;

interface Stack<T> {
	void push(T object);

	T pop();

	int size();

}

class MyNode<T> {
	T obj;

	public MyNode(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}

class StackImpl<T> implements Stack<T> {
	private static int queueSize;
	private MyNode<T>[] nodeArray;
	private int index;

	public StackImpl() {
		queueSize = 3;
		nodeArray = new MyNode[queueSize];
	}

	public StackImpl(int size) {
		queueSize = size;
	}

	@Override
	public void push(T object) {
		if (index < queueSize) {
			nodeArray[index++] = new MyNode(object);
		} else {
			throw new RuntimeException("You need to pay for extra services");
		}
	}

	@Override
	public T pop() {
		if (index == 0) {
			throw new RuntimeException("Give first then take it bro");
		} else {
			T obj = nodeArray[index - 1].getObj();
			nodeArray[nodeArray.length - 1] = null;
			--index;
			return obj;
		}
	}

	@Override
	public int size() {
		return index;
	}

}

public class MyStack {

	public static void main(String[] args) {
		Stack<String> myStack = new StackImpl<>();
		myStack.push("Neeraj");
		myStack.push("Sachdeva");
		System.out.println(myStack.size());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}
