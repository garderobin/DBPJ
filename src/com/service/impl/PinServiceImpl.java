package com.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;

import com.bean.*;
import com.dao.PinDAO;
import com.dao.UserDAO;
import com.service.PinService;
import com.util.ErrorType;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	
	
	private UserDAO userDAO;	

	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public ErrorType addBoard(String username, String bname, String stream) {
     	Board board = new Board();
     	User user = this.userDAO.findUserByUsername(username);
     	if(user == null){
     		return ErrorType.USER_NOT_EXIST;
     	}
     	board.setUser(user);
		board.setBname(bname);
		board.setStream(stream);
		board.setTime(new Date());
		Board board1 = this.pinDAO.findBoardByUsernameBname(username, bname);
		if (board1!=null) {
			return ErrorType.BOARD_EXISTED;
		}
		try {
			this.pinDAO.addBoard(board);
		} catch(Exception e) {
			e.printStackTrace();
			return ErrorType.BNAME_EXISTED;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType deleteBoard(int bid){
		Board board = this.pinDAO.findBoardByBid(bid);
		try{
			this.pinDAO.deleteBoard(board);
		} catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;		
	}
	
	@Override
	public ErrorType updateBoard(int bid, String bname, String stream){
		Board board = pinDAO.findBoardByBid(bid);
		board.setBname(bname);
		board.setStream(stream);
		try{
			pinDAO.updateBoard(board);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Board findBoardByBid(int bid){
		Board board = pinDAO.findBoardByBid(bid);
		return board;
	}
	
	@Override
	public ArrayList<Board> findBoardByUsername(String username){
		ArrayList<Board> boards = pinDAO.findBoardByUsername(username);
		return boards;
	}
	
	@Override
	public Board findBoardByUsernameBname(String username, String bname){
		Board board = pinDAO.findBoardByUsernameBname(username, bname);
		return board;
	}
	
	@Override
	public ArrayList<Board> findBoardByFollow(String username){
		ArrayList<Board> boards = pinDAO.findBoardByFollow(username);
		return boards;
	}
	
	@Override
	public ErrorType addPicture(String url, String sourceUrl){
		Picture picture = new Picture();
		picture.setUrl(url);
		picture.setSourceUrl(sourceUrl);
		try{
			pinDAO.addPicture(picture);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_PICTURE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType deletePicture(int picnum){
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		if (picture == null)
			return ErrorType.PICTURE_NOT_EXISTED;
		try{
			pinDAO.deletePicture(picture);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Picture findPictureByPicnum(int picnum){
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		return picture;
	}
	
	@Override
	public ArrayList<Picture> findPictureByUsername(String username){
		ArrayList<Picture> pictures = pinDAO.findPictureByUsername(username);
		return pictures;
	}
	
	@Override
	public ArrayList<Picture> findPictureByBid(int bid){
		ArrayList<Picture> pictures = pinDAO.findPictureByBid(bid);
		return pictures;
	}
	
	@Override
	public ArrayList<Picture> findPictureByLikes(String username){
		ArrayList<Picture> pictures = pinDAO.findPictureByLikes(username);
		return pictures;		
	}
	
	@Override
	public ErrorType addPin(int bid, int picnum, String discription){
		Pin pin1 = pinDAO.findPinByBidPicnum(bid, picnum);
		if(pin1 != null){
			return ErrorType.PIN_EXISTED;
		}
		else{
		    Pin pin = new Pin();
		    Board board = pinDAO.findBoardByBid(bid);
		    if(board == null)
		    	return ErrorType.BOARD_NOT_EXISTED;
		    Picture picture = pinDAO.findPictureByPicnum(picnum);
		    if(picture == null)
		    	return ErrorType.PICTURE_NOT_EXISTED;
		    pin.setBoard(board);
		    pin.setPicture(picture);
		    pin.setDiscription(discription);
		    pin.setTime(new Date());
		    pinDAO.addPin(pin);
		    return ErrorType.NO_ERROR;
		}		
	}
	
	@Override
	public ErrorType deletePin(int pinid){
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null)
			return ErrorType.PIN_NOT_EXISTED;
		try{
			pinDAO.deletePin(pin);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType updatePin(int pinid, int bid, String note){
		int picnum = pinDAO.findPictureByPinid(pinid).getPicnum();
		Pin pin1 = pinDAO.findPinByBidPicnum(bid, picnum);
		if(pin1 != null)
			return ErrorType.PIN_EXISTED;
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null)
			return ErrorType.PIN_NOT_EXISTED;
		Board board = pinDAO.findBoardByBid(bid);
		pin.setBoard(board);
		pin.setDiscription(note);
		try{
			pinDAO.updatePin(pin);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Pin findPinByPinid(int pinid){
		Pin pin = pinDAO.findPinByPinid(pinid);
		return pin;
	}
	
	@Override
	public ErrorType addFollow(String username, int bid, String stream){
		Follow follow1 = pinDAO.findFollowByUsernameBid(username, bid);
		if(follow1 != null)
			return ErrorType.FOLLOW_EXISTED;
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST;
		Board board = pinDAO.findBoardByBid(bid);
		if(board == null)
			return ErrorType.BOARD_NOT_EXISTED;
		Follow follow = new Follow();
		follow.setUser(user);
		follow.setBoard(board);
		follow.setStream(stream);
		follow.setTime(new Date());
		try{
			pinDAO.addFollow(follow);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_FOLLOW_ERROR;
		}
		return ErrorType.NO_ERROR;	
	}
	
	@Override
	public ErrorType deleteFollow(int idfollow){
		Follow follow = pinDAO.findFollowByIdfollow(idfollow);
		if(follow == null)
			return ErrorType.FOLLOW_NOT_EXISTED;
		try{
			pinDAO.deleteFollow(follow);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<User> findUserByFollow(int bid){
		ArrayList<User> users = pinDAO.findUserByFollow(bid);
		return users;
	}
	
	@Override
	public ErrorType addComment(String username, int pinid, String comment){
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST;
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null)
			return ErrorType.PIN_NOT_EXISTED;
		Comment comment1 = new Comment();
		comment1.setUser(user);
		comment1.setPin(pin);
		comment1.setComment(comment);
		comment1.setTime(new Date());
		try{
			pinDAO.addComment(comment1);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_COMMENT_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType deleteComment(int cid){
		Comment comment = pinDAO.findCommentByCid(cid);
		if(comment == null)
			return ErrorType.COMMENT_NOT_EXISTED;
		try{
			pinDAO.deleteComment(comment);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<Comment> findCommentByUsername(String username){
		ArrayList<Comment> comments = pinDAO.findCommentByUsername(username);
		return comments;
	}
	
	@Override
	public ArrayList<Comment> findCommentByPinid(int pinid){
		ArrayList<Comment> comments = pinDAO.findCommentByPinid(pinid);
		return comments;
	}
	
	@Override
	public ErrorType addLikes(String username, int picnum){
		Likes likes1 = pinDAO.findLikesByUsernamePicnum(username, picnum);
		if(likes1 != null)
			return ErrorType.LIKES_EXISTED;
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		if(picture == null)
			return ErrorType.PICTURE_NOT_EXISTED;
		Likes likes = new Likes();
		likes.setUser(user);
		likes.setPicture(picture);
		likes.setTime(new Date());
		try{
			pinDAO.addLikes(likes);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_LIKES_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType deleteLikes(int idlikes){
		Likes likes = pinDAO.findLikesByIdlikes(idlikes);
		if(likes == null)
			return ErrorType.LIKES_NOT_EXISTED;
		try{
			pinDAO.deleteLikes(likes);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<Likes> findLikesByUsername(String username){
		ArrayList<Likes> likes = pinDAO.findLikesByUsername(username);
		return likes;
	}
	
	@Override
	public ArrayList<Likes> findLikesByPicnum(int picnum){
		ArrayList<Likes> likes = pinDAO.findLikesByPicnum(picnum);
		return likes;
	}

	@Override
	public ErrorType addPin(int bid, int picnum, String note, int repin) {
		// TODO Auto-generated method stub
		return null;
	}
}
    
