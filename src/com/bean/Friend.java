package com.bean;


public class Friend {
	
	private PK_Friend pk_friend;
	
	public Friend() {
		
	}
	
	public Friend(PK_Friend pk_friend) {
		this.pk_friend = pk_friend;
	}

	public Friend(User user1, User user2) {
		this.pk_friend = new PK_Friend(user1, user2);
	}
	public PK_Friend getPk_friend() {
		return pk_friend;
	}

	public void setPk_friend(PK_Friend pk_friend) {
		this.pk_friend = pk_friend;
	}
	
	public User getUser1() {
		return this.pk_friend.getUser1();
	}

	public void setUser1(User user1) {
		this.pk_friend.setUser1(user1);
	}

	public User getUser2() {
		return this.pk_friend.getUser2();
	}

	public void setUser2(User user2) {
		this.pk_friend.setUser2(user2);
	}
}
