package com.tsystems.javaschool.services;

import java.util.List;

/**
 * Request to service
 * 
 * @author Alexander Markov
 */
public class ServiceRequest {
	private List<?> parameters;
	private Integer length;

	public ServiceRequest(List<?> parameters, Integer length) {
		this.parameters = parameters;
		this.length = length;
	}

	public List<?> getParameters() {
		return parameters;
	}

	public Integer getLength() {
		return length;
	}
} // class ServiceRequest