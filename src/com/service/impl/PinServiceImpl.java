package com.service.impl;

import com.bean.*;
import com.dao.PinDAO;
import com.service.PinService;
import com.util.ErrorType;
import java.util.*;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	

	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}
	
	@Override
	public ErrorType addBoard(Board board){
		String username = board.getUsername();
		String bname = board.getBname();
		List<Board> board1 = this.pinDAO.findBoardByUsernameBname(username, bname);
		if (board1 != null){
			return ErrorType.BOARD_EXISTED;
			}
		else {
			this.pinDAO.addBoard(board);
			return ErrorType.NO_ERROR;
		}		
	}
	

}
