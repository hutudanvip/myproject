package com.common.util.ibatis.server;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.util.ibatis.dao.ObjectEntityDao;

@Service
public class ObjectEntityServiceImp implements ObjectEntityService{
	@Resource
	public ObjectEntityDao dao;
	@Override
	public int select(String code) {
		int i = dao.select(code);
		return i;
	}

}
