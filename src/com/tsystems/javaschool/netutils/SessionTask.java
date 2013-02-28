package com.tsystems.javaschool.netutils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.concurrentutils.Counter;

/**
 * @author Alexander Markov
 */
public class SessionTask implements Runnable {

	private final static Logger logger = Logger.getLogger(SessionTask.class);
	private final static String className = SessionTask.class.getSimpleName();

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
		DataOutputStream dos = null;
		DataInputStream dis = null;
		String str = "";
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			while (isRunning) {
				str = dis.readUTF();
				if (str != null && !("".equalsIgnoreCase(str))) {
					System.out.println("Received message: " + str);
					dos.writeUTF("Read message: " + str);
					dos.flush();
					System.out.println("Sent message: Read message: " + str);
				} else {
					break;
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
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				logger.error("Session #" + id + " could not close input stream");
			}
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				logger.error("Session #" + id
						+ " could not close output stream");
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