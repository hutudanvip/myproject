package com.common.util.ibatis.dao;

import com.common.util.ibatis.bean.ClaimInfo;

public interface ObjectEntityDao {
	public int select(String code);
	public void insert(ClaimInfo info);
}
