package com.common.util.ibatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.util.ibatis.bean.ClaimInfo;
import com.common.util.ibatis.dao.ObjectEntityDao;
import com.common.util.ibatis.server.ObjectEntityService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext-base.xml"})
public class TestIbatis {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext-base.xml");
//	ObjectEntityDao dao = (ObjectEntityDao)ctx.getBean("objectEntityDaoImp");
//	@Test
//	public void c(){
//		System.out.println(12);
//	}
	@Resource
	public ObjectEntityDao dao;
	@Test
	public void testSelelct() {
		String code = "1";
		dao.select(code);
	}
	
	@Test
	public void testInsert() {
		ClaimInfo info = new ClaimInfo();
		info.setErrorCode("123");
		
		dao.insert(info);
	}

}
