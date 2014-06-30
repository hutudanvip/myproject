package com.common;

import junit.framework.TestCase;

public class TestBean2SQL  extends TestCase{
	
	private static String bean = "com.deppon.StudentBean";
	public void getBeanFields() {
		System.out.println(Bean2SQL.getBeanFields(bean));
	}
}
