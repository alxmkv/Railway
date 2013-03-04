package com.tsystems.javaschool.common;

import java.util.List;

/**
 * Request to service
 * 
 * @author Alexander Markov
 */
public class ServiceRequest {
	private final RequestType type;
	private final List<?> payload;

	public ServiceRequest(RequestType type, List<?> payload) {
		this.type = type;
		this.payload = payload;
	}

	/**
	 * @return Request service type
	 */
	public RequestType getType() {
		return type;
	}

	/**
	 * @return Request parameters
	 */
	public List<?> getPayload() {
		return payload;
	}
} // class ServiceRequest