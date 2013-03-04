package com.tsystems.javaschool.serverappl.dao.hibernate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.tsystems.javaschool.common.entities.User;
import com.tsystems.javaschool.serverappl.dao.UserDAO;
import com.tsystems.javaschool.serverappl.dao.exceptions.UserRegistrationFailedException;

/**
 * @author Alexander Markov
 */
public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {

	}

	@Override
	public User registerUser(String login, String password, String email,
			String name, String surname, Date birthDate)
			throws UserRegistrationFailedException {
		MessageDigest md = null;
		String passwordHash = null;
		try {
			md = MessageDigest.getInstance("MD5");
			passwordHash = md.digest(password.getBytes("UTF-8")).toString();
		} catch (NoSuchAlgorithmException e) {
			throw new UserRegistrationFailedException("");
		} catch (UnsupportedEncodingException e) {
			throw new UserRegistrationFailedException("");
		}
		return new User(login, passwordHash, email, name, surname, birthDate);
	}

	@Override
	public Boolean authorizeUser(String login, String password) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}
}