package com.tsystems.javaschool.serverappl.dao.hibernate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.tsystems.javaschool.common.HibernateUtil;
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
		MessageDigest md5 = null;
		MessageDigest sha256 = null;
		String passwordHash = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			sha256 = MessageDigest.getInstance("SHA-256");
			passwordHash = sha256
					.digest(md5.digest(password.getBytes("UTF-8"))).toString();
			System.out.println("HASH for alexm: "
					+ sha256.digest(md5.digest("alexm".getBytes("UTF-8")))
							.toString());
		} catch (NoSuchAlgorithmException e) {
			throw new UserRegistrationFailedException("");
		} catch (UnsupportedEncodingException e) {
			throw new UserRegistrationFailedException("");
		}
		User user = new User(login, passwordHash, email, name, surname,
				birthDate, Byte.parseByte("2"), Byte.parseByte("1"));
		try {
			HibernateUtil.beginTransaction();
			HibernateUtil.getSession().saveOrUpdate("User", user);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			throw new UserRegistrationFailedException("");
		}
		return user;
	}

	@Override
	public Boolean authorizeUser(String login, String password) {
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}
}