package com.tsystems.javaschool.serverappl.dao;

import java.util.Date;
import java.util.List;

import com.tsystems.javaschool.common.entities.User;
import com.tsystems.javaschool.serverappl.dao.exceptions.UserRegistrationFailedException;

/**
 * @author Alexander Markov
 */
public interface UserDAO {
	/**
	 * @param login
	 * @param password
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthDate
	 * @return New registered user
	 * @throws UserRegistrationFailedException
	 */
	public User registerUser(String login, String password, String email,
			String name, String surname, Date birthDate)
			throws UserRegistrationFailedException;

	/**
	 * @param login
	 * @param password
	 * @return True if user is successfully logged in
	 */
	public Boolean authorizeUser(String login, String password);

	/**
	 * @return List of users
	 */
	public List<User> getAllUsers();
}
