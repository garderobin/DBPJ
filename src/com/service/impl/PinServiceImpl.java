package com.service.impl;

import java.util.Date;

import org.hibernate.HibernateException;

import com.bean.*;
import com.dao.PinDAO;
import com.service.PinService;
import com.util.ErrorType;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	

	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}
	
	@Override
	public ErrorType addBoard(String username, String bname){
		Board board = new Board();
		board.setUsername(username);
		board.setBname(bname);
		board.setTime(new Date());
		Board board1 = this.pinDAO.findBoardByUsernameBname(username, bname);
		if(board1 == null){
			this.pinDAO.addBoard(board);
			return ErrorType.NO_ERROR;
		}
		return ErrorType.BNAME_EXISTED;
	}
	
	@Override
	public ErrorType deleteBoard(Integer bid){
		Board board = this.pinDAO.findBoardByBid(bid);
		try{
			this.pinDAO.deleteBoard(board);
			return ErrorType.NO_ERROR;
		}
		catch(HibernateException he) {
			return ErrorType.DELETE_ERROR;
		}
	}
	
	@Override
	public ErrorType addPicture(Integer bid, String url, String sourceUrl){
		 return ErrorType.NO_ERROR;
	}

}
