package com.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPin entity provides the base persistence definition of the Pin
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPin implements java.io.Serializable {

	// Fields

	private Integer pinid;
	private Board board;
	private Picture picture;
	private String note;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractPin() {
	}

	/** minimal constructor */
	public AbstractPin(Board board, Picture picture, Timestamp time) {
		this.board = board;
		this.picture = picture;
		this.time = time;
	}

	/** full constructor */
	public AbstractPin(Board board, Picture picture, String note,
			Timestamp time) {
		this.board = board;
		this.picture = picture;
		this.note = note;
		this.time = time;
	}

	// Property accessors

	public Integer getPinid() {
		return this.pinid;
	}

	public void setPinid(Integer pinid) {
		this.pinid = pinid;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}