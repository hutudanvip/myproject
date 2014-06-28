package com.student.dao;

import java.util.List;

import com.student.domain.Children;

public interface IChildrenDao
{
	public List<Children> selectAll();
	public void insert(Children children);
	public void delete(String id);
	public void update(Children children);
}
