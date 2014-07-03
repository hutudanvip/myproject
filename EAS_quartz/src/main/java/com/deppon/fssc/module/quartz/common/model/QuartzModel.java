package com.deppon.fssc.module.quartz.common.model;

import java.util.Date;

/**
 * <pre>
 * 功能:定时任务计划配置信息bean
 * model层的定义：
 * 	1.MVC系统中的Model部分从概念上可以分为两类：
 * 		系统的内部状态和改变系统状态的动作。
 * 	2.Struts为Model部分提供了Action和ActionForm对象：
 * 		所有的Action处理器对象都是开发者从Struts的Action类派生的子类。
 * 		Action处理器对象封装了具体的处理逻辑，
 * 		调用业务逻辑模块，并且把响应提交到合适的View组件以产生响应。
 * 	3.Struts提供的ActionForm组件对象，它可以通过定义属性描述客户端表单数据。
 * 		开发者可以从它派生子类对象，
 * 		利用它和Struts提供的自定义标记库结合可以实现对客户端的表单数据的良好封装和支持，
 * 		Action处理器对象可以直接对它进行读写，
 * 		而不再需要和request、response对象进行数据交互。
 * 	4.通过ActionForm组件对象实现了对View和Model之间交互的支持。
 * 		Struts通常建议使用一组JavaBean表示系统的内部状态，
 * 		根据系统的复杂度也可以使用像Entity EJB 和 Session EJB等组件来实现系统状态。
 * 	5.Struts建议在实现时把"做什么"（Action）和"如何做"（业务逻辑）分离。
 * 		这样可以实现业务逻辑的重用。
 * 作者：谢玉良
 * 日期：2013-4-8下午3:29:02
 * </pre>
 */
public class QuartzModel {
	private String id;
	/**
	 * 任务名称id
	 */
	private String jobid;
	/**
	 * 任务名称
	 */
	private String jobname;
	/**
	 * 触发器时钟表达式
	 */
	private String cronexpression;
	/**
	 * 加载对象是否为spring注册的bean
	 */
	private String isbean;
	/**
	 * 要执行的任务对象：若为bean则给bean名称,否则给类的包路径加类名
	 */
	private String targetobject;
	/**
	 * 要执行的任务对象中的方法名
	 */
	private String method;
	/**
	 * 执行的任务是否为异步模式：1为是,0为否;
	 * 
	 * 异步：允许前一个任务未执行完毕的情况下，下次任务仍旧执行
	 */
	private String concurrent;
	/**
	 * 任务是否启用:1为启用,0为停用
	 */
	private String state;

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
	 * 任务描述
	 */
	private String des;

	/**
	 * @return the jobid
	 */
	public String getJobid() {
		return jobid;
	}

	/**
	 * @param jobid
	 *            the jobid to set
	 */
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

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
	 * @return the cronexpression
	 */
	public String getCronexpression() {
		return cronexpression;
	}

	/**
	 * @param cronexpression
	 *            the cronexpression to set
	 */
	public void setCronexpression(String cronexpression) {
		this.cronexpression = cronexpression;
	}

	/**
	 * @return the isbean
	 */
	public String getIsbean() {
		return isbean;
	}

	/**
	 * @param isbean
	 *            the isbean to set
	 */
	public void setIsbean(String isbean) {
		this.isbean = isbean;
	}

	/**
	 * @return the targetobject
	 */
	public String getTargetobject() {
		return targetobject;
	}

	/**
	 * @param targetobject
	 *            the targetobject to set
	 */
	public void setTargetobject(String targetobject) {
		this.targetobject = targetobject;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the concurrent
	 */
	public String getConcurrent() {
		return concurrent;
	}

	/**
	 * @param concurrent
	 *            the concurrent to set
	 */
	public void setConcurrent(String concurrent) {
		this.concurrent = concurrent;
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
