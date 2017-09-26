package com.naval.java.core.advanced.multithreading;

class ResourceCounter {
	private Integer count;

	public ResourceCounter(int count) {
		this.count = count;
	}

	// public synchronized void incr() {
	public void incr() {
		int temp;
		// synchronized (ResourseCounter.class) {
		synchronized (this) {
			temp = count;
			temp = temp + 1;
			count = temp;
		}
	}

	public void decr() {
		int temp = count;
		temp = temp - 1;
		count = temp;
	}

	public int getCount() {
		return count;
	}
}