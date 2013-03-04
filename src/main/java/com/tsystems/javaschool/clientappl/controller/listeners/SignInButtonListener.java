package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.tsystems.javaschool.clientappl.ClientSenderReceiver;
import com.tsystems.javaschool.clientappl.views.ClientApplView;
import com.tsystems.javaschool.clientappl.views.ErrorMessageView;
import com.tsystems.javaschool.clientappl.views.LoginView;
import com.tsystems.javaschool.clientappl.views.RegistrationView;
import com.tsystems.javaschool.common.RequestType;
import com.tsystems.javaschool.common.ServiceRequest;

/**
 * Authenticates and authorizes user. On success shows main GUI including
 * navigation and editor views
 * 
 * @author Alexander Markov
 */
public class SignInButtonListener implements ActionListener {

	private final ClientApplView clientApplView;

	public SignInButtonListener(ClientApplView clientApplView) {
		this.clientApplView = clientApplView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: registration/authentication with Request
		if (e.getSource() == clientApplView.getRegistrationView()
				.getSignInButton()) {
			RegistrationView registrationView = clientApplView
					.getRegistrationView();
			// TODO: input parameters validation (email as regexp, birthdate as
			// date)
			if (!registrationView
					.getPasswordTextField()
					.getText()
					.equals(registrationView.getConfirmPasswordTextField()
							.getText())) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Passwords are not same");
				return;
			}
			List<String> payload = new ArrayList<String>(6);
			payload.add(0, registrationView.getNameTextField().getText());
			payload.add(1, registrationView.getSurnameTextField().getText());
			payload.add(2, registrationView.getBirthdateTextField().getText());
			payload.add(3, registrationView.getEmailTextField().getText());
			payload.add(4, registrationView.getLoginTextField().getText());
			payload.add(5, registrationView.getPasswordTextField().getText());
			ClientSenderReceiver.send(new ServiceRequest(RequestType.REGISTRATION, payload));
			clientApplView.showView("Home");
		} else if (e.getSource() == clientApplView.getLoginView()
				.getSignInButton()) {
			LoginView loginView = clientApplView.getLoginView();
			String login = loginView.getLoginTextField().getText();
			String password = loginView.getPasswordTextField().getText();
			if (!"".equals(login) && !"".equals(password)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Login or password field is empty");
				return;
			}
			List<String> payload = new ArrayList<String>(2);
			payload.add(0, login);
			payload.add(1, password);
			clientApplView.showView("Home");
		}
	}
}