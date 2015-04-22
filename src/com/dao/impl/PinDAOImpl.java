package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.PinDAO;
import com.bean.*;

public class PinDAOImpl implements PinDAO{

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public void addBoard(Board board){
		Session session = sessionFactory.openSession();
		session.save(board);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteBoard(Board board){
		Session session = sessionFactory.openSession();
		session.delete(board);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateBoard(Board board){
		Session session = sessionFactory.openSession();
		session.update(board);
		session.flush();
		session.close();
	}
	
	@Override
	public Board findBoardByBid(Integer bid){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Board)list.get(0);
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByUser(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public Board findBoardByUsernameBname(String username, String bname){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.username = '" + username + "' and board.bname = '" + bname + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Board) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByFollow(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Board(bid, board.username, bname, board.time) from Board board join Follow follow where follow.username = '" + username + "' and board.bid = follow.bid";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public Integer addPicture(Picture picture){
		Session session = sessionFactory.openSession();
		Integer picnum = (Integer) session.save(picture);
		session.flush();
		session.close();
		return picnum;
	}
	
	@Override
	public void deletePicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.delete(picture);
		session.flush();
		session.close();
	}
	
	@Override
	public void updatePicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.update(picture);
		session.flush();
		session.close();
	}
	
	@Override
	public ArrayList<Picture> findPictureByUser(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picnum, url, sourceurl) from Board board join Pin pin join Picture picture where board.username = '" + username + "' and board.bid = pin.bid and pin.picnum = picture.picnum";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByBoard(Integer bid){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picnum, url, sourceurl) from Pin pin join Picture picture where pin.bid = '" + bid + "' and pin.picnum = picture.picnum";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByLikes(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picnum, url, sourceurl) from Likes likes join Picture picture where likes.username = '" + username + "' and likes.picnum = picture.picnum";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	@Override
	public void addPin(Pin pin){
		Session session = sessionFactory.openSession();
		session.save(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public void deletePin(Pin pin){
		Session session = sessionFactory.openSession();
		session.delete(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public void updatePin(Pin pin){
		Session session = sessionFactory.openSession();
		session.update(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public void addFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.save(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.delete(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.update(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public ArrayList<User> findUserByFollow(Integer bid){
		Session session = sessionFactory.openSession();
		String hql = "select new User(user.username, password, email, time) from Follow follow join User user where follow.bid = '" + bid + "' and follow.username = user.username";
		Query query = session.createQuery(hql);
		ArrayList<User> list = (ArrayList<User>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	public ArrayList<Follow> findFollowByUser(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Follow> list = (ArrayList<Follow>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	@Override
	public void addComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.save(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.delete(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.update(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public ArrayList<Comment> findCommentByUser(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Comment> findCommentByPin(Integer pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>)query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}

}
