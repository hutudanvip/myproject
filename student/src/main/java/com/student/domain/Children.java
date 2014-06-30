package com.student.domain;

import java.util.Date;

import com.student.domain.common.BaseEntity;

public class Children extends BaseEntity
{
	private String childName;
	private boolean childGender;
	private int childAge;
	private String belongClass;
	private Date beginTime;
	private String parentName;
	private String cellphone;
	private String telphone;
	private String address;
	private boolean leaved;//是否在校
	
	public String getChildName()
	{
		return childName;
	}
	public void setChildName(String childName)
	{
		this.childName = childName;
	}
	public boolean isChildGender()
	{
		return childGender;
	}
	public void setChildGender(boolean childGender)
	{
		this.childGender = childGender;
	}
	public int getChildAge()
	{
		return childAge;
	}
	public void setChildAge(int childAge)
	{
		this.childAge = childAge;
	}
	public String getBelongClass()
	{
		return belongClass;
	}
	public void setBelongClass(String belongClass)
	{
		this.belongClass = belongClass;
	}
	public Date getBeginTime()
	{
		return beginTime;
	}
	public void setBeginTime(Date beginTime)
	{
		this.beginTime = beginTime;
	}
	public String getParentName()
	{
		return parentName;
	}
	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}
	public String getCellphone()
	{
		return cellphone;
	}
	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}
	public String getTelphone()
	{
		return telphone;
	}
	public void setTelphone(String telphone)
	{
		this.telphone = telphone;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public boolean isLeaved()
	{
		return leaved;
	}
	public void setLeaved(boolean leaved)
	{
		this.leaved = leaved;
	}
	
}
