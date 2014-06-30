package com.student.dao;

import java.util.List;

import com.student.domain.Term;

public interface ITermDao
{
	public List<Term> selectAll();
	public void insert(Term term);
	public void delete(String id);
	public void update(Term term);
	public void repeal();
	public Term selectEffect();
}
