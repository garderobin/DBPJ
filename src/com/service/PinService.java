package com.service;

import java.util.ArrayList;
import com.bean.*;
import com.util.ErrorType;

public interface PinService {
	
    public ErrorType addBoard(String username, String bname);
    public ErrorType deleteBoard(Integer bid);
    public ErrorType addPicture(Integer bid, String url, String sourceUrl);	
}
