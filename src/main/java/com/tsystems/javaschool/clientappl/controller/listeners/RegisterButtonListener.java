/**
 * 
 */
package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tsystems.javaschool.clientappl.views.ClientApplView;

/**
 * Shows registration form
 * 
 * @author Alexander Markov
 */
public class RegisterButtonListener implements ActionListener {

	private final ClientApplView clientApplView;

	public RegisterButtonListener(ClientApplView clientApplView) {
		this.clientApplView = clientApplView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clientApplView.getLoginView().getRegisterButton()) {
			clientApplView.showView("Registration");
		}
	}
}