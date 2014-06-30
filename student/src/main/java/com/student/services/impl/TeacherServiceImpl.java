package com.student.services.impl;

import java.util.List;

import com.student.dao.ITeacherDao;
import com.student.domain.Teacher;
import com.student.services.ITeacherService;

public class TeacherServiceImpl implements ITeacherService{
	
	ITeacherDao teacherDao;

	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:查询所有数据
	 * param:
	 */
	@Override
	public List<Teacher> selectAll() {
		return teacherDao.selectAll();
	}

	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:查询所有有效数据
	 * param:
	 */
	@Override
	public List<Teacher> selectAllEffect() {
		return teacherDao.selectAllEffect();
	}

	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:新增数据
	 * param:
	 */
	@Override
	public void insert(Teacher teacher) {
		teacherDao.insert(teacher);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:作废数据
	 * param:
	 */
	@Override
	public void repeal(String id) {
		teacherDao.repeal(id);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:修改数据
	 * param:
	 */
	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

}
