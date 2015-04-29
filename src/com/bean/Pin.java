package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pin {
	private int pinid;
	private Board board;
	private Picture picture;
	private String discription;
	private Date time;
	private int repin;
	private Set<Comment> comments = 
			new HashSet<Comment>(0);

	public Pin(){
		
	}
	public Pin(int pinid, Board board, Picture picture, String discription, Date time, int repin){
		this.pinid = pinid;
		this.board = board;
		this.picture = picture;
		this.discription = discription;
		this.time = time;
		this.repin = repin;
	}
	public Pin(Board board, Picture picture, String discription, Date time, int repin){
		this.board = board;
		this.picture = picture;
		this.discription = discription;
		this.time = time;
		this.repin = repin;
	}

	public int getPinid() {
		return pinid;
	}

	public void setPinid(int pinid) {
		this.pinid = pinid;
	}


	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
 
	public int getRepin() {
		return repin;
	}
	public void setRepin(int repin) {
		this.repin = repin;
	}
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
