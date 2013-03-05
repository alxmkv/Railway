package com.tsystems.javaschool.common.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigInteger;
import java.util.Set;

/**
 * The persistent class for the trains database table.
 * 
 */
@Entity
@Table(name = "trains")
public class Train implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private BigInteger capacity;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = false)
	private BigInteger number;

	// bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
	private Set<Ticket> tickets;

	// bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
	private Set<Timetable> timetables;

	public Train() {
	}

	public Train(BigInteger number, String name, BigInteger capacity) {
		this.number = number;
		this.name = name;
		this.capacity = capacity;
	}

	public Train(BigInteger number, String name, BigInteger capacity,
			Set<Timetable> timetables, Set<Ticket> tickets) {
		this.number = number;
		this.name = name;
		this.capacity = capacity;
		this.timetables = timetables;
		this.tickets = tickets;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigInteger capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getNumber() {
		return this.number;
	}

	public void setNumber(BigInteger number) {
		this.number = number;
	}

	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Set<Timetable> getTimetables() {
		return this.timetables;
	}

	public void setTimetables(Set<Timetable> timetables) {
		this.timetables = timetables;
	}

}