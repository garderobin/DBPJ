package com.bean;

/**
 * AbstractFollowId entity provides the base persistence definition of the
 * FollowId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFriendId implements java.io.Serializable {

	// Fields

	private String user1;
	private String user2;

	// Constructors

	/** default constructor */
	public AbstractFriendId() {
	}

	/** full constructor */
	public AbstractFriendId(String user1, String user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	// Property accessors

	

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractFriendId))
			return false;
		AbstractFriendId castOther = (AbstractFriendId) other;

		return ((this.getUser1() == castOther.getUser1()) || (this
				.getUser1() != null && castOther.getUser1() != null && this
				.getUser1().equals(castOther.getUser1())))
				&& ((this.getUser2() == castOther.getUser2()) || (this.getUser2() != null
						&& castOther.getUser2() != null && this.getUser2().equals(
						castOther.getUser2())));
	}

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

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser1() == null ? 0 : this.getUser1().hashCode());
		result = 37 * result
				+ (getUser2() == null ? 0 : this.getUser2().hashCode());
		return result;
	}

}