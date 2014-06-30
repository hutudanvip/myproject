package com.deppon.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class FirstAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int operate1;
	private int operate2;
	public int getOperate1() {
		return operate1;
	}
	public void setOperate1(int operate1) {
		System.out.println(operate1);
		this.operate1 = operate1;
	}
	public int getOperate2() {
		return operate2;
	}
	public void setOperate2(int operate2) {
		System.out.println(operate2);
		this.operate2 = operate2;
	}
	@Override
	public String execute() throws Exception {
		if(sum()>0) {
			//证书
			return "positive";
		} else {
			//负数
			return "negative";
		}
	}
	
	/**
	 * 
		 * 作者：051781
		 * 功能：求和
		 * 时间：2014-6-28上午11:43:31
		 * param:
		 * return：
	 */
	private int sum() {
		return operate1+operate2;
	}
}
