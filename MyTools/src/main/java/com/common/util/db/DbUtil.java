package com.common.util.db;
import java.sql.*;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * 
 * @author 张平�?
 * @since 2011-11-16
 * @description 查询数据的公用方�?
 */
public class DbUtil {


	public DbUtil() {
	}
	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description  执行sql,有返回�?
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static List executeQuery(String sql) throws Exception {
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = null;
		conn = null;
		rs = null;
		try {
			conn = JdbcUtil.getConnection();
	         ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 list = JdbcUtil.rsToList(rs);
		}
		catch (SQLException exc) {
			throw new Exception("Sql execute exception : " + sql, exc);
		}
		JdbcUtil.close(rs,ps,conn);
		return list;
	}

	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description  执行sql,带参�?有返回�?
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static List executeQuery(String sql, Object params[]) throws Exception {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		List list = null;
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}

			rs = ps.executeQuery();
			list = JdbcUtil.rsToList(rs);
		}
		catch (SQLException exc) {
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < params.length; i++) {
				sb.append("param ").append(i).append(" is:").append(params[i]);
			}
			throw new Exception("Sql execute exception : " + sql, exc);
		}
		JdbcUtil.close(rs,ps,conn);
		return list;
	}
	
	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description  执行sql,带参�?没有返回�?
	 * @param sql
	 * @param params
	 * @throws Exception
	 */
	public static void execute(String sql, Object params[]) throws Exception {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}

			rs = ps.executeQuery();
		}
		catch (SQLException exc) {
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < params.length; i++) {
				sb.append("param ").append(i).append(" is:").append(params[i]);
			}
			throw new Exception("Sql execute exception : " + sql, exc);
		}
		JdbcUtil.close(rs,ps,conn);
	}
	
	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description  执行sql,不带参数,没有返回�?
	 * @param sql
	 * @throws Exception
	 */
	public static void execute(String sql) throws Exception {
		Connection conn;
		Statement statement;
		conn = null;
		statement = null;
		try {
			conn = JdbcUtil.getConnection();
			statement = conn.createStatement();
			statement.execute(sql);
		}
		catch (SQLException exc) {
			throw new Exception("Sql execute exception : " + sql, exc);
		}
		JdbcUtil.close(null,statement,conn);
	}
	
	/**
	 * 
	 * @author 张平�?
	 * @since 2011-11-17
	 * @description  update更新语句返回的行�?
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static int executeUpdate(String sql , Object params[]) throws Exception{
		Connection conn = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			conn = JdbcUtil.getConnection();
			statement = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			rows = statement.executeUpdate();
		}
		catch (SQLException exc) {
			throw new Exception("更新语句异常:"+ExceptionUtils.getFullStackTrace(exc));
		}
		JdbcUtil.close(null,statement,conn);
		return rows;
	}
}
