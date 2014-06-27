package com.common.util.ibatis.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.common.util.ibatis.bean.ClaimInfo;
import com.common.util.ibatis.bean.ClaimInfoChild;


@Repository
public class ObjectEntityDaoImp extends SqlSessionDaoSupport implements ObjectEntityDao{
	private static final String NS = "com.common.util.ibatis.bean.ClaimInfo.";
	@Override
	public int select(String code) {
		int i = (Integer)getSqlSession().selectOne(NS + "select", code);
		return i;
	}

	@Override
	public void insert(List<ClaimInfo> list) {
		getSqlSession().insert(NS + "insert", list);
	}

	@Override
	public List<String> selectList(String deptCode) {
		return getSqlSession().selectList(NS + "select", deptCode);
	}

}
