package com.tsystems.javaschool.concurrentutils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alexander Markov
 */
public class Counter {

	// Asynchronously changed (value is changed by concurrent threads)
	private AtomicInteger counter = new AtomicInteger(0);

	/**
	 * Initialize counter with 0
	 */
	public Counter() {
		System.out.println(Counter.class.getSimpleName()
				+ " is initialized to " + counter.get());
	}

	/**
	 * @return Incremented counter value
	 */
	public int inc() {
		return counter.incrementAndGet();
	}

	/**
	 * @return Decremented counter value
	 */
	public int dec() {
		if (counter.get() > 0) {
			return counter.decrementAndGet();
		}
		return -1;
	}

	/**
	 * @return Current counter value
	 */
	public int get() {
		return counter.get();
	}
} // class Counter