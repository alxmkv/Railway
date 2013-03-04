package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tsystems.javaschool.clientappl.views.ClientApplView;

/**
 * Shows login form
 * 
 * @author Alexander Markov
 */
public class LoginButtonListener implements ActionListener {

	private final ClientApplView clientApplView;

	public LoginButtonListener(ClientApplView clientApplView) {
		this.clientApplView = clientApplView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clientApplView.getRegistrationView()
				.getLoginButton()) {
			clientApplView.showView("Login");
		}
	}
}