package com.service;

import java.util.ArrayList;

import com.bean.User;

public interface UserService {

	public void save(User user);

	public void update(User user);	
	
	public boolean checkUser(String username, String password);

	public boolean usernameExsit(String username);
	
	//public ArrayList<User> findFriendsByUsername(String username);
}
