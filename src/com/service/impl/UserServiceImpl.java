package com.service.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.util.ErrorType;
import com.bean.Friend;
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
	public int checkUser(String username, String password) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null){
			return 0;
		} else if (!user.getPassword().equals(password)) {
			return 1;
		}
		else
			return 2;
	}	
	
	@Override
	public boolean usernameExsit(String username) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null ) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<User> findFriendsByUsername(String username) {
		ArrayList<User> friends = this.userDAO.findFriendsByUsername(username);
		return friends;
	}

	@Override
	public ErrorType addFriend(String user1, String user2) {
		Friend friendship = this.userDAO.findFriendship(user1, user2);
		if (friendship == null) {
			this.userDAO.addFriend(user1, user2);
			return ErrorType.FRIENDSHIP_EXISTED;
		}
		return ErrorType.NO_ERROR;
				
	}

	@Override
	public ErrorType deleteFriend(String user1, String user2) {
		try {
			this.userDAO.deleteFriend(user1, user2);
		} catch (HibernateException he) {
			return ErrorType.DELETE_ERROR;
		} //addFriend and Delete Friend use two different error-handling methods.
		return ErrorType.NO_ERROR;
	}

	@Override
	public boolean checkFriendshipExist(String user1, String user2) {
		return (this.userDAO.findFriendship(user1, user2) != null);
	}
	
	
}
