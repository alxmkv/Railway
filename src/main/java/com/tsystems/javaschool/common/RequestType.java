/**
 * 
 */
package com.tsystems.javaschool.common;

/**
 * List of available services to request
 * 
 * @author Alexander Markov
 */
public enum RequestType {
	// 1. Passenger services
	REGISTRATION, AUTHENTICATION, TRAINSBYSTATIONSANDTIME, TIMETABLEBYSTATION, TICKETORDER,
	// 2. Admin services
	STATIONADD, TRAINADD, PASSENGERSBYTRAIN, TRAINS, PASSENGERSEDIT
}