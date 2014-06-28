package com.student.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 
	 * author:afei
	 * date:2013-5-22
	 * description:获取月初第一天
	 * param:
	 */
	public static Timestamp getMonthFirstDay(Timestamp time)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(time.getTime()));
		
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		
		Timestamp t = new Timestamp(c.getTime().getTime());
		
		return t;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-5-22
	 * description:获取下一月初第一天
	 * param:
	 */
	public static Timestamp getNextMonthFirstDay(Timestamp time)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(time.getTime()));
		
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		
		time = new Timestamp(c.getTime().getTime());
		
		return time;
	}
	
	public static void main(String[] args) throws ParseException {
		String str = "2013-12-15 21:06:04";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(str);
		
		System.out.println(date.toString());
		Timestamp t = new Timestamp(date.getTime());
		
		System.out.println(t.toString());
		
		date = new Date(getMonthFirstDay(t).getTime());
//		System.out.println("本月第一天时间为：" + format.format(date));
	}
}
