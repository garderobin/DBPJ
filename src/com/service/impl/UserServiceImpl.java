package com.service.impl;

import com.bean.User;
import com.dao.UserDAO;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	@Override
	public void save(User user)
	{
		this.userDAO.saveUser(user);
	}

	@Override
	public void update(User user)
	{
		this.userDAO.updateUser(user);
	}

	@Override
	public boolean checkUser(String username, String password) {
		User user = this.userDAO.findUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		else
			return false;
	}	
	
	@Override
	public boolean usernameExsit(String username) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null ) {
			return false;
		}
		return true;
	}
	
	
}
