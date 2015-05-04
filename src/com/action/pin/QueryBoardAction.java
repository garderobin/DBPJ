package com.action.pin;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Board;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class QueryBoardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1102697508491177891L;
	private PinService service;
	private int bid;
	private String info;
	private String keyword;
	private int picnum;
	
	
	private Board board;
	private ArrayList<Board> boardList;
	
	private int pinCount;
	private int followerCount;
	private String stream;
	
	
//	@Override
//	@Transactional
//	public String execute() throws Exception { //写来测试= =		
//		return null;		
//	}
	
	@Transactional
	public String queryBoardByBid() {		
		this.board = this.service.findBoardByBid(bid);
		if (this.board!=null) {
			pinCount = board.getPins().size();
			followerCount = board.getFollows().size();
			return SUCCESS;
			
		}
		else
			return "No board";		
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public String queryBoardsByUsername() {		
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.boardList = this.service.findBoardByUsername(username);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
				
	}
	
	
	@Transactional
	public String queryBoardsByStream() {
		this.boardList = this.service.findBoardByStream(stream);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
		
	}
	
	
	@Transactional
	public String queryBoardsByKeyword() {
		this.boardList = this.service.findBoardByKeyword(keyword);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
	}
	
	
	@Transactional
	public String queryBoardsByPicnum() {
		this.boardList = this.service.findBoardByPicnum(picnum);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
	}
	
	
	
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	
	
	public void setService(PinService service) {
		this.service = service;
	}

	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public int getPicnum() {
		return picnum;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}

	public int getPinCount() {
		return pinCount;
	}

	public void setPinCount(int pinCount) {
		this.pinCount = pinCount;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

}
