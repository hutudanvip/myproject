package com.student.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.student.dao.IExpenseDao;
import com.student.domain.Expense;

public class ExpenseDao implements IExpenseDao {
	
	//利用SPRING注入
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Expense> selectAll() {
		List<Expense> list = sqlSession.selectList("expense.selectAll");
		return list;
	}

	public void insert(Expense expense) {
		sqlSession.insert("expense.insert",expense);
	}

	public void delete(String id) {
		sqlSession.delete("expense.delete", id);
	}

	public void update(Expense expense) {
		sqlSession.update("expense.update", expense);
	}

}
