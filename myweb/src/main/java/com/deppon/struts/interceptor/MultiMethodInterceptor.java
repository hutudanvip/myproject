package com.deppon.struts.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class MultiMethodInterceptor extends ActionInterceptor {
	private static final long serialVersionUID = 1L;
	
	public String test() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("invoke test");
//		return INVOKE;
//		return "print";
		return "test";
	}
	
	public String print() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("invoke print");
		return null;
	}
}
