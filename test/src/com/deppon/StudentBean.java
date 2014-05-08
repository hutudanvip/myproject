package com.deppon;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

public class StudentBean {
	//ID
	private String id;
	//业务流程编码
	private String busiCode;
	//单据编码
	private String billNum;
	//单据类型
	private String billTye;
	//业务类型
	private String busiType;
	//创建时间
	private Timestamp createTime;
	//办理状态
	private int handleStatus;
	//更新时间
	private Timestamp updateTime;
	//用户工号
	private String userCode;
	//备注
	private String describtion;
	//原单据ID
	private String sourceBillID;
	//通知次数
	private int count;
	//单据URL
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSourceBillID() {
		return sourceBillID;
	}
	public void setSourceBillID(String sourceBillID) {
		this.sourceBillID = sourceBillID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public String getBillTye() {
		return billTye;
	}
	public void setBillTye(String billTye) {
		this.billTye = billTye;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getHandleStatus() {
		return handleStatus;
	}
	public void setHandleStatus(int handleStatus) {
		this.handleStatus = handleStatus;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
}
