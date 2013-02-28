package com.tsystems.javaschool.dao.entities;

/**
 * @author Alexander Markov
 */
public class Station {
	private Long stationId;
	private Integer version;
	private String name;

	public Station() {
	}

	public Station(String name) {
		this.name = name;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}