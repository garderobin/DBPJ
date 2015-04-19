package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Likes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2576733379796866068L;
	private String username;
	private Integer picnum;
	private Date time;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPicnum() {
		return picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((picnum == null) ? 0 : picnum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Likes other = (Likes) obj;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        if (picnum == null)
        {
            if (other.picnum != null)
                return false;
        }
        else if (!picnum.equals(other.picnum))
            return false;
        return true;
    }

	
}
