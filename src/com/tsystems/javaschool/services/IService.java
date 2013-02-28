package com.tsystems.javaschool.services;

/**
 * Interface for client DB services
 * 
 * @author Alexander Markov
 */
public interface IService {
	public ServiceResponse service(ServiceRequest request);
}