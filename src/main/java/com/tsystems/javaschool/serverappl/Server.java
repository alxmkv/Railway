package com.tsystems.javaschool.serverappl;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.tsystems.javaschool.serverappl.concurrentutils.Counter;
import com.tsystems.javaschool.serverappl.concurrentutils.Queue;
import com.tsystems.javaschool.serverappl.netutils.Dispatcher;
import com.tsystems.javaschool.serverappl.netutils.Host;
import com.tsystems.javaschool.serverappl.netutils.ShutdownSequence;

/**
 * Main class for server.
 * 
 * @author Alexander Markov
 */
public class Server {

	private static final Logger logger = Logger.getLogger(Server.class);

	/**
	 * java com/tsystems/javaschool/serverappl/Server 2 2 6087
	 * 
	 * @param args
	 *            [0] - thread pool size, [1] - max number of sessions, [2] -
	 *            port
	 */
	public static void main(String[] args) {
		// 0. Configure logging parameters
		try {
			RollingFileAppender appender = new RollingFileAppender(
					new EnhancedPatternLayout("%d{dd-MM-yyyy HH:mm:ss.SSS} "
							+ EnhancedPatternLayout.TTCC_CONVERSION_PATTERN),
					"logs/server.log", true);
			appender.setMaxBackupIndex(4);
			appender.setMaxFileSize("100KB");
			BasicConfigurator.configure(appender);
		} catch (IOException e) {
			System.err
					.println("FATAL ERROR: Could not open logger output file");
			return;
		}
		// NDC.push("");logger.error("ERROR");NDC.pop();NDC.remove();LogManager.shutdown();
		// 1. Verify input parameters
		// 1.1. Check number of input parameters
		if (args.length != 3) {
			logger.fatal("Invalid argument count. Sample input: 2 2 6087");
			return;
		}
		// args[0]="maxThreadPoolSize";args[1]="sessionNum";args[2]="6087";
		int threadPoolSize = 2;
		int sessionNumber = 2;
		int port = 6087;
		// 1.2. Determine thread pool size
		try {
			threadPoolSize = Integer.parseInt(args[0]);
			if (threadPoolSize < 1) {
				threadPoolSize = 2;
			}
		} catch (NumberFormatException e) {
			threadPoolSize = 2;
			logger.warn("Integer.parseInt(args[0]) failed, set to "
					+ threadPoolSize);
		}
		// 1.3. Determine max number of concurrent sessions
		try {
			sessionNumber = Integer.parseInt(args[1]);
			if (sessionNumber < 1) {
				sessionNumber = 2;
			}
		} catch (NumberFormatException e) {
			sessionNumber = 2;
			logger.warn("Integer.parseInt(args[1]) failed, set to "
					+ sessionNumber);
		}
		// 1.4. Get port number
		try {
			port = Integer.parseInt(args[2]);
			if (port < 1) {
				port = 6087;
			}
		} catch (NumberFormatException e) {
			port = 6087;
			logger.warn("Integer.parseInt(args[2]) failed, set to " + port);
		}
		System.out.println("Input parameters: maxThreadPoolSize = "
				+ threadPoolSize + ", sessionNum = " + sessionNumber
				+ ", port = " + port);

		// 2. Create session counter
		Counter counter = new Counter();

		// 3. Create session tasks queue
		Queue queue = new Queue();

		// 4. Start dispatcher in separate thread
		Dispatcher dispatcher = new Dispatcher(counter, queue, threadPoolSize);

		// 5. Start host in separate thread
		Host host = null;
		try {
			host = new Host(counter, queue, port, sessionNumber);
		} catch (IOException e) {
			logger.fatal("Host not started due to a server socket error");
		}

		// 6.Register new virtual-machine shutdown hook
		ShutdownSequence shutdown = new ShutdownSequence(host, dispatcher);
		// Add initialized but not started Thread object
		Runtime.getRuntime().addShutdownHook(shutdown);

		System.out.println("Server started");
	} // main()
} // class Server