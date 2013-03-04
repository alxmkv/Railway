package com.tsystems.javaschool.common.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

/**
 * The persistent class for the stations database table.
 * 
 */
@Entity
@Table(name = "stations")
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false)
	private String id;

	@Column(nullable = false, length = 32)
	private String name;

	// bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy = "station", fetch = FetchType.EAGER)
	private Set<Timetable> timetables;

	public Station() {
	}

	public Station(String name) {
		this.name = name;
	}

	public Station(String name, Set<Timetable> timetables) {
		this.name = name;
		this.timetables = timetables;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Timetable> getTimetables() {
		return this.timetables;
	}

	public void setTimetables(Set<Timetable> timetables) {
		this.timetables = timetables;
	}

}