package com.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1306001442671662897L;
	private String username;
	private String password;
	private UserService service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		switch(this.service.checkUser(username, password)) {
		case 0:
			addFieldError("message", "Username not exists. Please sign up first!");
			return LOGIN;
		case 1:
			addFieldError("message", "Username and password mismatch.");
			return INPUT;
		case 2:
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);			
			return SUCCESS;
		}		
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}
