package com.student.domain;

import java.math.BigDecimal;

import com.student.domain.common.BaseEntity;

public class Expense extends BaseEntity
{
	private BigDecimal tuition;//学费
	private BigDecimal livingCost;//生活费
	private BigDecimal otherCost; //其他费用
	private BigDecimal tranChange;//车接送费
	private BigDecimal bookCost;	//书费
	private boolean effected;//是否有效
	public BigDecimal getTuition()
	{
		return tuition;
	}
	public void setTuition(BigDecimal tuition)
	{
		this.tuition = tuition;
	}
	public BigDecimal getLivingCost()
	{
		return livingCost;
	}
	public void setLivingCost(BigDecimal livingCost)
	{
		this.livingCost = livingCost;
	}
	public BigDecimal getOtherCost()
	{
		return otherCost;
	}
	public void setOtherCost(BigDecimal otherCost)
	{
		this.otherCost = otherCost;
	}
	public BigDecimal getTranChange()
	{
		return tranChange;
	}
	public void setTranChange(BigDecimal tranChange)
	{
		this.tranChange = tranChange;
	}
	public BigDecimal getBookCost()
	{
		return bookCost;
	}
	public void setBookCost(BigDecimal bookCost)
	{
		this.bookCost = bookCost;
	}
	public boolean isEffected()
	{
		return effected;
	}
	public void setEffected(boolean effected)
	{
		this.effected = effected;
	}
	
}
