package com.bean;

import java.util.Date;

public class Comment {
	private String username;
	private Integer pinid;
	private String comment;
	private Date time;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPinid() {
		return pinid;
	}

	public void setPinid(Integer pinid) {
		this.pinid = pinid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
