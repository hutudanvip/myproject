package com.student.action.demo;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute()
	{
		message = "Hello world";
		return "success";
	}
}
