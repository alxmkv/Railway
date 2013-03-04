package com.tsystems.javaschool.clientappl.views;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

/**
 * Main frame for client application
 * 
 * @author Alexander Markov
 */
public class ClientApplFrame extends JFrame {

	private final static long serialVersionUID = -8247367126146234003L;
	private final static Logger logger = Logger
			.getLogger(ClientApplFrame.class);

	/**
	 * Creates client application view
	 */
	public ClientApplFrame() {
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
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientApplFrame();
	}
}
