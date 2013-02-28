package com.tsystems.javaschool.threadpooling;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * @author Alexander Markov
 */
public class ThreadPool implements Executor {

	private final static Logger logger = Logger.getLogger(ThreadPool.class);
	private final static String className = ThreadPool.class.getSimpleName();

	private final int poolSize;
	private final ExecutorService pool;
	private final static long TERMINATION_TIMEOUT = 60;

	/**
	 * @param poolSize
	 *            - number of worker threads in this thread pool
	 */
	public ThreadPool(int poolSize) {
		this.poolSize = poolSize;
		pool = Executors.newFixedThreadPool(poolSize);
		System.out.println(className + " is initialized to " + poolSize
				+ " worker threads");
	}

	@Override
	public void execute(Runnable command) {
		pool.execute(command);
	}

	/**
	 * @throws InterruptedException
	 */
	public void terminateWorkerThreads() throws InterruptedException {
		pool.shutdown();
		try {
			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
				logger.warn(className
						+ ": terminating currently executing tasks");
				pool.shutdownNow();
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(TERMINATION_TIMEOUT,
						TimeUnit.SECONDS)) {
					logger.error(className
							+ " could not be properly terminated");
				}
			}
		} catch (InterruptedException e) {
			logger.error(className
					+ ": InterruptedException when waiting for thred pool termination");
		}
	}

	/**
	 * @return Number of threads in this thread pool
	 */
	public int getPoolSize() {
		return poolSize;
	}
} // class ThreadPool