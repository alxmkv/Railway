package com.tsystems.javaschool.serverappl.netutils;

import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.serverappl.concurrentutils.Counter;
import com.tsystems.javaschool.serverappl.services.ServiceLocator;

/**
 * @author Alexander Markov
 */
public class SessionTask implements Runnable {

	private static final Logger logger = Logger.getLogger(SessionTask.class);
	private static final String className = SessionTask.class.getSimpleName();

	private final String id;
	private final Counter counter;
	private final Socket socket;
	private boolean isRunning = false;

	/**
	 * @param counter
	 *            - session counter
	 * @param socket
	 *            - client socket
	 */
	public SessionTask(Counter counter, Socket socket) {
		this.id = UUID.randomUUID().toString();
		this.counter = counter;
		this.socket = socket;
		isRunning = true;
	}

	@Override
	public void run() {
		System.out.println(className + " #" + id + " started");
		try {
			new ServerReceiverSender(socket.getInputStream(),
					socket.getOutputStream());
			while (isRunning) {
				ServiceRequest request = ServerReceiverSender.receive();
				if (request != null) {
					ServerReceiverSender.send(ServiceLocator.service(request));
				}
			}
		} catch (IOException e) {
			logger.warn("Session #" + id + " client disconnected");
		} finally {
			isRunning = false;
			// Decrease session counter
			if (counter.dec() < 0) {
				logger.error("Session #" + id + " counter < 0");
			}
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				logger.error("Session #" + id + " could not close socket");
			}
			System.out.println("Session #" + id + " terminated");
		}
	} // run()

	/**
	 * @return id of this session
	 */
	public String getId() {
		return id;
	}
} // class SessionTask