package com.tsystems.javaschool.dao.entities;

/**
 * @author Alexander Markov
 */
public class Timetable {
	private Long timetableId;
	private Integer version;
	private Station station;
	private Train train;
	private String time;
	private Integer stationType;

	public Timetable() {
	}

	public Timetable(Station station, Train train, String time,
			Integer stationType) {
		this.station = station;
		this.train = train;
		this.time = time;
		this.stationType = stationType;
	}

	public Long getTimetableId() {
		return timetableId;
	}

	public void setTimetableId(Long timetableId) {
		this.timetableId = timetableId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getStationType() {
		return stationType;
	}

	public void setStationType(Integer stationType) {
		this.stationType = stationType;
	}
}