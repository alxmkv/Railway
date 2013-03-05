/**
 * 
 */
package com.tsystems.javaschool.clientappl.views;

import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 * Shows error messages
 * 
 * @author Alexander Markov
 */
public class ErrorMessageView {
	/**
	 * @param frame
	 * @param message
	 */
	public ErrorMessageView(Frame frame, String message) {
		JOptionPane.showMessageDialog(frame, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}