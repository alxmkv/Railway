package com.tsystems.javaschool.services;

/**
 * Response of service: result set of data
 * 
 * @author Alexander Markov
 */
public class ServiceResponse {
	private String data;
	private Boolean status;

	public ServiceResponse(String data, Boolean status) {
		this.data = data;
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public Boolean isOK() {
		return status;
	}
} // class ServiceResponse