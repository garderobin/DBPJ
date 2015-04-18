package com.service.impl;

import com.bean.User;
import com.dao.UserDAO;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;

	public UserDAO getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDAO userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public void save(User user)
	{
		this.userDao.saveUser(user);
	}

	@Override
	public void update(User user)
	{
		this.userDao.updateUser(user);
	}

	@Override
	public boolean checkUser(String username, String password) {
		User user = this.userDao.findUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		else
			return false;
	}	
	
	@Override
	public boolean usernameExsit(String username) {
		User user = this.userDao.findUserByUsername(username);
		if (user == null ) {
			return false;
		}
		return true;
	}
	
	
}
