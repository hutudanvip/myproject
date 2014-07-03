package com.deppon.fssc.module.quartz.common.model;

import java.util.Date;

/**
 * 
 * <pre>
 * 功能:任务名称配置信息bean
 * 作者：谢玉良
 * 日期：2013-4-8下午3:28:38
 * </pre>
 */
public class QuartzModelName {
	private String id;
	/**
	 * 任务名称
	 */
	private String jobname;
	/**
	 * 任务是否启用:1为启用,0为停用
	 */
	private String state;

	/**
	 * 任务描述
	 */
	private String des;

	/**
	 * 操作人
	 */
	private String operator;

	/**
	 * 操作人名字
	 */
	private String operatorname;

	/**
	 * 操作时间
	 */
	private Date operatingtime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the jobname
	 */
	public String getJobname() {
		return jobname;
	}

	/**
	 * @param jobname
	 *            the jobname to set
	 */
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * @param des
	 *            the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the operatorname
	 */
	public String getOperatorname() {
		return operatorname;
	}

	/**
	 * @param operatorname
	 *            the operatorname to set
	 */
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	/**
	 * @return the operatingtime
	 */
	public Date getOperatingtime() {
		return operatingtime;
	}

	/**
	 * @param operatingtime
	 *            the operatingtime to set
	 */
	public void setOperatingtime(Date operatingtime) {
		this.operatingtime = operatingtime;
	}

}
