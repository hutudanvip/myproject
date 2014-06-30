package com.student.domain.common;

import java.util.Date;

public class BaseEntity
{
	private String id;
	private String name;
	private Date createTime;
	private Date lastUpdateTime;
	private String number;
	private String describe;
	private boolean iseffective;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIseffective() {
		return iseffective;
	}
	public void setIseffective(boolean iseffective) {
		this.iseffective = iseffective;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getDescribe()
	{
		return describe;
	}
	public void setDescribe(String describe)
	{
		this.describe = describe;
	}
	
	
}
