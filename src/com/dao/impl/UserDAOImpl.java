package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Friend;
import com.bean.User;
import com.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public User findUserByUsername(String username){
		
		Session session = sessionFactory.openSession();
		String hql = "from User user where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (User)list.get(0);
		}
	}

	@Override
	public void saveUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
	}

	@Override
	public void updateUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.update(user);
		session.flush();
		session.close();
	}

	@Override
	public ArrayList<User> findFriendsByUsername(String username) {
		Session session = sessionFactory.openSession();
		String hql = "select User user from Friend friend join User user where (friend.user1 = '" + username + "' and friend.user2 = user.username) or (friend.user2 = '" + username + "' and friend.user1 = user.username)";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (ArrayList<User>)list.get(0);
		}
	}

	@Override
	public void addFriend(String user1, String user2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriend(String user1, String user2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Friend findFriendship(String user1, String user2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	@Override
	public String find_note_of_user(Integer userid) {
		Session session = sessionFactory.openSession();
		String hql = "select note from User user where userid = " + userid;
		Query query = session.createQuery(hql);
		String res = (String)query.uniqueResult();
		session.close();
		return res;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User findUserByUserid(Integer userid) {
		Session session = sessionFactory.openSession();
		String hql = "from User user where user.userid = '" + userid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (User)list.get(0);
		}
	}
	*/
}
