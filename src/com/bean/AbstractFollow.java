package com.bean;

import java.sql.Timestamp;

/**
 * AbstractFollow entity provides the base persistence definition of the Follow
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFollow implements java.io.Serializable {

	// Fields

	private FollowId id;
	private Board board;
	private User user;
	private String stream;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractFollow() {
	}

	/** minimal constructor */
	public AbstractFollow(FollowId id, Board board, User user, Timestamp time) {
		this.id = id;
		this.board = board;
		this.user = user;
		this.time = time;
	}

	/** full constructor */
	public AbstractFollow(FollowId id, Board board, User user, String stream,
			Timestamp time) {
		this.id = id;
		this.board = board;
		this.user = user;
		this.stream = stream;
		this.time = time;
	}

	// Property accessors

	public FollowId getId() {
		return this.id;
	}

	public void setId(FollowId id) {
		this.id = id;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStream() {
		return this.stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}