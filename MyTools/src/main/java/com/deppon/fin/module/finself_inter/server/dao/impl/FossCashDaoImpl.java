package com.deppon.fin.module.finself_inter.server.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.deppon.fin.module.finself_inter.server.dao.IFossCashDao;
import com.deppon.fin.module.finself_inter.shared.domain.fosscash.FossCashEntity;

@Repository
public class FossCashDaoImpl extends SqlSessionDaoSupport implements IFossCashDao {
	private static final Logger LOG = Logger
			.getLogger(FossCashDaoImpl.class.getName());
	private static final String NS = "com.deppon.fin.module.finself_inter.server.dao.IFossCashDao.";

	/**
	 * 
		 * 作者：051781
		 * 功能：单条插入，暂时无用
		 * 时间：2014-7-17下午5:28:09
		 * param:
		 * return：
	 */
	@Override
	public int insert(FossCashEntity record) {
		getSqlSession().insert(NS + "insert", record);
		return 0;
	}

	/**
	 * 
		 * 作者：051781
		 * 功能：同步FOSS现金缴款数据
		 * 时间：2014-7-17下午2:10:51
		 * param:
		 * return：
	 */
	@Override
	public boolean insertList(List<FossCashEntity> list) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("/*dieact*/ insert into  T_CLAIM_FOSSCASHDATA" +
				" ( " +
				" ID, CASHDATE, DEPTHNUM, " +
				"   DEPTNAME, CASHAMT, CREATETIME " +
				" ) " +
				" values " +
				"  ( " +
				" sys_guid(), ?, ?,  ?, ?, sysdate " +
				") " );
		
		try {
			conn =  this.getSqlSession().getConnection();
			ps = conn.prepareStatement(sb.toString());
			//计数器
			int count = 0;
			for(FossCashEntity en : list) {
				count++;
				int index = 0;
				
				//收银日期
				java.sql.Date cashDay = new Date(en.getCashdate().getTime());
				ps.setDate(index++, cashDay);
				//部门编码
				ps.setString(index++, en.getDepthnum());
				//部门名称
				ps.setString(index++, en.getDeptname());
				//收银金额
				BigDecimal cashAmt = en.getCashamt();
				if(cashAmt == null) {
					cashAmt = new BigDecimal(0);
				}
				ps.setBigDecimal(index++, cashAmt);
				
				//批处理， 每一千条执行一次
				ps.addBatch();
				if(count%1000 == 0) {
					ps.execute();
				}
			}
			//批处理
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			LOG.error("插入FOSS现金缴款数据时出现异常！" + e.getStackTrace());
			e.printStackTrace();
		} finally {
			//TODO 关闭连接
		}
		return flag;
	}

	/**
	 * 
		 * 作者：051781
		 * 功能：同步前进行数据清空
		 * 时间：2014-7-17下午5:27:41
		 * param:
		 * return：
	 */
	@Override
	public void truncate() {
		this.getSqlSession().delete(NS + "truncate");
	}

	/**
	 * 
		 * 作者：051781
		 * 功能：查询所有的数据
		 * 时间：2014-7-17下午5:27:55
		 * param:
		 * return：
	 */
	@Override
	public List<FossCashEntity> selectAll() {
		List<FossCashEntity> list = this.getSqlSession().selectList(NS + "selectAll");
		return list;
	}

}
