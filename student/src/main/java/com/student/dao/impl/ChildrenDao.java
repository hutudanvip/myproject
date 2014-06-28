package com.student.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.student.dao.IChildrenDao;
import com.student.domain.Children;


public class ChildrenDao implements IChildrenDao {

	//利用SPRING注入
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Children> selectAll() {
		List<Children> list = sqlSession.selectList("children.selectAll");
		return list;
	}

	public void insert(Children children) {
		sqlSession.insert("children.insert");
	}

	public void delete(String id) {
		sqlSession.delete("children.delete", id);
	}

	public void update(Children children) {
		sqlSession.update("children.update", children);
	}

}
