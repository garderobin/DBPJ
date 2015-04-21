package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.hibernate.HibernateException;

import com.util.ErrorType;
import com.bean.*;
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
	public int loginUser(String username, String password) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null){
			return 0;
		} else if (!user.getPassword().equals(password)) {
			return 1;
		}
		else {
		   return 2;	
		}
			
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
	public ErrorType addFriend(Friend friend) {
		Friend friendship = this.userDAO.findFriendship(friend.getUser1(), friend.getUser2());
		if (friendship == null) {
			this.userDAO.addFriend(friend);
			return ErrorType.NO_ERROR;			
		}
		return ErrorType.FRIENDSHIP_EXISTED;				
	}

	@Override
	public ErrorType deleteFriend(Friend friend) {
		try {
			this.userDAO.deleteFriend(friend);
		} catch (HibernateException he) {
			return ErrorType.DELETE_ERROR;
		} //addFriend and Delete Friend use two different error-handling methods.
		return ErrorType.NO_ERROR;
	}

	@Override
	public boolean checkFriendshipExist(String user1, String user2) {
		return (this.userDAO.findFriendship(user1, user2) != null);
	}
	
	@Override
	public ErrorType signInUser(User user){
		User user1 = this.userDAO.findUserByUsername(user.getUsername());
		if(user1 == null){
			this.userDAO.saveUser(user);
			return ErrorType.NO_ERROR;
		}
		return ErrorType.USERNAME_EXISTED;
	}


}
