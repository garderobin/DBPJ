 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class AddBoardAction extends ActionSupport {
	
	private static final long serialVersionUID = -8048334825837552668L;
	private String username;
	private String bname;
	private String stream;
	private PinService service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		switch(this.service.addBoard(username, bname, stream)) {
		case USER_NOT_EXIST:
			addFieldError("message", "Username not exists. Please sign up first!");
			return "user not exists";
		case BOARD_EXISTED:
			addFieldError("message", "Board name exists.");
			return "board name exists";
		case NO_ERROR:
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);			
			return SUCCESS;
		}		
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String bname) {
		this.bname = bname;
	}
	
	public void setStream(String stream){
		this.stream = stream;
	}

	public void setService(PinService service) {
		this.service = service;
	}
	
	
}
