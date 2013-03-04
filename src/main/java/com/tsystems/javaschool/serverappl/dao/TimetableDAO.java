package com.tsystems.javaschool.serverappl.dao;

import java.util.List;

import com.tsystems.javaschool.common.entities.Station;
import com.tsystems.javaschool.common.entities.Timetable;

/**
 * @author Alexander Markov
 */
public interface TimetableDAO {
	/**
	 * @param stationA
	 * @param stationB
	 * @param timeFrom
	 * @param timeTo
	 * @return List of trains going from station A to station B in a fixed time
	 *         interval
	 */
	public List<Timetable> getTrainsFromAToBInTimeInterval(Station stationA,
			Station stationB, String timeFrom, String timeTo);

	/**
	 * @param station
	 * @return List of trains for a fixed station
	 */
	public List<Timetable> getTrainsByStation(Station station);
}
