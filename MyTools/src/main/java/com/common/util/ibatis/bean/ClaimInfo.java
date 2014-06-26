
package com.common.util.ibatis.bean;

import java.sql.Date;

public class ClaimInfo {
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
	private Date createTime;
	//办理状态
	private int handleStatus;
	//更新时间
	private Date updateTime;
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
	//最后操作人
	private String lastUpdator;
	
	public String getLastUpdator() {
		return lastUpdator;
	}
	public void setLastUpdator(String lastUpdator) {
		this.lastUpdator = lastUpdator;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getHandleStatus() {
		return handleStatus;
	}
	public void setHandleStatus(int handleStatus) {
		this.handleStatus = handleStatus;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
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
