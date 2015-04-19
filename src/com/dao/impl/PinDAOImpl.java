package com.dao.impl;

import org.hibernate.SessionFactory;
import com.bean.Pin;
import com.dao.PinDAO;

public class PinDAOImpl implements PinDAO{

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public boolean addPin(Pin pin) {
		// TODO Auto-generated method stub
		return false;
	}

}
