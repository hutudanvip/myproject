package com.common.util.ibatis.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.common.util.ibatis.bean.ClaimInfo;


@Repository
public class ObjectEntityDaoImp extends SqlSessionDaoSupport implements ObjectEntityDao{
	private static final String NS = "com.common.util.ibatis.bean.ClaimInfo.";
	@Override
	public int select(String code) {
		int i = (Integer)getSqlSession().selectOne(NS + "select", code);
		return i;
	}

	@Override
	public void insert(ClaimInfo info) {
		getSqlSession().insert(NS + "insert", info);
	}

}
