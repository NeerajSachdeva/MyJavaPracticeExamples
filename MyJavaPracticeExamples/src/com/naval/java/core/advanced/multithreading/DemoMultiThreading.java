package com.naval.java.core.advanced.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoMultiThreading {

	public static void main(String[] args) {
		final List<String> countries = Arrays.asList("Angola", "Australia", "Austria", "Azerbaizan", "Bangladesh",
				"Bhutan", "Brazil", "Brunai", "Cambodia", "Canada", "Canary Islands", "China", "Czech Republic",
				"Denmark", "Dominica", "Estonia", "Finland", "France", "Germany", "Guatemala", "Hungary", "Iceland",
				"India", "Indonesia", "Iraq", "Jamaica", "Norway", "Sweden", "UK", "USA");

		System.out.println("Countries count is " + countries.size());
		initThreadsForCountries(countries);
	}

	private static void initThreadsForCountries(List<String> countries) {
		ResourceCounter count_Countries = new ResourceCounter(0);
		List<Thread> threads = new ArrayList<>();
		int order = 1;
		for (String country : countries) {
			Thread t = new Thread(new RandomCountriesEnlisterTask(country, count_Countries),
					"Thread_" + country + "_order_" + order);
			threads.add(t);
			t.start();
			order++;
		}

		for (Thread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Threads updated country count = " + count_Countries.getCount());
	}
}

class RandomCountriesEnlisterTask implements Runnable {

	final String myCountry;
	final ResourceCounter allCounter;

	RandomCountriesEnlisterTask(String country, ResourceCounter c) {
		myCountry = country;
		allCounter = c;
	}

	@Override
	public void run() {
		allCounter.incr();
		System.out.println(myCountry + " Greetings: " + ", Count = " + allCounter.getCount() + ", "
				+ Thread.currentThread().getName() + " TID: " + Thread.currentThread().getId());
	}

}
