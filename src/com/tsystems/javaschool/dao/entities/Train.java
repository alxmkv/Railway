package com.tsystems.javaschool.dao.entities;

/**
 * @author Alexander Markov
 */
public class Train {
	private Long trainId;
	private Integer version;
	private Integer number;
	private String name;
	private Integer capacity;// number of seats

	public Train() {
	}

	public Train(Integer number, String name, Integer capacity) {
		this.number = number;
		this.name = name;
		this.capacity = capacity;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}