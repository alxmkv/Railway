package com.tsystems.javaschool.clientappl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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

	private final static Logger logger = Logger.getLogger(Client.class);

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
			appender.setBufferSize(1024);
			appender.setBufferedIO(true);
			appender.setMaxBackupIndex(4);
			appender.setMaxFileSize("10KB");
			appender.activateOptions();
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
		Socket socket = null;
//		String cmd = "";
//		DataOutputStream dos = null;
//		// PrintWriter pw = null;
//		DataInputStream dis = null;
//		BufferedReader br = null;
		try {
			// Create stream socket and connect it to specified port number at
			// specified IP address
			socket = new Socket(ia, port);
			System.out.println("Client started");
			new ClientSenderReceiver(socket.getInputStream(), socket.getOutputStream());
			// 2.2. Start GUI client
			new ClientApplFrame();
//			// Create new data output stream to write data to specified
//			// underlying output stream
//			dos = new DataOutputStream(socket.getOutputStream());
//			// pw = new PrintWriter(dos, true);
//			dis = new DataInputStream(socket.getInputStream());
//			// Create buffering character-input stream that uses default-sized
//			// input buffer
//			br = new BufferedReader(new InputStreamReader(System.in));
//			// 3. Read from and write to the stream
//			// Read line of text
//			cmd = br.readLine();
//			while (!"quit".equalsIgnoreCase(cmd) && cmd != null) {
//				// Write string to underlying output stream using UTF-8
//				if (cmd != null && !"".equalsIgnoreCase(cmd)) {
//					dos.writeUTF(cmd);
//					// Flush data output stream (force buffered output bytes to
//					// be written out to stream)
//					dos.flush();
//					String str = dis.readUTF();
//					if (str != null && !("".equalsIgnoreCase(str))) {
//						System.out.println("Received message: " + str);
//					}
//				}
//				cmd = br.readLine();
//			}
		} catch (IOException e) {
			logger.error("Connection refused");
		}
		// 4. Clean-up: close streams and socket
		finally {
//			try {
//				if (dos != null) {
//					dos.close();
//				}
//			} catch (IOException e) {
//				logger.error("Could not close output stream");
//			}
//			try {
//				if (dis != null) {
//					dis.close();
//				}
//			} catch (IOException e) {
//				logger.error("Could not close input stream");
//			}
//			try {
//				if (br != null) {
//					br.close();
//				}
//			} catch (IOException e) {
//				logger.error("Could not close reader stream");
//			}
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				logger.error("Could not close socket");
			}
			System.out.println("Client disconnected");
		}
	} // main()
} // class Client