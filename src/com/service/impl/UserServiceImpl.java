package com.service.impl;

import java.util.List;
import java.util.ArrayList;
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
	public ErrorType loginUser(String username, String password) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null){
			return ErrorType.USER_NOT_EXIST;
		} else if (!user.getPassword().equals(password)) {
			return ErrorType.PASSWORD_NOT_MATCH;
		}
		else {
		   return ErrorType.NO_ERROR;	
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
	public ErrorType addFriend(String user1, String user2) {
		Friend friend = new Friend();
		User u1 = this.userDAO.findUserByUsername(user1);
		User u2 = this.userDAO.findUserByUsername(user2);
		friend.setUser1(u1);
		friend.setUser2(u2);
		Friend friendship = this.userDAO.findFriendship(user1, user2);
		if (friendship == null) {
			this.userDAO.addFriend(friend);
			return ErrorType.NO_ERROR;			
		}
		return ErrorType.FRIENDSHIP_EXISTED;				
	}
    
	//OK:
	@Override
	public ErrorType deleteFriend(String user1, String user2) {
		try {
			this.userDAO.deleteFriendByUsernames(user1,user2);
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
	public ErrorType signInUser(String username, String password, String email){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setTime(new Date());
		User user1 = this.userDAO.findUserByUsername(username);
		if(user1 == null){
			this.userDAO.saveUser(user);
			return ErrorType.NO_ERROR;
		}
		return ErrorType.USERNAME_EXISTED;
	}

}
