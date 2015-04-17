package com.dao;

import com.bean.User;

public interface UserDAO {
	public void saveUser(User user);
	
	public User findUserByUsername(String username);	

	public void updateUser(User user);	

}
