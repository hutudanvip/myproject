package com.common.util.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @author 张平�?
 * @since 2011-11-16
 * @description 连接数据�?
 */
public class JdbcUtil {

	private static BasicDataSource dataSource;

	private static Properties props = null;

	static {
		// 属�?文件路径
		String filePath = "config/db.properties";
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream(
				filePath);
		try {
			// 获取属�?文件
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author 张平�?
	 * @since 2011-12-23
	 * @description  获取数据�?
	 * @return
	 */
	private static DataSource getDataSource() {
		if (dataSource == null) {
			// 获取属�?文件里的参数
			// 驱动,url,用户�?密码
			String driverClassName = props
					.getProperty("driverClassName");
			String url = props.getProperty("url");
			String name = props.getProperty("username");
			String password = props.getProperty("password");

			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(name);
			dataSource.setPassword(password);
			dataSource.setInitialSize(5);
		}

		return dataSource;
	}

	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description 获得连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		return getDataSource().getConnection();
	}

	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description 关闭连接
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws Exception
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con)
			throws Exception {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			throw new Exception("close ResultSet Exception!");
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception ex) {
			throw new Exception("close Statement Exception!");
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			throw new Exception("close Connection Exception!");
		}
	}

	/**
	 * 
	 * @author 张平�?
	 * @since 2011-9-24
	 * @description 将ResultSet转成List
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static List rsToList(ResultSet rs) throws SQLException {
		List list = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while (rs.next()) {
			Map map = new HashMap();
			for (int i = 1; i <= columnCount; i++) {
				if (rsmd.getCatalogName(i) == null
						|| "".equals(rsmd.getCatalogName(i))) {
					map.put(i, rs.getObject(i));
				} else {
					map.put(rsmd.getCatalogName(i), rs.getObject(i));
				}
			}
			list.add(map);
		}
		return list;
	}
}