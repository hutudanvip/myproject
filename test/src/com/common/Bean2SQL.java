package com.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��javabeanת����SQL
 * @author 051781
 *
 */
public class Bean2SQL {
	
	private static Map<String, String> map;
	static {
		map = new HashMap<String, String>();
		map.put("String", "varchar2(20)");
		map.put("int", "int default 0");
		map.put("Date", "date");
		map.put("Timestamp", "timestamp(6)");
		map.put("BigDecimal", "number(10,2)");
		map.put("boolean", "int");
	}
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ���ȡbean��ÿ���ֶΡ�  ȱ�ݣ����ܻ�ȡ��̳е�����ֶ�
		 * ʱ�䣺2013-12-30����10:55:41
		 * param:
		 * return��
	 */
	public static String getBeanFields(String beanName) {
		StringBuffer sb = new StringBuffer();
		try {
			//��ȡ��
			Class clz = Class.forName(beanName);
			//��ȡ���и�����
			Field[] strs = clz.getDeclaredFields();
			
			for(int i=0; i<strs.length; i++) {
				//�����ݿ�����淶��ÿ���ֶ�ǰ�����f
//				sb.append("f" + strs[i].getName() + ", ");
				sb.append(strs[i].getName() + ", ");
			}
			
			//ɾ�����һ������
			sb.deleteCharAt(sb.lastIndexOf(","));
			
			return sb.toString();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ���ȡ�������
		 * ʱ�䣺2013-12-30����11:23:23
		 * param:
		 * return��
	 */
	public static String getCreateSQL(String beanName) {
		List<String> propertyList = getBeanPropertyList(beanName);
		
		StringBuffer sb = new StringBuffer();
		String tableName = beanName.substring(beanName.lastIndexOf(".") + 1).toLowerCase();
		sb.append(" create table t_" + tableName + "( \r\n");
		
		String[] field = null;
		String fieldType = null;
		String fieldName = null;
		
		for(String str : propertyList) {
			field = str.split(":");
			fieldType = field[0];
			fieldName = "f" + field[1]+ " ";
			
			//����ֶ�ΪID������Ϊ����
			if(fieldName.trim().equals("fid")) {
				sb.append(" fid varchar2(44) primary key, \r\n ");
			} else {
				sb.append(fieldName +  map.get(fieldType) + " , \r\n");
			}
			
		}
		//ɾ�����һ������
		sb.deleteCharAt(sb.toString().lastIndexOf(","));
		//����
		sb.append(" ); ");
		
		return sb.toString();
	}
	
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ���ȡע�ͽű�
		 * ʱ�䣺2014-1-2����8:32:00
		 * param:
		 * return��
	 */
	public static String getCommentSQL(String beanName) {
		//��ȡ�����ֶ�
		String proString = getBeanFields(beanName);
		
		StringBuffer sb = new StringBuffer();
		//��ȡbean���
		String tableName = beanName.substring(beanName.lastIndexOf(".") + 1).toLowerCase();
		//��ע��
		sb.append(" comment on table t_" + tableName + " is ' '; \r\n");
		
		String[] field = proString.split(",");
		
		//��ÿ���ֶ����ע��
		for(String str : field) {
			sb.append(" comment on column t_" +  tableName + "." + str.trim() + " is ' ' ; \r\n ");
		}
		
		return sb.toString();
	}
	
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ����ظ��ֶ�����
		 * ʱ�䣺2013-12-30����11:48:47
		 * param:
		 * return��
	 */
	private static List<String> getBeanPropertyList(String beanName) {
		try {
			Class clz = Class.forName(beanName);
			List<String> propertyList = new ArrayList<String>();
			
			Field[] fields = clz.getDeclaredFields();
			
			String property = null;
			for(int i=0; i<fields.length; i++) {
				//��ȡ�ֶ�����
				property = fields[i].getType().toString();
				//���ͺ��ֶ�����м���ð������
				propertyList.add(property.substring(property.lastIndexOf(".") + 1) + ":" + fields[i].getName());
			}
			
			return propertyList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ�����
		 * ʱ�䣺2013-12-30����5:47:53
		 * param:
		 * return��
	 */
	public static void main(String[] args) {
		String beanName = "com.deppon.StudentBean";
		System.out.println(getBeanFields(beanName));
		System.out.println("/*�������*/");
		System.out.println(getCreateSQL(beanName));
		System.out.println(getCommentSQL(beanName));
	}
}
