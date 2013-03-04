package com.tsystems.javaschool.common.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;

/**
 * The persistent class for the timetable database table.
 * 
 */
@Entity
@Table(name = "timetable")
public class Timetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false)
	private String id;

	@Column(name = "station_type")
	private byte stationType;

	@Column(nullable = false)
	private Time time;

	// bi-directional many-to-one association to Station
	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	private Station station;

	// bi-directional many-to-one association to Train
	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	public Timetable() {
	}

	public Timetable(Station station, Train train, Time time) {
		this.station = station;
		this.train = train;
		this.time = time;
	}

	public Timetable(Station station, Train train, Time time, byte stationType) {
		this.station = station;
		this.train = train;
		this.time = time;
		this.stationType = stationType;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getStationType() {
		return this.stationType;
	}

	public void setStationType(byte stationType) {
		this.stationType = stationType;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

}