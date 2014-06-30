package com.student.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sessionFactory;
	private static SqlSession session;
	static {
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static SqlSession getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(SqlSession s) {
		if (session != null) {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		session = getSession();
		System.out.println(session);
	}
}
