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
	ArrayList<Board> boardList;
	
//	@Override
//	@Transactional
//	public String execute() throws Exception { //写来测试= =		
//		return null;		
//	}
	
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
						b.getUser().getUsername() + "\t" + b.getStream() + "\t");
			}
		}
		return SUCCESS;		
	}
	
	
	@Transactional
	public String queryBoardsByStream() {
		//TODO
		return null;
	}
	
	
	@Transactional
	public String queryBoardsByKeyword() {
		//TODO
		return null;
	}
	
	
	@Transactional
	public String queryBoardsByPicnum() {
		//TODO
		return null;
	}
	
	
	
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	
	
	public void setService(PinService service) {
		this.service = service;
	}

}
