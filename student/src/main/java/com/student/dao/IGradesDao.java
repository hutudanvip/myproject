package com.student.dao;

import java.util.List;

import com.student.domain.Grades;

public interface IGradesDao
{
	public List<Grades> selectAll();
	public List<Grades> selectAllEffect();
	public void insert(Grades grades);
	public void delete(String id);
	public void update(Grades grade);
	public int isExistStudent(String id);
	public void repealAll();
}
