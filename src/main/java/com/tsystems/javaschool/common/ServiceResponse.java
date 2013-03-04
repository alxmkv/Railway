package com.tsystems.javaschool.common;

import java.util.List;

/**
 * Response of service: result set of data
 * 
 * @author Alexander Markov
 */
public class ServiceResponse {

	private final Boolean status;
	private final List<?> payload;
	private final String exception;

	public ServiceResponse(Boolean status, List<?> payload, String exception) {
		this.status = status;
		this.payload = payload;
		this.exception = exception;
	}

	/**
	 * @return True if request was successful, false otherwise
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @return Requested data, null if status is false
	 */
	public List<?> getPayload() {
		return payload;
	}

	/**
	 * @return Exception string if status is false, null otherwise
	 */
	public String getException() {
		return exception;
	}
} // class ServiceResponse