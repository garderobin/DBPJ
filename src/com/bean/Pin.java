package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pin {
	private Integer pinid;
	private Integer bid;
	private Integer picnum;
	private String note;
	private Date time;
	private Boolean repin;
	private Set<Comment> comments = 
			new HashSet<Comment>(0);

	public Integer getPinid() {
		return pinid;
	}

	public void setPinid(Integer pinid) {
		this.pinid = pinid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getPicnum() {
		return picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Boolean getRepin() {
		return repin;
	}

	public void setRepin(Boolean repin) {
		this.repin = repin;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
