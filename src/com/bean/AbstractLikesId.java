package com.bean;

/**
 * AbstractLikesId entity provides the base persistence definition of the
 * LikesId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLikesId implements java.io.Serializable {

	// Fields

	private String username;
	private Integer picnum;

	// Constructors

	/** default constructor */
	public AbstractLikesId() {
	}

	/** full constructor */
	public AbstractLikesId(String username, Integer picnum) {
		this.username = username;
		this.picnum = picnum;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPicnum() {
		return this.picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractLikesId))
			return false;
		AbstractLikesId castOther = (AbstractLikesId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getPicnum() == castOther.getPicnum()) || (this
						.getPicnum() != null && castOther.getPicnum() != null && this
						.getPicnum().equals(castOther.getPicnum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPicnum() == null ? 0 : this.getPicnum().hashCode());
		return result;
	}

}