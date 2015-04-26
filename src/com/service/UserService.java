package com.service;

import java.util.List;
import com.bean.*;
import com.util.ErrorType;

public interface UserService {

	public void save(User user);

	public void update(User user);	
	
	public ErrorType loginUser(String username, String password);

	public boolean usernameExsit(String username);
	
	/**
	 * Check whether two users are already friends.
	 * @param user1
	 * @param user2
	 * @return true if the two users are already friends in the database.
	 */
	public boolean checkFriendshipExist(String user1, String user2);
	
	public ErrorType addFriend(String user1, String user2);
	
	public ErrorType deleteFriend(String user1, String user2);
	
	public List<User> findFriendsByUsername(String username);

	public ErrorType signInUser(String username, String password, String email);

	
}