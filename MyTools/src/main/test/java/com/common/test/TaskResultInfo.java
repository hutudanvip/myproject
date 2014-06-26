package com.common.test;

public class TaskResultInfo {
	//0表示失败，1表示成功
	private int flag;
	//成功返回success，失败返回错误信息。
	private String msg;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
