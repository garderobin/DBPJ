package com.action.pin;

import java.util.Date;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Follow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class AddFollowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625438860588318525L;
	private PinService service;
	private Follow follow;
	private String stream;
	private Date time;
	private int bid;
	private int idfollow;

	
	@Override
	@Transactional
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		idfollow =  this.service.addFollow(username, bid, stream);
		if (idfollow < 0) {
			return INPUT;
		}
		return SUCCESS;		
	}
	
	public PinService getService() {
		return service;
	}
	public void setService(PinService service) {
		this.service = service;
	}
	public Follow getFollow() {
		return follow;
	}
	public void setFollow(Follow follow) {
		this.follow = follow;
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
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdfollow() {
		return idfollow;
	}

	public void setIdfollow(int idfollow) {
		this.idfollow = idfollow;
	}
	
	
}
