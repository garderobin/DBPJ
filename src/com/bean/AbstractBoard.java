package com.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBoard entity provides the base persistence definition of the Board
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBoard implements java.io.Serializable {

	// Fields

	private Integer bid;
	private User user;
	private String bname;
	private Timestamp time;
	private Set pins = new HashSet(0);
	private Set follows = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBoard() {
	}

	/** minimal constructor */
	public AbstractBoard(User user, String bname, Timestamp time) {
		this.user = user;
		this.bname = bname;
		this.time = time;
	}

	/** full constructor */
	public AbstractBoard(User user, String bname, Timestamp time, Set pins,
			Set follows) {
		this.user = user;
		this.bname = bname;
		this.time = time;
		this.pins = pins;
		this.follows = follows;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getPins() {
		return this.pins;
	}

	public void setPins(Set pins) {
		this.pins = pins;
	}

	public Set getFollows() {
		return this.follows;
	}

	public void setFollows(Set follows) {
		this.follows = follows;
	}

}