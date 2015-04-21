package com.dao;

import java.util.ArrayList;

import com.bean.Friend;
import com.bean.User;

public interface UserDAO {
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User findUserByUsername(String username);	
	
	//Before insertion , check whether the friendship already exists.
	public void addFriend(String user1, String user2);
	
	//Before deletion , check whether the friendship already exists.
	//Or you can 
	public void deleteFriend(String user1, String user2);
	
	/**
	 * Check whether two users are already friends.
	 * @param user1
	 * @param user2
	 * @return true if the two users are already friends in the database.
	 */
	public Friend findFriendship(String user1, String user2);

	//See Java API document for the usage for ArrayList.
	public ArrayList<User> findFriendsByUsername(String username);
	
}
