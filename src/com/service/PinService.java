package com.service;

import java.util.ArrayList;
import com.bean.*;
import com.util.ErrorType;

public interface PinService {
	
	/* Board */
    public ErrorType addBoard(String username, String bname, String stream);
    public ErrorType deleteBoard(int bid);
    public ErrorType updateBoard(int bid, String bname, String stream);
    public Board findBoardByBid(int bid);
    public ArrayList<Board> findBoardByUsername(String username);
    public Board findBoardByUsernameBname(String username, String bname);    
    
    /* Picture */
    public ErrorType addPicture(String url, String sourceUrl);	
    public ErrorType deletePicture(int picnum);
    public Picture findPictureByPicnum(int picnum);
    public ArrayList<Picture> findPictureByUsername(String username);
    public ArrayList<Picture> findPictureByBid(int bid);
    public ArrayList<Picture> findPictureByLikes(String username);
    
    /* Pin */
    public ErrorType addPin(int bid, int picnum, String discription);
    //public ErrorType addPin(int bid, int picnum, String discription, int repin);
    public ErrorType deletePin(int pinid);
    public ErrorType updatePin(int pinid, int bid, String discription);
    public Pin findPinByPinid(int pinid);
    //public ArrayList<Pin> findPinByBid(int bid);
    
    /* Follow */
    public ErrorType addFollow(String username, int bid, String stream);
    public ErrorType deleteFollow(int idfollow);
    public ArrayList<User> findUserByFollow(int bid);
    public ArrayList<Board> findBoardByFollow(String username);
    
    /* Comment */
    public ErrorType addComment(String username, int pinid, String comment);
    public ErrorType deleteComment(int cid);
    public ArrayList<Comment> findCommentByUsername(String username);
    public ArrayList<Comment> findCommentByPinid(int pinid);
    
    /* Likes */
    public ErrorType addLikes(String username, int picnum);
    public ErrorType deleteLikes(int idlikes);
    public ArrayList<Likes> findLikesByUsername(String username);
    public ArrayList<Likes> findLikesByPicnum(int picnum);
    
    /* Statistic */
    /**
     * 蓝色的注释不要删。这些将来要生成javadoc文档用的。
     * @param username
     * @return 	int[0]: num of boards
     * 		 	int[1]: num of pins
     * 			int[2]: num of likes
     * 			int[3]: num of friends
     */
    //public int[] userBasicStatistic(String username);
    
    /**
     * 
     * @param bid
     * @return	int[0]: num of pins
     * 			int[0]: num of followers
     */
    //public int[] boardBasicStatictis(int bid);
    
    /**
     * 
     * @param pinid
     * @return	int[0]: num of repins
     * 			int[1]: num of likes
     */
    //public int[] pinBasicStatistics(int pinid);
    
}
