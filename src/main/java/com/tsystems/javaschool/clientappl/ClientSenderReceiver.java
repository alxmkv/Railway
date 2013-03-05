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
 * Client request sender/response receiver streams
 * 
 * @author Alexander Markov
 */
public class ClientSenderReceiver {

	private static final Logger logger = Logger
			.getLogger(ClientSenderReceiver.class);

	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;

	/**
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public ClientSenderReceiver(InputStream input, OutputStream output)
			throws IOException {
		objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
				output));
		objectOutputStream.flush();
		objectInputStream = new ObjectInputStream(
				new BufferedInputStream(input));
	}

	/**
	 * @param request
	 */
	public static void send(ServiceRequest request) {
		try {
			objectOutputStream.write(1);
			objectOutputStream.flush();
			objectOutputStream.writeObject(request);
			objectOutputStream.flush();
		} catch (IOException e) {
			logger.error("Request could not be completed");
		}
	}

	/**
	 * @return Response from server
	 */
	public static ServiceResponse receive() {
		ServiceResponse response = null;
		try {
			response = (ServiceResponse) objectInputStream.readObject();
		} catch (IOException e) {
			logger.error("Response could not be read");
		} catch (ClassNotFoundException e) {
			logger.error("Response could not be deserialized");
		}
		return response;
	}

	/**
	 * Close streams
	 */
	public static void close() {
		try {
			objectOutputStream.close();
		} catch (IOException e) {
			logger.error("Object output stream could not be closed");
		}
		try {
			objectInputStream.close();
		} catch (IOException e) {
			logger.error("Object input stream could not be closed");
		}
	}
}