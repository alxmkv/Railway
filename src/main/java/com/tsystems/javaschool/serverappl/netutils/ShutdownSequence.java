package com.tsystems.javaschool.serverappl.netutils;

import org.apache.log4j.Logger;

/**
 * Class for graceful shutdown and clean-up
 * 
 * @author Alexander Markov
 */
public class ShutdownSequence extends Thread {

	private final static Logger logger = Logger
			.getLogger(ShutdownSequence.class);
	private final static String className = ShutdownSequence.class
			.getSimpleName();

	private final Host host;
	private final Dispatcher dispatcher;
	private boolean isRunning = false;

	/**
	 * @param host
	 * @param dispatcher
	 */
	public ShutdownSequence(Host host, Dispatcher dispatcher) {
		this.host = host;
		this.dispatcher = dispatcher;
		isRunning = true;
	}

	@Override
	public void run() {
		System.out
				.println("===============================================================");
		System.out.println("Shutdown sequence started...");
		if (isRunning) {
			isRunning = false;
			try {
				host.terminate();
			} catch (InterruptedException e) {
				logger.error(className + ": Host could not be terminated");
			}
			System.out.println("Host terminated");
			try {
				dispatcher.terminate();
			} catch (InterruptedException e) {
				logger.error(className + ": Dispatcher could not be terminated");
			}
			System.out.println("Dispatcher terminated");
			System.out.println("Shutdown sequence finished");
		}
	} // run()
} // class ShutdownSequence