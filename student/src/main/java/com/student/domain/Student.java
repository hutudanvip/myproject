package com.student.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.student.domain.common.BaseEntity;

public class Student extends BaseEntity{
	
	private String name;
	private String address;
	private Grades grade;//班级
	private String cellphone;
	private String genearchName;//家长姓名
	private String relation;
	private int age;
	private int gender;//性别
	private Date intime;//入学时间
	private Term term;//学期
	
	//添加   查询类型字段   用于查询条件
	private String queryType;//查询条件
	private Timestamp beginTime;//月份的开始时间
	private Timestamp endTime;//月份的截至时间

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getGenearchName() {
		return genearchName;
	}

	public void setGenearchName(String genearchName) {
		this.genearchName = genearchName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
