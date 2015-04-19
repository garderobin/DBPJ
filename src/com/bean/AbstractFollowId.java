package com.bean;

/**
 * AbstractFollowId entity provides the base persistence definition of the
 * FollowId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFollowId implements java.io.Serializable {

	// Fields

	private String username;
	private Integer bid;

	// Constructors

	/** default constructor */
	public AbstractFollowId() {
	}

	/** full constructor */
	public AbstractFollowId(String username, Integer bid) {
		this.username = username;
		this.bid = bid;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractFollowId))
			return false;
		AbstractFollowId castOther = (AbstractFollowId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getBid() == castOther.getBid()) || (this.getBid() != null
						&& castOther.getBid() != null && this.getBid().equals(
						castOther.getBid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getBid() == null ? 0 : this.getBid().hashCode());
		return result;
	}

}