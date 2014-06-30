package com.student.dao;

import java.util.List;

import com.student.domain.Teacher;

public interface ITeacherDao
{
	public List<Teacher> selectAll();
	public List<Teacher> selectAllEffect();
	public void insert(Teacher teacher);
	public void repeal(String id);
	public void update(Teacher teacher);
}
