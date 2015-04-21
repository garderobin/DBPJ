package com.service.impl;

import com.bean.Pin;
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
			
	public ErrorType addBoard(String username, String bname){
		return ErrorType.NO_ERROR;
	}
	

}
