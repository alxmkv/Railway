package com.tsystems.javaschool.serverappl;

/**
 * Extended from <code>Runnable</code> this interface adds termination method
 * for stopping threads.
 * 
 * @author Alexander Markov
 */
public interface ITerminateRunnable extends Runnable {
	/**
	 * An object implementing interface <code>ITerminateRunnable</code> can stop
	 * its thread using <code>terminate</code> method.
	 * 
	 * @throws InterruptedException
	 */
	void terminate() throws InterruptedException;
}