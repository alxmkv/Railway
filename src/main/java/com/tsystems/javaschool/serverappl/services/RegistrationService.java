/**
 * 
 */
package com.tsystems.javaschool.serverappl.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.validator.routines.DateValidator;

import com.tsystems.javaschool.common.HibernateUtil;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;
import com.tsystems.javaschool.serverappl.dao.exceptions.UserRegistrationFailedException;
import com.tsystems.javaschool.serverappl.dao.hibernate.UserDAOImpl;

/**
 * @author Alexander Markov
 */
public class RegistrationService {
	/**
	 * @param request
	 * @return
	 */
	public static ServiceResponse service(ServiceRequest request) {
		List<?> payload = request.getPayload();
		try {
			Date birthDate = DateValidator.getInstance().validate(
					(String) payload.get(2), "yyyy-mm-dd");
			if (birthDate == null) {
				return new ServiceResponse(false, null,
						"Incorrect birth date format. Sample input: yyyy-mm-dd");
			}
			new UserDAOImpl()
					.registerUser((String) payload.get(4),
							(String) payload.get(5), (String) payload.get(3),
							(String) payload.get(0), (String) payload.get(1),
							birthDate);
		} catch (UserRegistrationFailedException e) {
			return new ServiceResponse(false, null,
					"Unable to register a new user. Please, try again later.");
		}
		return new ServiceResponse(true, null, "");
	}
}