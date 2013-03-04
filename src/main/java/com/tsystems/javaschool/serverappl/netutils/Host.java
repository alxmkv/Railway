package com.tsystems.javaschool.serverappl.netutils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.common.ITerminateRunnable;
import com.tsystems.javaschool.serverappl.concurrentutils.Counter;
import com.tsystems.javaschool.serverappl.concurrentutils.Queue;

/**
 * @author Alexander Markov
 */
public class Host implements ITerminateRunnable {

	private final static Logger logger = Logger.getLogger(Host.class);
	private final static String className = Host.class.getSimpleName();

	private final Counter counter;
	private final Queue queue;
	private final int port;
	private final int sessionNumber;
	private final ServerSocket ss;
	private boolean isRunning = false;
	private final Thread thread;
	private Socket s;

	/**
	 * Initialize and start host in a separate thread
	 * 
	 * @param counter
	 * @param queue
	 * @param port
	 * @param sessionNumber
	 * @throws IOException
	 */
	public Host(Counter counter, Queue queue, int port, int sessionNumber)
			throws IOException {
		this.counter = counter;
		this.queue = queue;
		this.port = port;
		this.sessionNumber = sessionNumber;
		// Create server socket bound to specified port
		ss = new ServerSocket(this.port);
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println(className + " started");
		try {
			while (isRunning) {
				try {
					// Listen for connection to be made to socket, accept it
					// (method blocks until connection made)
					s = ss.accept();
				} catch (IOException e) {
					logger.warn(className + ": could not accept connection");
					break;
				}
				int cnt = counter.get();
				if (cnt < sessionNumber) {
					try {
						queue.put(s);
					} catch (InterruptedException e) {
						logger.warn(className
								+ ": InterruptedException when putting task to queue");
						break;
					}
					cnt = counter.inc();
					System.out
							.println("===============================================================");
					System.out.println(className + ": Session #" + (cnt - 1)
							+ " was put to queue");
				} else {
					logger.warn(className + ": (max session counter = "
							+ sessionNumber + ") <= " + "(current conter = "
							+ cnt + "), closing socket");
					// Send response to client
					try {
						new DataOutputStream(s.getOutputStream())
								.writeUTF("Sorry, server is busy. Please, try again in a few moments");
					} catch (IOException e) {
						logger.error(className
								+ ": could not get output stream");
					}
					try {
						if (s != null && !s.isClosed()) {
							s.close();
						}
					} catch (IOException ex) {
						logger.error(className + ": could not close socket");
					}
					break;
				}
			} // while(isRunning)
		} finally {
			if (isRunning) {
				try {
					if (ss != null) {
						ss.close();
					}
				} catch (IOException ex) {
					logger.error(className + ": could not close server socket");
				}
			}
		}
	} // run()

	@Override
	public void terminate() throws InterruptedException {
		isRunning = false;
		try {
			if (s != null && !s.isClosed()) {
				s.close();
			}
		} catch (IOException ex) {
			logger.error(className + ": could not close socket");
		}
		try {
			if (ss != null && !ss.isClosed()) {
				ss.close();
			}
		} catch (IOException ex) {
			logger.error(className + ": could not close server socket");
		}
		thread.interrupt();
		thread.join();
	}
} // class Host