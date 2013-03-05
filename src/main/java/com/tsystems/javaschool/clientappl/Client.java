package com.tsystems.javaschool.clientappl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.tsystems.javaschool.clientappl.views.ClientApplFrame;

/**
 * Main class for client connections.
 * 
 * @author Alexander Markov
 */
public class Client {

	private static final Logger logger = Logger.getLogger(Client.class);

	/**
	 * java com/tsystems/javaschool/clientappl/Client localhost 6087
	 * 
	 * @param args
	 *            [0] - host name/IP address, [1] - port
	 */
	public static void main(String[] args) {
		// 0. Configure logging parameters
		try {
			RollingFileAppender appender = new RollingFileAppender(
					new EnhancedPatternLayout("%d{dd-MM-yyyy HH:mm:ss.SSS} "
							+ EnhancedPatternLayout.TTCC_CONVERSION_PATTERN),
					"logs/client.log", true);
			appender.setMaxBackupIndex(4);
			appender.setMaxFileSize("100KB");
			BasicConfigurator.configure(appender);
		} catch (IOException e) {
			System.err
					.println("FATAL ERROR: Could not open logger output file");
			return;
		}
		// 1. Verify input parameters
		// 1.1. Check number of input parameters
		if (args.length != 2) {
			logger.fatal("Invalid argument count. Sample input: localhost 6087");
			return;
		}
		// args[0]="localhost";args[1]="6087";
		// 1.2. Determine IP address of host
		InetAddress ia = null;
		try {
			ia = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			try {
				ia = InetAddress.getByName("localhost");
			} catch (UnknownHostException e1) {
			}
			logger.warn("InetAddress.getByName(args[0]) failed, set to "
					+ ia.getHostName());
		}
		// 1.3. Get port number by parsing string argument as signed decimal
		// integer
		int port;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			port = 6087;
			logger.warn("Integer.parseInt(args[1]) failed, set to " + port);
		}
		System.out.println("Input parameters: IP address of host = "
				+ ia.toString() + ", port = " + port);

		// 2.1. Open a socket and input/output streams to the socket
		final Socket socket;
		try {
			// Create stream socket and connect it to specified port number at
			// specified IP address
			socket = new Socket(ia, port);
			System.out.println("Client started");
			new ClientSenderReceiver(socket.getInputStream(),
					socket.getOutputStream());
			System.out.println("ClientSenderReceiver started");
			// 2.2. Start GUI client
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new ClientApplFrame(socket);
				}
			});
			System.out.println("Client GUI started");
		} catch (IOException e) {
			logger.error("Connection refused: " + e.getMessage());
		}
	} // main()
} // class Client