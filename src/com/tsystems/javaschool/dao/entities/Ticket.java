package com.tsystems.javaschool.dao.entities;

/**
 * @author Alexander Markov
 */
public class Ticket {
	private Long ticketId;
	private Integer version;
	private User passenger;
	private Train train;

	public Ticket() {
	}

	public Ticket(User passenger, Train train) {
		this.passenger = passenger;
		this.train = train;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}
}