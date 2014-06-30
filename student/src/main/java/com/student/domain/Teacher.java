package com.student.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.student.domain.common.BaseEntity;

public class Teacher extends BaseEntity
{
	private Date inTime;//入校时间
	private BigDecimal salary;
	private boolean onTheJob;
	private Date leaveTime;//离校时间
	private String cellphone;//联系电话
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Date getInTime()
	{
		return inTime;
	}
	public void setInTime(Date inTime)
	{
		this.inTime = inTime;
	}
	public BigDecimal getSalary()
	{
		return salary;
	}
	public void setSalary(BigDecimal salary)
	{
		this.salary = salary;
	}
	public boolean isOnTheJob()
	{
		return onTheJob;
	}
	public void setOnTheJob(boolean onTheJob)
	{
		this.onTheJob = onTheJob;
	}
}
