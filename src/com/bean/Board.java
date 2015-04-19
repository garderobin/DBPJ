package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Board {
	private Integer bid;
	private String username;
	private String bname;
	private Date time;
	private Set<Pin> pins = 
			new HashSet<Pin>(0);
	private Set<Follow> follows = 
			new HashSet<Follow>(0);

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Pin> getPins() {
		return pins;
	}

	public void setPins(Set<Pin> pins) {
		this.pins = pins;
	}

	public Set<Follow> getFollows() {
		return follows;
	}

	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}
	
	
}
