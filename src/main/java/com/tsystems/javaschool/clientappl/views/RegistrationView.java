/**
 * 
 */
package com.tsystems.javaschool.clientappl.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tsystems.javaschool.clientappl.controller.listeners.LoginButtonListener;
import com.tsystems.javaschool.clientappl.controller.listeners.SignInButtonListener;

/**
 * View for user registration
 * 
 * @author Alexander Markov
 */
public class RegistrationView extends JPanel {

	private static final long serialVersionUID = -5300522288248198246L;
	private final Font registerViewFont;
	private final JButton loginButton;
	private final JButton signInButton;
	private final JLabel nameLabel;
	private final JLabel surnameLabel;
	private final JLabel birthdateLabel;
	private final JLabel emailLabel;
	private final JLabel loginLabel;
	private final JLabel passwordLabel;
	private final JLabel confirmPasswordLabel;
	private final JTextField nameTextField;
	private final JTextField surnameTextField;
	private final JTextField birthdateTextField;
	private final JTextField emailTextField;
	private final JTextField loginTextField;
	private final JPasswordField passwordTextField;
	private final JPasswordField confirmPasswordTextField;

	/**
	 * Constructs registration form
	 */
	public RegistrationView(ClientApplView clientApplView) {
		this.setLayout(new GridLayout(9, 2, 10, 10));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		registerViewFont = new Font("Verdana", Font.PLAIN, 24);
		loginButton = new JButton("Back to login");
		loginButton.setBackground(Color.lightGray);
		loginButton.setFont(registerViewFont);
		loginButton.addActionListener(new LoginButtonListener(clientApplView));
		signInButton = new JButton("Sign in");
		signInButton.setBackground(Color.lightGray);
		signInButton.setFont(registerViewFont);
		signInButton
				.addActionListener(new SignInButtonListener(clientApplView));
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(registerViewFont);
		surnameLabel = new JLabel("Surname:");
		surnameLabel.setFont(registerViewFont);
		birthdateLabel = new JLabel("Birth date (yyyy-mm-dd):");
		birthdateLabel.setFont(registerViewFont);
		emailLabel = new JLabel("Email:");
		emailLabel.setFont(registerViewFont);
		loginLabel = new JLabel("Login:");
		loginLabel.setFont(registerViewFont);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(registerViewFont);
		confirmPasswordLabel = new JLabel("Confirm password:");
		confirmPasswordLabel.setFont(registerViewFont);
		nameTextField = new JTextField();
		nameTextField.setFont(registerViewFont);
		surnameTextField = new JTextField();
		surnameTextField.setFont(registerViewFont);
		birthdateTextField = new JTextField();
		birthdateTextField.setFont(registerViewFont);
		emailTextField = new JTextField();
		emailTextField.setFont(registerViewFont);
		loginTextField = new JTextField();
		loginTextField.setFont(registerViewFont);
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(registerViewFont);
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setFont(registerViewFont);
		this.add(new JLabel(""));
		this.add(loginButton);
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(surnameLabel);
		this.add(surnameTextField);
		this.add(birthdateLabel);
		this.add(birthdateTextField);
		this.add(emailLabel);
		this.add(emailTextField);
		this.add(loginLabel);
		this.add(loginTextField);
		this.add(passwordLabel);
		this.add(passwordTextField);
		this.add(confirmPasswordLabel);
		this.add(confirmPasswordTextField);
		this.add(new JLabel(""));
		this.add(signInButton);
	}

	/**
	 * @return Login button
	 */
	public JButton getLoginButton() {
		return loginButton;
	}

	/**
	 * @return Sign in button
	 */
	public JButton getSignInButton() {
		return signInButton;
	}

	/**
	 * @return Name
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * @return Surname
	 */
	public JTextField getSurnameTextField() {
		return surnameTextField;
	}

	/**
	 * @return Birth date
	 */
	public JTextField getBirthdateTextField() {
		return birthdateTextField;
	}

	/**
	 * @return Email
	 */
	public JTextField getEmailTextField() {
		return emailTextField;
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

	/**
	 * @return Confirmed password
	 */
	public JPasswordField getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}
}