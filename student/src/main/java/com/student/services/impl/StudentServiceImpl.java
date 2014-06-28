package com.student.services.impl;

import java.util.List;

import com.student.dao.IStudentDao;
import com.student.domain.Student;
import com.student.services.IStudentService;

public class StudentServiceImpl implements IStudentService{
	
	private IStudentDao studentDao;

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-4-9
	 * description:添加学生
	 * param:
	 */
	public void add(Student stu) {
		if(stu != null)
		{
			studentDao.add(stu);
		}
	}

	/**
	 * 
	 * author:afei
	 * date:2013-4-9
	 * description:查询学生
	 * param:
	 */
	public List<Student> query(Student stu) {
		return studentDao.query(stu);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-4-12
	 * description:修改
	 * param:
	 */
	public void modify(Student stu)
	{
		if(stu != null)
		{
			studentDao.update(stu);
		}
	}

	public void repeal(String id) {
		if(id != null)
		{
			studentDao.repeal(id);
		}
	}
}
