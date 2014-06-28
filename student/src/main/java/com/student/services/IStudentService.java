package com.student.services;

import java.util.List;

import com.student.domain.Student;

public interface IStudentService {

	public void add(Student stu);

	public List<Student> query(Student stu);
	
	public void modify(Student stu);
	
	public void repeal(String id);
}
