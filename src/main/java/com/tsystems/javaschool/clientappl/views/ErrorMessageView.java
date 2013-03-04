/**
 * 
 */
package com.tsystems.javaschool.clientappl.views;

import java.awt.Dialog;
import java.awt.Frame;

/**
 * @author Alexander Markov
 */
public class ErrorMessageView {
	public ErrorMessageView(Frame frame, String message) {
		// TODO
		Dialog view = new Dialog(frame, message);
		view.setVisible(true);
	}
}