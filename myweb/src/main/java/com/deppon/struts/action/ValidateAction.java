package com.deppon.struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2验证框架
 * @author 051781
 *
 */
public class ValidateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//必须输入
	private String msg;
	//13至30
	private int age;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
