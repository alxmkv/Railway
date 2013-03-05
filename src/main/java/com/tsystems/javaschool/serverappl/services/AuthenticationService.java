package com.tsystems.javaschool.serverappl.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.tsystems.javaschool.common.HibernateUtil;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;
import com.tsystems.javaschool.common.entities.User;

/**
 * Authenticate and authorize user
 * 
 * @author Alexander Markov
 */
public class AuthenticationService {
	/**
	 * @param request
	 * @return
	 */
	public static ServiceResponse service(ServiceRequest request) {
		List<?> payload = request.getPayload();
		User user = null;
		try {
			HibernateUtil.beginTransaction();
			user = (User) HibernateUtil
					.getSession()
					.createQuery(
							"SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
					.setParameter("login", payload.get(0))
					.setParameter("password", payload.get(1)).uniqueResult();
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		if (user == null) {
			return new ServiceResponse(false, null,
					"Login and password do not match");
		}
		// Get user type
		List<String> result = new ArrayList<String>(1);
		result.add(Byte.valueOf(user.getUserType()).toString());
		return new ServiceResponse(true, result, "");
	}
}