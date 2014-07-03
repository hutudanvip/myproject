package com.deppon.ump.SmsInterface;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class SmsSendDail implements Serializable {

	private static final long serialVersionUID = 2747438916992528325L;
	
	private String reason;//失败原因
	private String resultCode;//结果码
	private String unionId;//唯一标识
    //发送人工号
	private String sender;
	//发送部门
	private String sendDept;
	//业务类型
	private String msgType;
	//电话号码
	private String mobile;
	//发送时间
	private Timestamp sendTime;
	//发送内容
	private String msgContent;
	//创建时间
	private Timestamp createTime;
	//服务类型
	private String serviceType;
	//运单号
	private String waybillNo;
	//系统来源
	private String msgSource;

	
	//发送人姓名
	private String empName;
	//发送部门名称
	private String deptName;
	
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSendDept() {
		return sendDept;
	}
	public void setSendDept(String sendDept) {
		this.sendDept = sendDept;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	@JsonSerialize(using = TimestampSerializer.class)
	public Timestamp getSendTime() {
		return sendTime;
	}
	@JsonDeserialize(using = TimestampDeserializer.class)
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	@JsonSerialize(using = TimestampSerializer.class)
	public Timestamp getCreateTime() {
		return createTime;
	}
	@JsonDeserialize(using = TimestampDeserializer.class)
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getWaybillNo() {
		return waybillNo;
	}
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgSource() {
		return msgSource;
	}
	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
	}
	
	
}
