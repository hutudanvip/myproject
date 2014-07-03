package com.deppon.ump.SmsInterface;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class SmsSendDailInfo implements Serializable{

	private static final long serialVersionUID = 3384840936446228160L;
	
    //发送人工号
	private String sender;
	//发送部门
	private String sendDept;
	//业务类型
	private String msgType;
	//电话号码
	private String mobile;
	//状态 
	private String state;
	//开始时间
	private Timestamp startTime;
	//结束时间
	private Timestamp endTime;
	//服务类型
	private String serviceType;
	//运单号
	private String waybillNo;
	//唯一标识
	private String uuionId;
	//系统来源
	private String msgSource;
	//开始位数
	private int startDigit;
	//结束位数
	private int endDigit;	
	
	public int getStartDigit() {
		return startDigit;
	}
	public void setStartDigit(int startDigit) {
		this.startDigit = startDigit;
	}
	public int getEndDigit() {
		return endDigit;
	}
	public void setEndDigit(int endDigit) {
		this.endDigit = endDigit;
	}
	public String getUuionId() {
		return uuionId;
	}
	public void setUuionId(String uuionId) {
		this.uuionId = uuionId;
	}
	public String getMsgSource() {
		return msgSource;
	}
	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	@JsonSerialize(using = TimestampSerializer.class)
	public Timestamp getStartTime() {
		return startTime;
	}
	@JsonDeserialize(using = TimestampDeserializer.class)
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	@JsonSerialize(using = TimestampSerializer.class)
	public Timestamp getEndTime() {
		return endTime;
	}
	@JsonDeserialize(using = TimestampDeserializer.class)
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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
		
}
