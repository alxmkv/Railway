package com.tsystems.javaschool.clientappl.views;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.clientappl.ClientSenderReceiver;

/**
 * Main frame for client application
 * 
 * @author Alexander Markov
 */
public class ClientApplFrame extends JFrame implements WindowListener {

	private static final long serialVersionUID = -8247367126146234003L;
	private static final Logger logger = Logger
			.getLogger(ClientApplFrame.class);
	private final Socket socket;

	/**
	 * Creates client application view
	 */
	public ClientApplFrame(Socket socket) {
		this.socket = socket;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			logger.error("LookAndFeel class could not be found");
		} catch (InstantiationException e) {
			logger.error("New instance of the class couldn't be created");
		} catch (IllegalAccessException e) {
			logger.error("Initializer isn't accessible");
		} catch (UnsupportedLookAndFeelException e) {
			logger.error("Underlying platform does not support this look and feel");
		}
		new ClientApplView(this);
		this.addWindowListener(this);
		this.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// Clean-up: close socket
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException ex) {
			logger.error("Could not close socket");
		}
		ClientSenderReceiver.close();
		System.out.println("Client disconnected");
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}