package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;

import com.tsystems.javaschool.clientappl.ClientSenderReceiver;
import com.tsystems.javaschool.clientappl.views.ClientApplView;
import com.tsystems.javaschool.clientappl.views.ErrorMessageView;
import com.tsystems.javaschool.clientappl.views.LoginView;
import com.tsystems.javaschool.clientappl.views.RegistrationView;
import com.tsystems.javaschool.common.RequestType;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

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
			String name = registrationView.getNameTextField().getText();
			String surname = registrationView.getSurnameTextField().getText();
			String birthDate = registrationView.getBirthdateTextField()
					.getText();
			String email = registrationView.getEmailTextField().getText();
			String login = registrationView.getLoginTextField().getText();
			String password = new String(registrationView
					.getPasswordTextField().getPassword());
			String confirmPassword = new String(registrationView
					.getConfirmPasswordTextField().getPassword());
			// TODO: input parameters validation (email as regexp, birthdate as
			// date)
			if ("".equals(name) || "".equals(surname) || "".equals(birthDate)
					|| "".equals(email) || "".equals(login)
					|| "".equals(password) || "".equals(confirmPassword)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Please, fill all fields.");
				return;
			}
			if (!DateValidator.getInstance().isValid(birthDate, "yyyy-mm-dd")) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Incorrect birth date format. Sample input: yyyy-mm-dd");
				return;
			}
			if (!EmailValidator.getInstance().isValid(email)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Incorrect email");
				return;
			}
			if (!password.equals(confirmPassword)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Passwords are not same");
				return;
			}
			List<String> payload = new ArrayList<String>(6);
			payload.add(0, name);
			payload.add(1, surname);
			payload.add(2, birthDate);
			payload.add(3, email);
			payload.add(4, login);
			payload.add(5, password);
			ClientSenderReceiver.send(new ServiceRequest(
					RequestType.REGISTRATION, payload));
			ServiceResponse response = ClientSenderReceiver.receive();
			if (response != null && response.getStatus()) {
				clientApplView.showView("Home");
			} else {
				if (response == null) {
					new ErrorMessageView(clientApplView.getFrame(),
							"Registration failed");
				} else {
					new ErrorMessageView(clientApplView.getFrame(),
							response.getException());
				}
			}
		} else if (e.getSource() == clientApplView.getLoginView()
				.getSignInButton()) {
			LoginView loginView = clientApplView.getLoginView();
			String login = loginView.getLoginTextField().getText();
			String password = new String(loginView.getPasswordTextField()
					.getPassword());
			if ("".equals(login) || "".equals(password)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Login or password field is empty");
				return;
			}
			List<String> payload = new ArrayList<String>(2);
			payload.add(0, login);
			payload.add(1, password);
			ClientSenderReceiver.send(new ServiceRequest(
					RequestType.AUTHENTICATION, payload));
			ServiceResponse response = ClientSenderReceiver.receive();
			if (response != null && response.getStatus()) {
				clientApplView.showView("Home");
			} else {
				if (response == null) {
					new ErrorMessageView(clientApplView.getFrame(),
						"Incorrect login or password");
				} else {
					new ErrorMessageView(clientApplView.getFrame(),
							response.getException());
				}
			}
		}
	}
}