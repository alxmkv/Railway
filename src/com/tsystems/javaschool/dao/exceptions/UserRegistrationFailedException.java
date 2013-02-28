package com.tsystems.javaschool.dao.exceptions;

/**
 * @author Alexander Markov
 */
@SuppressWarnings("serial")
public class UserRegistrationFailedException extends Exception {
	public UserRegistrationFailedException(String message) {
		super(message);
	}
}