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
	public Board findBoardByBid(int bid){
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
	public List<Board> findBoardByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Board> list = query.list();
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
		String hql = "from Board board where board.user.username = '" + username + "' and board.bname = '" + bname + "'";
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
	public List<Board> findBoardByFollow(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Board(board.bid, board.user, board.bname, board.time) from Board board join board.follows follow "
				+ "where (follow.user.username = '" + username + "')";
		Query query = session.createQuery(hql);
		List<Board> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public void addPicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.save(picture);
		session.flush();
		session.close();
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
	public Picture findPictureByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Picture picture where picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Picture) list.get(0);
		}
	}
	
	@Override
	public List<Picture> findPictureByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) " +
				"from Board board join board.pins pin1 , Picture picture join picture.pins pin2 " +
				"where board.user.username = '" + username + "'and pin1.pinid = pin2.pinid";
		Query query = session.createQuery(hql);
		List<Picture> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public List<Picture> findPictureByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.pins pin" +
				" where pin.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List<Picture> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public List<Picture> findPictureByLikes(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.likes likes where likes.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Picture> list = query.list();
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
	public Pin findPinByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		List<Pin> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Pin) list.get(0);
		}
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
	public List<User> findUserByFollow(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new User(user.username, user.password, user.email, user.time) " +
				"from User user join user.follows follow where follow.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	public List<Follow> findFollowByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Follow> list = query.list();
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
	public List<Comment> findCommentByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Comment> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public List<Comment> findCommentByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		List<Comment> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public void addLikes(Likes likes){
		Session session = sessionFactory.openSession();
		session.save(likes);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteLikes(Likes likes){
		Session session = sessionFactory.openSession();
		session.delete(likes);
		session.flush();
		session.close();
	}
	
	@Override
	public List<Likes> findLikesByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Likes> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public List<Likes> findLikesByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List<Likes> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}

}
