package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.*;
import com.util.ErrorType;

public interface UserService {

	public void save(User user);

	public void update(User user);	
	
	public ErrorType loginUser(String username, String password);

	public boolean usernameExsit(String username);

	public boolean checkFriendshipExist(String user1, String user2);
	
	public int addFriend(String user1, String user2);
	
	public ErrorType deleteFriend(String user1, String user2);
	
	public ArrayList<User> findFriendsByUsername(String username);

	public ErrorType signInUser(String username, String password, String email);

	
}