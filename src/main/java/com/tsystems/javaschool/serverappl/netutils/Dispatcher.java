package com.tsystems.javaschool.serverappl.netutils;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.serverappl.ITerminateRunnable;
import com.tsystems.javaschool.serverappl.concurrentutils.Counter;
import com.tsystems.javaschool.serverappl.concurrentutils.Queue;
import com.tsystems.javaschool.serverappl.threadpooling.ThreadPool;

/**
 * @author Alexander Markov
 */
public class Dispatcher implements ITerminateRunnable {

	private static final Logger logger = Logger.getLogger(Dispatcher.class);
	private static final String className = Dispatcher.class.getSimpleName();

	private final Counter counter;
	private final Queue queue;
	private final ThreadPool threadPool;
	private boolean isRunning = false;
	private final Thread thread;
	private Socket s;

	/**
	 * Initialize and start dispatcher in a separate thread
	 * 
	 * @param counter
	 *            - session counter
	 * @param queue
	 *            - queue of sockets
	 * @param threadPoolSize
	 *            - number of worker threads in this thread pool
	 */
	public Dispatcher(Counter counter, Queue queue, int threadPoolSize) {
		this.counter = counter;
		this.queue = queue;
		threadPool = new ThreadPool(threadPoolSize);
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println(className + " started");
		// Process sessions from queue
		while (isRunning) {
			try {
				s = (Socket) queue.take();
				if (!isRunning) {
					break;
				}
				threadPool.execute(new SessionTask(counter, s));
			} catch (InterruptedException e) {
				logger.warn(className
						+ ": InterruptedException when taking task from queue, "
						+ "terminating " + className);
				if (isRunning) {
					try {
						terminate();
					} catch (InterruptedException ex) {
						logger.error(className + ": could not be terminated");
					}
				}
				break;
			}
		} // while(isRunning)
	} // run()

	@Override
	public void terminate() throws InterruptedException {
		isRunning = false;
		try {
			if (s != null && !s.isClosed()) {
				s.close();
			}
		} catch (IOException e) {
			logger.error(className + ": IOException when closing socket");
		}
		threadPool.terminateWorkerThreads();
		thread.interrupt();
		thread.join();
	}
} // class Dispatcher