package com.student.domain;

import java.util.Date;

import com.student.domain.common.BaseEntity;

/**
 * 学期
 * @author afei
 *
 */
public class Term extends BaseEntity{
	private Date beginTime;//开学时间

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
}
