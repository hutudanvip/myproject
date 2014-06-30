package com.student.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.student.dao.IStudentDao;
import com.student.domain.Student;

public class StudentDaoImpl implements IStudentDao {
	
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-3-9
	 * description:添加学生
	 * param:
	 */
	public void add(Student stu) {
		sqlSession.insert("student.insert", stu);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-3-9
	 * description:根据学生编码查询学生
	 * param:
	 */
	public List query(Student stu) {
		List<Student> stuList = sqlSession.selectList("student.select", stu);
		return stuList;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-12
	 * description:修改
	 * param:
	 */
	public void update(Student stu)
	{
		sqlSession.update("student.update", stu);
	}

	public void repeal(String id) {
		sqlSession.update("student.repeal", id);		
	}
}
