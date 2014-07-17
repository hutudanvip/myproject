package com.deppon.fin.module.finself_inter.server.dao;

import java.util.List;

import com.deppon.fin.module.finself_inter.shared.domain.fosscash.FossCashEntity;

public interface IFossCashDao{
	//单条插入
    int insert(FossCashEntity record);
    //查询所有
    List<FossCashEntity> selectAll();
    //批量插入
    boolean insertList(List<FossCashEntity> list);
    //清空
    void truncate();
}