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
	public void deleteUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.delete(user);
		session.flush();
		session.close();
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> findFriendsByUsername(String username) {
		Session session = sessionFactory.openSession();
		String hql = "select new User(username, password, email, time) from Friend friend join User user where (friend.user1 = '" + username + "' and friend.user2 = user.username) or (friend.user2 = '" + username + "' and friend.user1 = user.username)";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (ArrayList<User>) list;
		}
	}
	*/
	@Override
	public List<User> findFriendsByUsername(String username) {
		Session session = sessionFactory.openSession();
		//String hql = "select username, password, email, time from Friend friend join User user where (friend.user1 = '" + username + "' and friend.pk_friend.user2 = user.username) or (friend.pk_friend.user2 = '" + username + "' and friend.pk_friend.user1 = user.username)";
		//String hql = "select new User(u.username, u.password, u.email, u.time) from Friend f join User u where (f.user1 = '" + username + "' and f.user2 = u.username) or (f.user2 = '" + username + "' and f.user1 = u.username)";
		//String hql = "select new User(u.username, u.password, u.email, u.time) from Friend f join f.user1 u1 join f.user2 u2 where (f.user1 = '" + username + "' and f.user2 = u2.username) or (f.user2 = '" + username + "' and f.user1 = u1.username)";
		//String hql = "select new User(u.username, u.password, u.email, u.time) from User u join u.friendsForUser1 f1 join u.friendsForUser2 f2 where u.username = '" + username + "' and f1.user1 = u.username";
		String hql = "select new User(u.username, u.password, u.email, u.time) from User u join u.friendsForUser1 f1 join u.friendsForUser2 f2 where" + 
				" (f1.user2 = '" + username + "' and f1.user1 = u.username) or" + 
				" (f2.user1 = '" + username + "' and f2.user2 = u.username)";
		
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return  list;
		}
	}
	
	@Override
	public void addFriend(Friend friend) {
		Session session = sessionFactory.openSession();
		session.save(friend);
		session.flush();
		session.close();
		
	}

	/*
	@Override
	public void deleteFriend(Friend friend) {
		Session session = sessionFactory.openSession();
		session.delete(friend);
		session.flush();
		session.close();		
	}*/
	
	@Override
	public void deleteFriend(Friend friend) {
		String user1 = friend.getUser1().getUsername();
		String user2 = friend.getUser2().getUsername();
		Session session = sessionFactory.openSession();
		String hql = "delete from Friend f where (user1 = '" + user1 + "' and user2 = '" + user2 + 
				"') or (user1 = '" + user2 + "' and user2 = '" + user1 + "')";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();		
	}

	@Override
	public Friend findFriendship(String user1, String user2) {
		Session session = sessionFactory.openSession();
		String hql = "from Friend friend where (friend.user1 = '" + user1 + "' and friend.user2 = '" + user2 + "') or (friend.user2 = '" + user1 + "' and friend.user1 = '" + user2 + "')";
		Query query = session.createQuery(hql);
		List<Friend> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Friend)list.get(0);
		}
	}

	@Override
	public void deleteFriendByUsernames(String username1, String username2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriendByIdFriend(int idfriend) {
		// TODO Auto-generated method stub
		
	}
	
	
}
