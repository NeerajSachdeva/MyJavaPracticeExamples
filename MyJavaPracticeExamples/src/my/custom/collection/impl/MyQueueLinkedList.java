package my.custom.collection.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueueLinkedList {
	public static void main(String[] args) {
		QueueLinkedList<String> myQ = new QueueLinkedList();
		myQ.enqueue("a");
	}
}

class QueueLinkedList<T> implements Queue<T> {

	private int total;

	private Node first, last;

	private class Node {
		private T ele;
		private Node next;
	}

	public QueueLinkedList() {
	}

	public QueueLinkedList<T> enqueue(T ele) {
		Node current = last;
		last = new Node();
		last.ele = ele;

		if (total++ == 0)
			first = last;
		else
			current.next = last;

		return this;
	}

	public T dequeue() {
		if (total == 0)
			throw new java.util.NoSuchElementException();
		T ele = first.ele;
		first = first.next;
		if (--total == 0)
			last = null;
		return ele;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = first;
		while (tmp != null) {
			sb.append(tmp.ele).append(", ");
			tmp = tmp.next;
		}
		return sb.toString();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
