package com.student.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.student.dao.IGradesDao;
import com.student.domain.Grades;


@Repository("gradesDao")
public class GradesDao implements IGradesDao {

	//利用SPRING注入
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Grades> selectAll() {
		List<Grades> list = sqlSession.selectList("grades.selectAll");
		return list;
	}

	public void insert(Grades grades) {
		System.out.println("this is GradesDao's insert().........");
		sqlSession.insert("grades.insert", grades);
	}

	public void delete(String id) {
		System.out.println("this is GradesDao's delete().........");
		sqlSession.delete("grades.repeal",id);
	}

	public void update(Grades grade) {
		System.out.println("this is GradesDao's update().........");
		sqlSession.update("grades.update", grade);
	}

	
	public int isExistStudent(String id) {
		int count = (Integer)sqlSession.selectOne("grades.isExistStudent", id);
		
		return count;
	}
	public void repealAll() {
		sqlSession.update("grades.repealAll");
	}

	public List<Grades> selectAllEffect() {
		List<Grades> list = sqlSession.selectList("grades.selectAllEffect");
		return list;
	}

}
