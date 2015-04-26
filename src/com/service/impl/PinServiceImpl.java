package com.service.impl;

import java.util.Date;

import org.hibernate.HibernateException;

import com.bean.*;
import com.dao.PinDAO;
import com.dao.UserDAO;
import com.service.PinService;
import com.util.ErrorType;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	
	
	private UserDAO userDAO;		
	
	
	@Override
	public ErrorType addBoard(String username, String bname) {
     	Board board = new Board();
     	User user = this.userDAO.findUserByUsername(username); 
     	if (user==null) {
     		return ErrorType.USER_IS_NOT_INFOPROVIDER; //TODO
     	}
		board.setUser(user);
		board.setBname(bname);
		board.setTime(new Date());
		Board board1 = this.pinDAO.findBoardByUsernameBname(username, bname);
		if (board1!=null) {
			return ErrorType.BOARD_EXISTED;
		}
		try {
			this.pinDAO.addBoard(board);
		} catch(Exception e) {
			e.printStackTrace();
			return ErrorType.BNAME_EXISTED;
		}
     	
		return ErrorType.NO_ERROR;
	}
		
	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
    
