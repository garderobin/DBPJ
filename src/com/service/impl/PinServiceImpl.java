package com.service.impl;

import com.bean.Pin;
import com.dao.PinDAO;
import com.service.PinService;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	

	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}
	

	@Override
	public void save(Pin pin) {
		// TODO Auto-generated method stub
		
	}

}
