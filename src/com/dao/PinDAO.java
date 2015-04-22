package com.dao;
import java.util.ArrayList;
import java.util.List;
import com.bean.*;

public interface PinDAO {
	
	public void addBoard(Board board);
	public void deleteBoard(Board board);
	public void updateBoard(Board board);
	public Board findBoardByBid(Integer bid);
	public ArrayList<Board> findBoardByUser(String username);
	public Board findBoardByUsernameBname(String username, String bname); //List
	public ArrayList<Board> findBoardByFollow(String username);
	public Integer addPicture(Picture picture);
	public void deletePicture(Picture picture);
	public void updatePicture(Picture picture);
	public ArrayList<Picture> findPictureByUser(String username);
	public ArrayList<Picture> findPictureByBoard(Integer bid);
	public ArrayList<Picture> findPictureByLikes(String username);	
	public void addPin(Pin pin);
	public void deletePin(Pin pin);
	public void updatePin(Pin pin);
	public void addFollow(Follow follow);
	public void deleteFollow(Follow follow);
	public void updateFollow(Follow follow);
	public ArrayList<User> findUserByFollow(Integer bid);
	public ArrayList<Follow> findFollowByUser(String username);
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public void updateComment(Comment comment);
	public ArrayList<Comment> findCommentByUser(String username);
	public ArrayList<Comment> findCommentByPin(Integer pinid);	
}
