package com.tsystems.javaschool.common.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthdate;

	@Column(nullable = false, length = 32)
	private String email;

	@Column(nullable = false, length = 32)
	private String login;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = false, length = 32)
	private String password;

	@Column(name = "status")
	private byte status;

	@Column(nullable = false, length = 32)
	private String surname;

	@Column(name = "ts_login", nullable = false)
	private Timestamp tsLogin;

	@Column(name = "user_type")
	private byte userType;

	// bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Ticket> tickets;

	public User() {
	}

	public User(String login, String passwordHash, String email, String name,
			String surname, Date birthdate) {
		this.login = login;
		this.password = passwordHash;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}

	public User(String login, String password, String email, String name,
			String surname, Date birthdate, byte userType, byte status) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.userType = userType;
		this.status = status;
	}

	public User(String login, String password, String email, String name,
			String surname, Date birthdate, byte userType, byte status,
			Timestamp tsLogin, Set<Ticket> tickets) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.userType = userType;
		this.status = status;
		this.tsLogin = tsLogin;
		this.tickets = tickets;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Timestamp getTsLogin() {
		return this.tsLogin;
	}

	public void setTsLogin(Timestamp tsLogin) {
		this.tsLogin = tsLogin;
	}

	public byte getUserType() {
		return this.userType;
	}

	public void setUserType(byte userType) {
		this.userType = userType;
	}

	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}