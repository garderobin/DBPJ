package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Follow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2846885508621128786L;
	private String username;
	private Integer bid;
	private String stream;
	private Date time;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
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
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
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
        Follow other = (Follow) obj;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        if (bid == null)
        {
            if (other.bid != null)
                return false;
        }
        else if (!bid.equals(other.bid))
            return false;
        return true;
    }


}
