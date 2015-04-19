package com.bean;

import java.io.Serializable;

public class Friend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3739651636980475697L;
	private String user1;
	private String user2;
	public String getUser1() {
		return user1;
	}
	public void setUser1(String user1) {
		this.user1 = user1;
	}
	public String getUser2() {
		return user2;
	}
	public void setUser2(String user2) {
		this.user2 = user2;
	}
	
	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user1 == null) ? 0 : user1.hashCode());
        result = prime * result + ((user2 == null) ? 0 : user2.hashCode());
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
        Friend other = (Friend) obj;
        if (user1 == null)
        {
            if (other.user1 != null)
                return false;
        }
        else if (!user1.equals(other.user1))
            return false;
        if (user2 == null)
        {
            if (other.user2 != null)
                return false;
        }
        else if (!user2.equals(other.user2))
            return false;
        return true;
    }

}
