package com.tsystems.javaschool.serverappl.services;

import java.util.ArrayList;
import java.util.List;

import com.tsystems.javaschool.common.RequestType;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * Service invocation
 * 
 * @author Alexander Markov
 */
public class ServiceLocator {

	public static ServiceResponse service(ServiceRequest request) {
		RequestType type = request.getType();
		ServiceResponse response = null;
		if (type == RequestType.REGISTRATION) {
			response = RegistrationService.service(request);
			System.out.println("REGISTRATION request");
		} else if (type == RequestType.AUTHENTICATION) {
			response = AuthenticationService.service(request);
			System.out.println("AUTHENTICATION request");
		} else if (type == RequestType.TRAINSBYSTATIONSANDTIME) {

		} else if (type == RequestType.TIMETABLEBYSTATION) {

		} else if (type == RequestType.TICKETORDER) {

		} else if (type == RequestType.STATIONADD) {

		} else if (type == RequestType.TRAINADD) {

		} else if (type == RequestType.PASSENGERSBYTRAIN) {

		} else if (type == RequestType.TRAINS) {

		} else if (type == RequestType.PASSENGERSEDIT) {

		}
		List<String> result = new ArrayList<String>(1);
		result.add("Response from server");
		// new ServiceResponse(true, result, "")
		return response;
	}
}