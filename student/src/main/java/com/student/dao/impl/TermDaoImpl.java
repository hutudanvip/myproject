package com.student.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.student.dao.ITermDao;
import com.student.domain.Term;

public class TermDaoImpl implements ITermDao{
	
	//利用SPRING注入
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Term> selectAll() {
		System.out.println("this is termDao's selectAll().........");
		List<Term> list = sqlSession.selectList("term.selectAll");
		return list;
	}

	public void insert(Term term) {
		System.out.println("this is termDao's insert().........");
//		term.setName("201302");
//		term.setNumber("201302");
//		term.setBeginTime(new Date());
		sqlSession.insert("term.insert", term);
	}

	public void delete(String id) {
		System.out.println("this is termDao's delete().........");
		sqlSession.delete("term.delete",id);
	}

	public void update(Term term) {
		sqlSession.update("term.update", term);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:作废所有有效的学期，用于新增学期
	 * param:
	 */
	public void repeal() {
		sqlSession.delete("term.repeal");
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:查询有效版本的学期
	 * param:
	 */
	public Term selectEffect() {
		return sqlSession.selectOne("term.select");
	}

}
