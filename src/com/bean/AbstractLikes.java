package com.bean;

import java.sql.Timestamp;

/**
 * AbstractLikes entity provides the base persistence definition of the Likes
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLikes implements java.io.Serializable {

	// Fields

	private LikesId id;
	private User user;
	private Picture picture;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractLikes() {
	}

	/** full constructor */
	public AbstractLikes(LikesId id, User user, Picture picture, Timestamp time) {
		this.id = id;
		this.user = user;
		this.picture = picture;
		this.time = time;
	}

	// Property accessors

	public LikesId getId() {
		return this.id;
	}

	public void setId(LikesId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}