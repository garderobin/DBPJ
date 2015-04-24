package com.bean;

import java.util.Date;

public class Likes{
    private int idlikes;
	private User user;
	private Picture picture;
	private Date time;
	
	public Likes(){
		
	}
	public Likes(int idlikes, User user, Picture picture, Date time){
		this.idlikes = idlikes;
		this.user = user;
		this.picture = picture;
		this.time = time;
	}
	public Likes(User user, Picture picture, Date time){
		this.user = user;
		this.picture = picture;
		this.time = time;
	}
	
	public int getIdlikes() {
		return idlikes;
	}
	public void setIdlikes(int idlikes) {
		this.idlikes = idlikes;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Likes other = (	Likes) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}

	
}
