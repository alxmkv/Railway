package com.tsystems.javaschool.serverappl.netutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * Server request receiver/response sender streams
 * 
 * @author Alexander Markov
 */
public class ServerReceiverSender {

	private static final Logger logger = Logger
			.getLogger(ServerReceiverSender.class);

	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;

	/**
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public ServerReceiverSender(InputStream input, OutputStream output)
			throws IOException {
		objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
				output));
		objectOutputStream.flush();
		objectInputStream = new ObjectInputStream(
				new BufferedInputStream(input));
	}

	/**
	 * @param response
	 */
	public static void send(ServiceResponse response) {
		try {
			objectOutputStream.writeObject(response);
			objectOutputStream.flush();
		} catch (IOException e) {
			logger.error("Request could not be completed");
		}
	}

	/**
	 * @return Request from client
	 */
	public static ServiceRequest receive() {
		ServiceRequest request = null;
		try {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				logger.error("InterruptedException while sleeping in request receive");
			}
			request = (ServiceRequest) objectInputStream.readObject();
		} catch (IOException e) {
			logger.error("Request could not be read");
		} catch (ClassNotFoundException e) {
			logger.error("Request could not be deserialized");
		}
		return request;
	}
}