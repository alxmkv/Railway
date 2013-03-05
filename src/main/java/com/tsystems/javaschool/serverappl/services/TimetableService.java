package com.tsystems.javaschool.serverappl.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.tsystems.javaschool.common.HibernateUtil;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * View timetable
 * 
 * @author Alexander Markov
 */
public class TimetableService {
	// private static final Logger logger = Logger
	// .getLogger(TimetableService.class);

	public static ServiceResponse service(ServiceRequest request) {
		List<?> payload = request.getPayload();
		List<?> results = null;
		try {
			HibernateUtil.beginTransaction();
			results = HibernateUtil
					.getSession()
					.createQuery(
							"SELECT t.time FROM Timetable t WHERE t.station = (SELECT s.id FROM Station s WHERE s.name = :station)")
					.setParameter("station", payload.get(0)).list();
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		if (results == null) {
			return new ServiceResponse(false, null, "Error while searching");
		}
		return new ServiceResponse(true, results, "");
	}
} // class TimetableService