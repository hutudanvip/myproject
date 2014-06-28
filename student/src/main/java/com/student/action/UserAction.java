package com.student.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.domain.User;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String test;
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String execute()
	{
		System.out.println("--------------"+test);
		System.out.println(user.getUsername()+"--------------");
		ActionContext ctx = ActionContext.getContext();
		
		if(user.getUsername().equals("admin")
				&& user.getPassword().equals("admin"))
		{
			System.out.println("success");
			return SUCCESS;
		}
		else
		{
			System.out.println("error");
			return "error";
		}
		
	}
	
	//登录成功后跳转
	public String login()
	{
		return SUCCESS;
	}
}
