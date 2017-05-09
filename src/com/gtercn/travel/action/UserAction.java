package com.gtercn.travel.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtercn.travel.bean.User;
import com.gtercn.travel.service.UserService;
import com.opensymphony.xwork2.Action;

public class UserAction {
	@Autowired
	private UserService userService;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		User loginUser=userService.userLogin(user);
		System.out.println(loginUser);
		return Action.SUCCESS;
	}
}
