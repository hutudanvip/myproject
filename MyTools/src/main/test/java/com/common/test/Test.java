package com.common.test;

import java.util.Date;

import com.common.util.date.DateTimeUtils;

import junit.framework.TestCase;

public class Test extends TestCase {
	public void testJava() {
		System.out.println("hello");
		System.out.println(DateTimeUtils.getDateOfPreNMonth(2, new Date()));
	}
}
