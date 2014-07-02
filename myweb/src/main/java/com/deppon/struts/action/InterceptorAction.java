package com.deppon.struts.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 自定义拦截器
 * @author 051781
 *
 */
public class InterceptorAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String abcd() throws Exception{
		ServletActionContext.getResponse().getWriter().write("invoke abcd");
		return null;
	}
}
