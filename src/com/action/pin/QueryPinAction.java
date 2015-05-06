package com.action.pin;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Pin;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.PinStat;

public class QueryPinAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4860795917874140266L;

	private PinService service;	
	
	private int pinid;
	private int bid;
	private int picnum;
	private String note;
	private int repin;
	private Date time;
	
	private int lastPinid;
	private Pin pin;
	private ArrayList<Pin> pinList;	
	private PinStat pinStat;
	private ArrayList<PinStat> pinStatList;
	
//	private int repinCount;
//	private int likeCount;
//	private int commentCount;
//	private ArrayList<Integer> repinCountList;
//	private ArrayList<Integer> likeCountList;
//	private ArrayList<Integer> commentCountList;
	
	//ArrayList<Triple<Integer, Integer, Integer>> pinStatList;
	
	@Transactional
	public String queryPinSummaryByPinid() {
		this.pin = this.service.findPinByPinid(pinid);
		if (pin == null) {
			addFieldError("message", "Error in find the target pin.");			
			return INPUT;
		}
		pinStat = service.pinBasicStatistic(pinid);
//		repinCount = pinStat[0];
//		likeCount = pinStat[1];
//		commentCount = pinStat[2];
		System.out.println(">>>>>>>>>>>>>>>>>> repin count: " + pinStat.getRepinCount());
		return SUCCESS;
	}
	
	
	
	@Transactional
	public String queryPinsByBid() {
		this.pinList = this.service.findPinByBid(bid);
		if (pinList != null && pinList.size()>0)  {	
			pinStatList = this.service.pinStatListByPinList(pinList);
			return SUCCESS;
		} 
		addFieldError("message", "The board is now empty! Please add a pin to it.");
		return INPUT;
	}
	
	
	@Transactional
	public String queryLatestPinSummaries() {
		if(lastPinid==0) {
			lastPinid = Integer.MAX_VALUE;
		}
		pinList = service.takePin(lastPinid);
		if (pinList != null && pinList.size()>0)  {	
			pinStatList = this.service.pinStatListByPinList(pinList);
			lastPinid = pinList.get(0).getPinid();
			return SUCCESS;
		} 
		addFieldError("message", "The board is now empty! Please add a pin to it.");
		return INPUT;
	}
	
	
	public int getPinid() {
		return pinid;
	}
	public void setPinid(int pinid) {
		this.pinid = pinid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getPicnum() {
		return picnum;
	}
	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getRepin() {
		return repin;
	}
	public void setRepin(int repin) {
		this.repin = repin;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PinService getService() {
		return service;
	}
	public void setService(PinService service) {
		this.service = service;
	}
	public ArrayList<Pin> getPinList() {
		return pinList;
	}
	public void setPinList(ArrayList<Pin> pinList) {
		this.pinList = pinList;
	}


	public Pin getPin() {
		return pin;
	}


	public void setPin(Pin pin) {
		this.pin = pin;
	}



	public PinStat getPinStat() {
		return pinStat;
	}



	public void setPinStat(PinStat pinStat) {
		this.pinStat = pinStat;
	}



	public ArrayList<PinStat> getPinStatList() {
		return pinStatList;
	}



	public void setPinStatList(ArrayList<PinStat> pinStatList) {
		this.pinStatList = pinStatList;
	}



	public int getLastPinid() {
		return lastPinid;
	}



	public void setLastPinid(int lastPinid) {
		this.lastPinid = lastPinid;
	}


//
//	public int getCommentCount() {
//		return commentCount;
//	}
//
//
//
//	public void setCommentCount(int commentCount) {
//		this.commentCount = commentCount;
//	}
//
//
//
//	public int getLikeCount() {
//		return likeCount;
//	}
//
//
//
//	public void setLikeCount(int likeCount) {
//		this.likeCount = likeCount;
//	}
//
//
//
//	public int getRepinCount() {
//		return repinCount;
//	}
//
//
//
//	public void setRepinCount(int repinCount) {
//		this.repinCount = repinCount;
//	}
	
}
