/**
 * 
 */
package com.tsystems.javaschool.clientappl;

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
 * Client sender stream
 * 
 * @author Alexander Markov
 */
public class ClientSenderReceiver {

	private final static Logger logger = Logger.getLogger(ClientSenderReceiver.class);

	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;

	public ClientSenderReceiver(InputStream input, OutputStream output)
			throws IOException {
		objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
				output));
		objectInputStream = new ObjectInputStream(
				new BufferedInputStream(input));
	}

	public static void send(ServiceRequest request) {
		try {
			objectOutputStream.writeObject(request);
		} catch (IOException e) {
			logger.error("Request could not be completed");
		}
	}

	public static ServiceResponse receive() {
		ServiceResponse response = null;
		try {
			response = (ServiceResponse) objectInputStream
					.readObject();
		} catch (IOException e) {
			logger.error("Response could not be read");
		} catch (ClassNotFoundException e) {
			logger.error("Response could not be deserialized");
		}
		return response;
	}
}