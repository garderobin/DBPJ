package com.bean;

import java.sql.Timestamp;

/**
 * AbstractComment entity provides the base persistence definition of the
 * Comment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComment implements java.io.Serializable {

	// Fields

	private CommentId id;
	private User user;
	private Pin pin;
	private String comment;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractComment() {
	}

	/** full constructor */
	public AbstractComment(CommentId id, User user, Pin pin, String comment,
			Timestamp time) {
		this.id = id;
		this.user = user;
		this.pin = pin;
		this.comment = comment;
		this.time = time;
	}

	// Property accessors

	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pin getPin() {
		return this.pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}