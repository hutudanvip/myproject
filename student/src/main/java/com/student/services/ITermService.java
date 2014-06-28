package com.student.services;

import java.util.List;

import com.student.domain.Term;

public interface ITermService {
	public List<Term> selectAll();
	public void insert(Term term);
	public void delete(String id);
	public void update(Term term);
	public void repeal();
	public Term selectEffect();
}
