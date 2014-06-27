package com.common.util.date;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date d = DateTimeUtils.getBeforeSomeDay(new Date(), 1);
		System.out.println(d);
	}
}
