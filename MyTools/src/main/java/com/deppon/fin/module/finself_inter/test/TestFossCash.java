package com.deppon.fin.module.finself_inter.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deppon.fin.module.finself_inter.server.dao.IFossCashDao;
import com.deppon.fin.module.finself_inter.shared.domain.fosscash.FossCashEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext-base.xml"})
public class TestFossCash {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext-base.xml");
//	ObjectEntityDao dao = (ObjectEntityDao)ctx.getBean("objectEntityDaoImp");
//	@Test
//	public void c(){
//		System.out.println(12);
//	}
	@Resource
	public IFossCashDao dao;
	@Test
	public void testSelelct() {
		List<FossCashEntity> list = new ArrayList<FossCashEntity>();
		list = dao.selectAll();
		System.out.println(list.size());
	}
	
	@Test
	public void testInsert() {
		List<FossCashEntity> list = new ArrayList<FossCashEntity>();
		for(int i=0; i<=10; i++) {
			
			FossCashEntity en = new FossCashEntity();
			en.setDeptname("shanghai");
			en.setCashamt(new BigDecimal(0));
			en.setCashdate(new Date());
			en.setDepthnum("0000");
			list.add(en);
			dao.insert(en);
		}
		
//		dao.insertList(list);
	}
	
	@Test
	public void truncate() {
		dao.truncate();
	}

}
