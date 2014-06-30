package com.student.dao;

import java.util.List;

import com.student.domain.Student;

public interface IStudentDao {
	
	public void add(Student stu);

	public List query(Student stu);
	
	public void update(Student stu);
	
	public void repeal(String id);
}
