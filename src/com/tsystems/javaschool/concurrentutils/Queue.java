package com.tsystems.javaschool.concurrentutils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * See p. 201 Doug Lea "Concurrent Programming in Java"
 * 
 * @author Alexander Markov
 */
public class Queue {

	private static int capacity = 2;
	private final BlockingQueue<Object> queue;

	/**
	 * Create a queue with a default capacity = 2
	 */
	public Queue() {
		this(capacity);
	}

	/**
	 * Create a queue with the fixed capacity
	 * 
	 * @param capacity
	 *            - queue capacity
	 * @throws IllegalArgumentException
	 */
	public Queue(int capacity) throws IllegalArgumentException {
		if (capacity > 0) {
			Queue.capacity = capacity;
			queue = new LinkedBlockingQueue<Object>(capacity);
			System.out.println(Queue.class.getSimpleName()
					+ " is initialized to initial capacity of " + capacity);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Insert given element at the beginning of a queue
	 * 
	 * @param o
	 *            - object to insert
	 * @throws InterruptedException
	 */
	public void put(Object o) throws InterruptedException {
		queue.put(o);
	}

	/**
	 * Remove and return last element from a queue
	 * 
	 * @return last element in a queue
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException {
		return queue.take();
	}
} // class Queue