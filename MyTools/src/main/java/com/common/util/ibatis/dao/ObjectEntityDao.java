package com.common.util.ibatis.dao;

import java.util.List;

import com.common.util.ibatis.bean.ClaimInfo;
import com.common.util.ibatis.bean.ClaimInfoChild;

public interface ObjectEntityDao {
	public int select(String code);
	public void insert(List<ClaimInfo> list);
	public List<String> selectList(String deptCode);
}
