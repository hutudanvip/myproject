package com.deppon.fssc.module.quartz.common.model;

import java.io.Serializable;

/**
 *<pre>
 *功能:消息实体
 *作者：谢玉良
 *日期：2013-7-25下午1:56:10
 *</pre>
 */
@SuppressWarnings("serial")
public class Msg implements Serializable {
	/**
	 * 消息标示
	 */
	private boolean success;
	/**
	 * 消息内容
	 */
	private String message;
	/**
	 * success字段的getter方法
	 * @return 返回 success字段的值
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * success字段的setter方法
	 * @param success 为 success 字段设置的值
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * message字段的getter方法
	 * @return 返回 message字段的值
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * message字段的setter方法
	 * @param message 为 message 字段设置的值
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
