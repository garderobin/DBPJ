package com.dao;
import java.util.List;
import com.bean.*;

public interface PinDAO {
	
	public void addBoard(Board board);
	public void deleteBoard(Board board);
	public void updateBoard(Board board);
	public Board findBoardByBid(int bid);
	public List<Board> findBoardByUsername(String username);
	public Board findBoardByUsernameBname(String username, String bname);
	public List<Board> findBoardByFollow(String username);
	public void addPicture(Picture picture);
	public void deletePicture(Picture picture);
	public void updatePicture(Picture picture);
	public Picture findPictureByPicnum(int picnum);
	public List<Picture> findPictureByUsername(String username);
	public List<Picture> findPictureByBid(int bid);
	public List<Picture> findPictureByLikes(String username);	
	public void addPin(Pin pin);
	public void deletePin(Pin pin);
	public void updatePin(Pin pin);
	public Pin findPinByPinid(int pinid);
	public void addFollow(Follow follow);
	public void deleteFollow(Follow follow);
	public void updateFollow(Follow follow);
	public List<User> findUserByFollow(int bid);
	public List<Follow> findFollowByUsername(String username);
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public void updateComment(Comment comment);
	public List<Comment> findCommentByUsername(String username);
	public List<Comment> findCommentByPinid(int pinid);	
	public void addLikes(Likes likes);
	public void deleteLikes(Likes likes);
	public List<Likes> findLikesByUsername(String username);
	public List<Likes> findLikesByPicnum(int picnum);
}
