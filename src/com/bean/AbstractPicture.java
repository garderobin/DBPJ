package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPicture entity provides the base persistence definition of the
 * Picture entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPicture implements java.io.Serializable {

	// Fields

	private Integer picnum;
	private String url;
	private String sourceUrl;

	// Constructors

	/** default constructor */
	public AbstractPicture() {
	}

	/** full constructor */
	public AbstractPicture(String url, String sourceUrl) {
		this.url = url;
		this.sourceUrl = sourceUrl;
	}

	// Property accessors

	public Integer getPicnum() {
		return this.picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	
}