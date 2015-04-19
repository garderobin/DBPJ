package com.bean;

/**
 * CommentId entity. @author MyEclipse Persistence Tools
 */
public class CommentId extends AbstractCommentId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CommentId() {
	}

	/** full constructor */
	public CommentId(String username, Integer pinid) {
		super(username, pinid);
	}

}
