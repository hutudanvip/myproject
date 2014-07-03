package com.deppon.fssc.module.quartz.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *<pre>
 *功能:oracle数据库的jdbc连接工具
 *工具类的定位：
 *	1.作为一个软件开发者，缺乏想象力是最严重的罪过之一。
 *		我们经常把事情重复做一遍又一遍，但是我们很少改变这种方式。
 *		经过这些年开发，在我的工具箱里面有了一些每个项目我都需要用到的工具，
 *		烦人的重复工作不再是我的事.
 *	2.工具，汉语词语，原指工作时所需用的器具，
 *		后引申为为达到、完成或促进某一事物的手段。
 *		它的好处可以是机械性，也可以是智能性的。
 *		大部分工具都是简单机械。
 *		例如一根铁棍可以当作槓杆使用，力点离开支点越远，杠杆传递的力就越大.
 *		而工具类就是通过实现独立功能单元的一个工具
 *	3.直接使用的工具类，不但可以在本应用中使用这些工具类，也可以在其它的应用中使用，
 *		这些工具类中的大部分是可以在脱离各种框架和应用时使用的。
 *		工具类并在程序编写时适当使用和提取，将有助于提高开发效率、增强代码质量。
 *	4.对于软件开发过程中，需要使用到各种框架，而框架中往往都提供了相应的工具类。
 *		比如spring、struts、ibatis、hibernate。
 *		而java本身也提供不少的工具类供开发员进行特殊的处理
 *作者：谢玉良
 *日期：2013-7-25上午11:13:01
 *</pre>
 */
public class JdbcUtils {
	/**
	 *<pre>
	 * 方法体说明：获取数据库连接
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午2:10:59
	 * @return 返回数据库连接
	 * @throws Exception：抛出异常
	 *</pre>
	 */
	public static Connection getCon() throws Exception {
		//声明连接对象
		Connection con = null;
		//资源文件对象的实例化
		ResourceBundle rb = new PropertyResourceBundle(
				JdbcUtils.class
						.getResourceAsStream("/com/deppon/fssc/module/quartz/server/META-INF/database.properties"));
		//获取数据库ip
		String dbIp = rb.getString("dbIp");
		//获取数据库端口
		String dbPort = rb.getString("dbPort");
		//获取数据库名
		String dbName = rb.getString("dbName");
		//获取数据库用户名
		String dbUser = rb.getString("dbUser");
		//获取数据库用户密码
		String dbPwd = rb.getString("dbPwd");
		//连接字符串对象
		StringBuffer dbUrl = new StringBuffer();
		//连接字符串的拼接
		dbUrl.append("jdbc:oracle:thin:@");
		//连接字符串的拼接
		dbUrl.append(dbIp);
		//连接字符串的拼接
		dbUrl.append(":");
		//连接字符串的拼接
		dbUrl.append(dbPort);
		//连接字符串的拼接
		dbUrl.append(":");
		//连接字符串的拼接
		dbUrl.append(dbName);
		// jdbc驱动注册,在web容器里面会自动的注册,看情况是否需要进行这一步,
		// Class.forName("oracle.jdbc.driver.OracleDriver");

		// 获取数据库连接
		con = DriverManager.getConnection(dbUrl.toString(), dbUser, dbPwd);

		// 清除配置信息缓存
		ResourceBundle.clearCache();
		return con;
	}

	/**
	 *<pre>
	 * 方法体说明：关闭数据库连接
	 * 作者：谢玉良
	 * 日期： 2013-7-25 上午11:02:58
	 * @param rs:结果集
	 * @param stmt:查询器
	 * @param con:连接
	 *</pre>
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			//判断是否为空
			if (rs != null) {
				//关闭
				rs.close();
			}
			//判断是否为空
			if (stmt != null) {
				//关闭
				stmt.close();
			}
			//判断是否为空
			if (con != null) {
				//关闭
				con.close();
			}
		} catch (Exception ex) {//异常不做处理
		}
	}

}
