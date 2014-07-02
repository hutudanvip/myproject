package com.deppon.struts.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

public class ActionInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;
	protected final String INVOKE = "##invoke";

	@Override
	public void destroy() {
		System.out.println("-------------------------destroy----------------");
	}

	@Override
	public void init() {
		System.out.println("-------------------------init----------------");
	}

	/**
	 * 
		 * 作者：051781
		 * 功能：拦截器，拦截方法，并调用
		 * 时间：2014-7-1上午11:06:17
		 * param:
		 * return：
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("-------------------------intercept----------------");
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("action");
		System.out.println(this.hashCode());
		System.out.println("action:" + action);
		if(action != null) {
			//获取方法
			Method method = this.getClass().getMethod(action);
			//调用该方法
			String result = (String)method.invoke(this);
			
			if(result != null) {
				if(!INVOKE.equals(result)) {
					return result;
				} else {
					return null;
				}
			}
		}
		//继续往下传递
		return invocation.invoke();
	}

}
