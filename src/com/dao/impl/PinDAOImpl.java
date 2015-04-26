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
	public ArrayList<Board> findBoardByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
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
	public ArrayList<Board> findBoardByFollow(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Board(board.bid, board.user, board.bname, board.time) from Board board join board.follows follow "
				+ "where (follow.user.username = '" + username + "')";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
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
	public ArrayList<Picture> findPictureByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) " +
				"from Board board join board.pins pin1 , Picture picture join picture.pins pin2 " +
				"where board.user.username = '" + username + "'and pin1.pinid = pin2.pinid";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.pins pin" +
				" where pin.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
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
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.likes likes where likes.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
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
	public Pin findPinByBidPicnum(int bid, int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.board.bid = '" + bid + "' and pin.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List<Pin> list = query.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}
		else{
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
	public Follow findFollowByIdfollow(int idfollow){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.idfollow = '" + idfollow + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.clear();
		if(list.isEmpty())
			return null;
		else
			return (Follow) list.get(0);
	}
	
	@Override
	public Follow findFollowByUsernameBid(String username, int bid){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.user.username = '" + username + "' and follow.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if(list.isEmpty())
			return null;
		else
			return (Follow) list.get(0);
	}
	
	@Override
	public ArrayList<User> findUserByFollow(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new User(user.username, user.password, user.email, user.time) " +
				"from User user join user.follows follow where follow.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		ArrayList<User> list = (ArrayList<User>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	public ArrayList<Follow> findFollowByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Follow> list = (ArrayList<Follow>) query.list();
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
	public Comment findCommentByCid(int cid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.cid = '" + cid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Comment) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Comment> findCommentByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Comment> findCommentByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>) query.list();
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
	public Likes findLikesByUsernamePicnum(String username, int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.user.username = '" + username + "' and likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Likes) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Likes> findLikesByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Likes> list = (ArrayList<Likes>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Likes> findLikesByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		ArrayList<Likes> list = (ArrayList<Likes>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}

}
