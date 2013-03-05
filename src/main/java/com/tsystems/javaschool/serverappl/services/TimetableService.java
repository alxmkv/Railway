package com.tsystems.javaschool.serverappl.services;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * View timetable
 * 
 * @author Alexander Markov
 */
public class TimetableService {
	private static final Logger logger = Logger
			.getLogger(TimetableService.class);

	// TODO: separate implementation and SQL queries (use DAO for JDBC)
	public static ServiceResponse service(ServiceRequest request) {
		logger.error("");
		return null;
	}
} // class TimetableService