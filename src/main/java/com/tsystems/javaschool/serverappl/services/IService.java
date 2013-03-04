package com.tsystems.javaschool.serverappl.services;

import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * Interface for client DB services
 * 
 * @author Alexander Markov
 */
public interface IService {
	public ServiceResponse service(ServiceRequest request);
}