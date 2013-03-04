package com.tsystems.javaschool.common.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the tickets database table.
 * 
 */
@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	// bi-directional many-to-one association to Train
	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Ticket() {
	}

	public Ticket(User user, Train train, Date date) {
		this.user = user;
		this.train = train;
		this.date = date;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}