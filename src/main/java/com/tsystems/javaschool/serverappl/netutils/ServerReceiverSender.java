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
 * @author Alexander Markov
 */
public class ServerReceiverSender {
	
	private final static Logger logger = Logger.getLogger(ServerReceiverSender.class);
	
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;

	public ServerReceiverSender(InputStream input, OutputStream output)
			throws IOException {
		objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
				output));
		objectInputStream = new ObjectInputStream(
				new BufferedInputStream(input));
	}

	public static void send(ServiceResponse response) {
		try {
			objectOutputStream.writeObject(response);
		} catch (IOException e) {
			logger.error("Request could not be completed");
		}
	}

	public static ServiceRequest receive() {
		ServiceRequest request = null;
		try {
			request = (ServiceRequest) objectInputStream
					.readObject();
		} catch (IOException e) {
			logger.error("Response could not be read");
		} catch (ClassNotFoundException e) {
			logger.error("Response could not be deserialized");
		}
		return request;
	}
}