package com.util;

public class PinStat {
	private int pinid;
	private int repinCount;
	private int likeCount;
	private int commentCount;
	
	public PinStat() {
		
	}
	
	public PinStat(int pinid, int repinCount, int likeCount, int commentCount) {
		this.pinid = pinid;
		this.repinCount = repinCount;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
	}
	
	public int getRepinCount() {
		return repinCount;
	}
	public void setRepinCount(int repinCount) {
		this.repinCount = repinCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getPinid() {
		return pinid;
	}

	public void setPinid(int pinid) {
		this.pinid = pinid;
	}
	
	
}
