package com.student.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.student.dao.ITeacherDao;
import com.student.domain.Teacher;


public class TeacherDao implements ITeacherDao {

	//利用SPRING注入
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Teacher> selectAll() {
		List<Teacher> list = sqlSession.selectList("teacher.selectAll");
		return list;
	}

	public void insert(Teacher teacher) {
		sqlSession.insert("teacher.insert", teacher);
	}

	public void repeal(String id) {
		sqlSession.delete("teacher.repeal", id);
	}

	public void update(Teacher teacher) {
		sqlSession.update("teacher.update", teacher);
	}

	@Override
	public List<Teacher> selectAllEffect() {
		List<Teacher> list = sqlSession.selectList("teacher.selectAll");
		return list;
	}

}
