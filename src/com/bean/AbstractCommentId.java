package com.bean;

/**
 * AbstractCommentId entity provides the base persistence definition of the
 * CommentId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCommentId implements java.io.Serializable {

	// Fields

	private String username;
	private Integer pinid;

	// Constructors

	/** default constructor */
	public AbstractCommentId() {
	}

	/** full constructor */
	public AbstractCommentId(String username, Integer pinid) {
		this.username = username;
		this.pinid = pinid;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPinid() {
		return this.pinid;
	}

	public void setPinid(Integer pinid) {
		this.pinid = pinid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractCommentId))
			return false;
		AbstractCommentId castOther = (AbstractCommentId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getPinid() == castOther.getPinid()) || (this
						.getPinid() != null && castOther.getPinid() != null && this
						.getPinid().equals(castOther.getPinid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPinid() == null ? 0 : this.getPinid().hashCode());
		return result;
	}

}