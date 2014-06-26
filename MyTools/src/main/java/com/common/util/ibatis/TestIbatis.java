package com.common.util.ibatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.util.ibatis.bean.ClaimInfo;
import com.common.util.ibatis.bean.ClaimInfoChild;
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
		String code = "DP00012";
		List<String> list = dao.selectList(code);
		System.out.println("aaa");
	}
	
	@Test
	public void testInsert() {
		ClaimInfo info = new ClaimInfo();
//		info.setErrorCode("111111");
		info.setBillNum("3");
		info.setBillTye("1");
		info.setBusiCode("1");
		info.setBusiType("1");
		info.setUserCode("1");
		info.setUrl("www.baidu.com");
		List<ClaimInfo> list = new ArrayList<ClaimInfo>();
		list.add(info);
//		GregorianCalendar gc = new GregorianCalendar();
//		gc.setTime(new Date());
//		XMLGregorianCalendar xgc = null;
//		try {
//			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
//			Date date = new Date(gc.getTime().getTime());
//			info.setCreateTime(xgc);
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		info.setBillTye(billTye)
//		ClaimInfoChild child = (ClaimInfoChild) info;
//		child.setCreateDate(new java.sql.Date((new Date()).getTime()));
		dao.insert(list);
	}

}
