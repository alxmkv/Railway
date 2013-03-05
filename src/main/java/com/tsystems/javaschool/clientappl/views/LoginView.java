package com.tsystems.javaschool.clientappl.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tsystems.javaschool.clientappl.controller.listeners.RegisterButtonListener;
import com.tsystems.javaschool.clientappl.controller.listeners.SignInButtonListener;

/**
 * View for user login
 * 
 * @author Alexander Markov
 */
public class LoginView extends JPanel {

	private static final long serialVersionUID = -4492884654702332545L;
	private final Font loginViewFont;
	private final JButton registerButton;
	private final JButton signInButton;
	private final JLabel loginLabel;
	private final JLabel passwordLabel;
	private final JTextField loginTextField;
	private final JPasswordField passwordTextField;

	/**
	 * Constructs login form
	 */
	public LoginView(ClientApplView clientApplView) {
		this.setLayout(new GridLayout(9, 2, 10, 10));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		loginViewFont = new Font("Verdana", Font.PLAIN, 24);
		registerButton = new JButton("Register");
		registerButton.setBackground(Color.lightGray);
		registerButton.setFont(loginViewFont);
		registerButton.addActionListener(new RegisterButtonListener(
				clientApplView));
		signInButton = new JButton("Sign in");
		signInButton.setBackground(Color.lightGray);
		signInButton.setFont(loginViewFont);
		signInButton
				.addActionListener(new SignInButtonListener(clientApplView));
		loginLabel = new JLabel("Login:");
		loginLabel.setFont(loginViewFont);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(loginViewFont);
		loginTextField = new JTextField();
		loginTextField.setFont(loginViewFont);
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(loginViewFont);
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(registerButton);
		this.add(loginLabel);
		this.add(loginTextField);
		this.add(passwordLabel);
		this.add(passwordTextField);
		this.add(new JLabel(""));
		this.add(signInButton);
	}

	/**
	 * @return Registration button
	 */
	public JButton getRegisterButton() {
		return registerButton;
	}

	/**
	 * @return Sign in button
	 */
	public JButton getSignInButton() {
		return signInButton;
	}

	/**
	 * @return Login
	 */
	public JTextField getLoginTextField() {
		return loginTextField;
	}

	/**
	 * @return Password
	 */
	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}
}