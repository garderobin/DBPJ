package com.bean;

import java.util.Date;

public class Follow {
	/**
	 * 
	 */
	private int idfollow;
	private User user;
	private Board board;
	private String stream;
	private Date time;
	
	public Follow(){
		
	}
	public Follow(int idfollow, User user, Board board, String stream, Date time){
		this.idfollow = idfollow;
		this.user = user;
		this.board = board;
		this.stream = stream;
		this.time = time;
	}
	
	public Follow(User user, Board board, String stream, Date time){
		this.user = user;
		this.board = board;
		this.stream = stream;
		this.time = time;
	}
	
	
	public int getIdfollow() {
		return idfollow;
	}
	public void setIdfollow(int idfollow) {
		this.idfollow = idfollow;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follow other = (	Follow) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		return true;
	}


}
