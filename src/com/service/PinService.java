package com.service;

import java.util.ArrayList;
import com.bean.*;
import com.util.ErrorType;

public interface PinService {
	
    public ErrorType addBoard(String username, String bname);
    
    /*
    public ErrorType deleteBoard(Integer bid);
    public ErrorType addPicture(Integer bid, String url, String sourceUrl);	
	public void updateBoard(Board board);
	
	public Board findBoardByBid(int bid);
	public ArrayList<Board> findBoardByUsername(String username);
	public Board findBoardByUsernameBname(String username, String bname);
	public ArrayList<Board> findBoardByFollow(String username);
	public void addPicture(Picture picture);
	public void deletePicture(Picture picture);
	public void updatePicture(Picture picture);
	public Picture findPictureByPicnum(int picnum);
	public ArrayList<Picture> findPictureByUsername(String username);
	public ArrayList<Picture> findPictureByBid(int bid);
	public ArrayList<Picture> findPictureByLikes(String username);	
	public void addPin(Pin pin);
	public void deletePin(Pin pin);
	public void updatePin(Pin pin);
	public Pin findPinByPinid(int pinid);
	public void addFollow(Follow follow);
	public void deleteFollow(Follow follow);
	public void updateFollow(Follow follow);
	public ArrayList<User> findUserByFollow(int bid);
	public ArrayList<Follow> findFollowByUsername(String username);
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public void updateComment(Comment comment);
	public ArrayList<Comment> findCommentByUsername(String username);
	public ArrayList<Comment> findCommentByPinid(int pinid);	
	public void addLikes(Likes likes);
	public void deleteLikes(Likes likes);
	public ArrayList<Likes> findLikesByUsername(String username);
	public ArrayList<Likes> findLikesByPicnum(int picnum);
	*/
}
