package com.common.util.ibatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		Connection conn = null;
		PreparedStatement ps = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("/*dieact*/ insert into  insert into T_CLAIM_FOSSCASHDATA (ID, CASHDATE, DEPTHNUM, " +
				"   DEPTNAME, CASHAMT, CREATETIME)" +
				" values " +
				"  (sys_guid(), ?, ?,  ?, ?, sysdate )");
		
		try {
			conn =  this.getSqlSession().getConnection();
			ps = conn.prepareStatement(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getSqlSession().insert(NS + "insert", list);
	}

	@Override
	public List<String> selectList(String deptCode) {
		return getSqlSession().selectList(NS + "select", deptCode);
	}

}
