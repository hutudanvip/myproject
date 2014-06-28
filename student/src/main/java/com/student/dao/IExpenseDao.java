package com.student.dao;

import java.util.List;

import com.student.domain.Expense;

public interface IExpenseDao
{
	public List<Expense> selectAll();
	public void insert(Expense expense);
	public void delete(String id);
	public void update(Expense expense);
}
