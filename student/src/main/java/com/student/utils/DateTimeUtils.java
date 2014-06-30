/**
 * 
 */
package com.student.utils;

/*
 * �������� 2006-4-21
 *
 * TODO Ҫ��Ĵ���ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */


import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @author������� 
 * @E-mail: dejavu.house@gmail.com
 * @CreateDate��2006-4-21
 * @LastUpdateDate:
 * @description: a date process tool that extends from com.kingdee.util.DateTimeUtils
 * @:
 */
public class DateTimeUtils 
{
    /**
     * ����2199�꣬��������дʧЧ����
     * @author �����
     * @date 2006-12-12
     * @E-mail: dejavu.house@gmail.com
     * @return
     */
    public static Date getCustomMaximumDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(2200, Calendar.JANUARY, 1, 0, 0, 0);
        cal.add(Calendar.SECOND, -1);
        
        return cal.getTime();
    }
    
    public static Date getCustomMinimumDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(1900, Calendar.JANUARY, 1, 0, 0, 0);
        cal.add(Calendar.SECOND, -1);
        
        return cal.getTime();
    }
    
    /**
     * ��һ��java.util.Date.toString()���磺Fri Nov 03 16:43:29 CST 2006�����ַ�ת����Ӧ��Date
     * @author κ��
     * @date 2006-11-3
     * @E-mail: dejavu.house@gmail.com
     * @param toStringDate
     * @return
     */
    public static Date getDateWithDefaultJavaDateStr(String toStringDate)
    {
        String defaultJavaStrFormat = "EEE MMM dd HH:mm:ss z yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(defaultJavaStrFormat ,Locale.ENGLISH);
        Date date = null;
        try
        {
            date = formatter.parse(toStringDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        
        return date;
    }
    
    /**
     * ��ȡ�����ڵ�ǰһ��
     * @���ߣ������
     * @�������ڣ�2006-8-10
     * @��������������
     * @param date
     * @return:
     * @ʹ��ʾ��
     * @�޸ģ�
     */
    public static Date getYesterdayDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
       
        Date yesterday = calendar.getTime();
        
        return yesterday;
    }
    
    public static Date getYesterdayDateWithZeroTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date yesterday = calendar.getTime();
        
        return yesterday;
    }
    
    public static Date getPreDayStart(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date preDay = calendar.getTime();
        
        return preDay;
    }
    
    /**
     * ��ȡ�����ڵ���һ�죬ʱ��Ϊ00:00:00.000
     * @���ߣ������
     * @�������ڣ�2006-6-29
     * @��������������
     * @param date
     * @return:
     * @ʹ��ʾ��
     * @�޸ģ�
     */
    public static Date getNextDateWithZeroTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        return newDate;
    }
    
    /**
     *@deprecated �ѱ����� getDateStartPoint(Date date) ����     * �� �ߣ������ 
     * ����޸�ʱ�䣺2006-6-15
     * �� ��������һ��ʱ�������Ϊ0��Date
     * ���¼�¼�� 1.xx��xx��xx�գ��޸���xxx�����ӹ��ܰ�����xxxxxxxx 
     * @param date
     * @return
     */
    public static Date getDateWithZeroTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        return newDate;
    }
    
    /**
     * ��ȡһ��Ŀ�ʼ��������������
     * @author κ��
     * @date 2006-12-15
     * @E-mail: dejavu.house@gmail.com
     * @param date
     * @return
     */
    public static Date getDayStart(Date date)
    {
        if(date == null)
        {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        return newDate;
    }
    
    public static Date getNextDayStart(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        return newDate;
    }
    
    /**
     * ��ȡһ��Ľ�����ʮ�����ʮ�ŷ���ʮ����
     * @author κ��
     * @date 2006-12-15
     * @E-mail: dejavu.house@gmail.com
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date)
    {
        if(date == null)
        {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date newDate = calendar.getTime();
        
        return newDate;
    }
    
    /**
     * 
     * @author κ��
     * @date 2007-4-3
     * @E-mail: dejavu.house@gmail.com
     * @param date
     * @return
     */
    public static String getDateStrWithTime(Date date)
    {
    	return getDateString(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * �� �ߣ������ 
     * ����޸�ʱ�䣺2006-6-15
     * �� ��������һ��ʱ�������Ϊ0��"yyyy-MM-dd HH:mm:ss"�����ַ�
     * ���¼�¼�� 1.xx��xx��xx�գ��޸���xxx�����ӹ��ܰ�����xxxxxxxx 
     * @param date
     * @return
     */
    public static String getDateStrWithZeroTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(newDate);
        
        return dateStr;
    }
   
   
    /**
     * ��ȡ�ϸ��µĸ����ڣ��磺������Ϊ��2006-10-11���򷵻ص�����Ϊ��2006-9-11
     * @���ߣ������
     * @���ڣ�2006-10-10
     * @��������������
     * @param date
     * @return:
     * @ʹ��ʾ��
     * @�޸ģ�
     */
    public static Date getDateOfLastMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
       
        Date dateOfLastMonth = calendar.getTime();
        
        return dateOfLastMonth;
    }
    
    public static Date get1stDayOfTheMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
       
        Date firstDateOfLastMonth = calendar.getTime();
        
        return firstDateOfLastMonth;
    }
    
    /**
     * ��ȡ�����������·������һ�������
     * @author κ��
     * @date 2006-11-23
     * @E-mail: dejavu.house@gmail.com
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        
        Date lastDayOfMonth = calendar.getTime();
        
        return lastDayOfMonth;
    }
    
    public static String getDateStrWithZeroTime(Date date, String pattern)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date newDate = calendar.getTime();
        
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        String dateStr = format.format(newDate);
        
        return dateStr;
    }
    
    /**
     * @author������� 
     * @CreateDate��2006-4-21
     * @LastUpdateDate:
     * @description: 
     * @param endDay: ��������
     * @param startingDay: ��ʼ����
     * @return: �����������ڵ��������
     */
    public static int dateDiffInDays(Date endDay, Date startingDay)
    {
        long intervalInMillis = endDay.getTime() - startingDay.getTime();
        long intervalInDays = intervalInMillis/getIntervalForOneDayInMillis();
        
        return new Long(intervalInDays).intValue();
    }
    
    /**
     * �����������ڵ��������2006-12-18��2006-12-19���һ���㣩
     * @author κ��
     * @date 2007-7-1
     * @param startDate
     * @param endDate
     * @return
     */
    public static int dateDiffInDay(Date startDate, Date endDate)
    {
        long intervalInMillis = endDate.getTime() - startDate.getTime();
        long intervalInDays = intervalInMillis/getIntervalForOneDayInMillis();
        
        return new Long(intervalInDays).intValue();
    }
    
    /**
     * �����������ڵ��������
     * @���� κ��
     * @����  2007-7-1
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int dateDiffInMonths(Date fromDate,Date toDate){
         int mons=(toDate.getYear()-fromDate.getYear())*12+(toDate.getMonth()-fromDate.getMonth());
        return mons;
    }
    /**
     * �����������ڵ����������
     *  * @author κ��
     * @����  2007-7-1
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int dateDiffInWeeks(Date fromDate,Date toDate){
     int weeks=(DateTimeUtils.weekNumber(DateTimeUtils.getTimestamp(toDate.getTime()))-DateTimeUtils.weekNumber(DateTimeUtils.getTimestamp(fromDate.getTime())));
    return weeks;
   }
    /**
     * �����������ڵ�������
     *  * @author κ��
     * @����  2007-7-1
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int dateDiffInQuarters(Date fromDate,Date toDate){
             int  Quarters=(DateTimeUtils.quarterNumber(DateTimeUtils.getTimestamp(toDate.getTime()))-DateTimeUtils.quarterNumber(DateTimeUtils.getTimestamp(fromDate.getTime())));
        return Quarters;
      }
    

    /**
     * ��ȡTimestamp
     * @���� κ��
     * @����  2007-7-1
     * @param time ����long
     * @return
     */
    public static java.sql.Timestamp getTimestamp(long time) {
        return new java.sql.Timestamp(time);
    }
    
    
    
    /**
     * @author��κ�� 
     * @CreateDate��2007-7-1
     * @LastUpdateDate:
     * @description: ��ȡ������/�족�ĵ�λֵ
     * @return:
     */
    public static long getIntervalForOneDayInMillis()
    {
        long oneDayInMillis = 1000*3600*24;
        
        return oneDayInMillis;
    }
    
    /**
     * 
     * @���ߣ�������
     * @���ڣ�2007-7-1
     * @param date
     * @param pattern
     * @return: str ��ʽ����������ַ�
     * @�������������������ڸ�ʽ�����ƶ���ģʽ�ַ�
     */
    public static String getDateString(Date date,String pattern){
        String str=null;
        
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        str = format.format(date);
        
        return str;
    }
    
    /**
     * 
     * @���ߣ�������
     * @���ڣ�2006-5-24
     * @param date
     * @return: str ��ʽ����������ַ�
     * @�������������������ڸ�ʽ����yyyy-MM-ddģʽ���ַ�
     */
    public static String getDateString(Date date){
        String str=null;
        
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        str = format.format(date);
        
        return str;
    }
    
    
    /**
     * @Author��LiYanlong
     * @Date��2006-6-29
     * @Description: ��ȡû��ʱ��ĵ�ǰ����
     * @return
     * @throws ParseException
     */
    public static Date getCurDate() throws ParseException{
        Date re = null;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        re = format.parse(getDateString(new Date()));
        return re;
    }
    
    
    /**
     * ��õ�ǰ����
     * @���ߣ� κ��
     * @����  2007-7-1
     * @return
     */
    public static java.util.Date nowDate() {
        return new java.util.Date();
    }
    
    
/**
 * ��ȡһ��Ŀ�ʼʱ��
 * @����  κ��
 * @����  2007-7-1
 * @param stamp
 * @return
 */
    public static java.sql.Timestamp getDayStart(java.sql.Timestamp stamp) {
        return getDayStart(stamp, 0);
    }
/**
 * ĳ����֮��daysLater��Ŀ�ʼʱ��
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @param daysLater
 * @return
 */
    public static java.sql.Timestamp getDayStart(java.sql.Timestamp stamp, int daysLater) {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new java.util.Date(stamp.getTime()));
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        java.sql.Timestamp retStamp = new java.sql.Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }
/**
 * ��һ��Ŀ�ʼʱ��
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @return
 */
    public static java.sql.Timestamp getNextDayStart(java.sql.Timestamp stamp) {
        return getDayStart(stamp, 1);
    }
/**
 * һ��Ľ���ʱ��
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @return
 */
    public static java.sql.Timestamp getDayEnd(java.sql.Timestamp stamp) {
        return getDayEnd(stamp, 0);
    }

    public static java.sql.Timestamp getDayEnd(java.sql.Timestamp stamp, int daysLater) {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new java.util.Date(stamp.getTime()));
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        java.sql.Timestamp retStamp = new java.sql.Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(999999999);
        return retStamp;
    }

/**
 *  ��ȡĳ��ĵ�һ�쿪ʼʱ��
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @return
 */
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp) {
        return getYearStart(stamp, 0, 0);
    }
/**
 * ��ȡĳ��ĵ�һ�쿪ʼʱ��
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @param daysLater
 * @return
 */
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, int daysLater) {
        return getYearStart(stamp, daysLater, 0);
    }
/**
 * ��ȡĳ��Ŀ�ʼʱ��,daysLater���yearsLater���
 * @���ߣ� κ��
 * @����  2007-7-1
 * @param stamp
 * @param daysLater
 * @param yearsLater
 * @return
 */
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, int daysLater, int yearsLater) {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new java.util.Date(stamp.getTime()));
        tempCal.set(tempCal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        tempCal.add(Calendar.YEAR, yearsLater);
        java.sql.Timestamp retStamp = new java.sql.Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

 /**
  * ��ȡĳ�µĿ�ʼʱ��
  * @����   κ��
  * @����  2007-7-1
  * @param stamp
  * @return
  */
    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp) {
        return getMonthStart(stamp, 0, 0);
    }

    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp, int daysLater) {
        return getMonthStart(stamp, daysLater, 0);
    }

    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp, int daysLater, int monthsLater) {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new java.util.Date(stamp.getTime()));
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), 1, 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        tempCal.add(Calendar.MONTH, monthsLater);
        java.sql.Timestamp retStamp = new java.sql.Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    /**
     * Return the date for the first day of the week
     *
     * @param stamp
     * @return
     */
    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp) {
        return getWeekStart(stamp, 0, 0);
    }

    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp, int daysLater) {
        return getWeekStart(stamp, daysLater, 0);
    }

    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp, int daysLater, int weeksLater) {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new java.util.Date(stamp.getTime()));
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());
        tempCal.add(Calendar.WEEK_OF_MONTH, weeksLater);
        java.sql.Timestamp retStamp = new java.sql.Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    /**
     * Converts a date String into a java.sql.Date
     *
     * @param date The date String: MM/DD/YYYY
     * @return A java.sql.Date made from the date String
     */
    public static java.sql.Date toSqlDate(String date) {
        java.util.Date newDate = toDate(date, "00:00:00");

        if (newDate != null) {
            return new java.sql.Date(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a java.sql.Date from separate Strings for month, day, year
     *
     * @param monthStr The month String
     * @param dayStr   The day String
     * @param yearStr  The year String
     * @return A java.sql.Date made from separate Strings for month, day, year
     */
    public static java.sql.Date toSqlDate(String monthStr, String dayStr, String yearStr) {
        java.util.Date newDate = toDate(monthStr, dayStr, yearStr, "0", "0", "0");

        if (newDate != null) {
            return new java.sql.Date(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a java.sql.Date from separate ints for month, day, year
     *
     * @param month The month int
     * @param day   The day int
     * @param year  The year int
     * @return A java.sql.Date made from separate ints for month, day, year
     */
    public static java.sql.Date toSqlDate(int month, int day, int year) {
        java.util.Date newDate = toDate(month, day, year, 0, 0, 0);

        if (newDate != null) {
            return new java.sql.Date(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Converts a time String into a java.sql.Time
     *
     * @param time The time String: either HH:MM or HH:MM:SS
     * @return A java.sql.Time made from the time String
     */
    public static java.sql.Time toSqlTime(String time) {
        java.util.Date newDate = toDate("1/1/1970", time);

        if (newDate != null) {
            return new java.sql.Time(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a java.sql.Time from separate Strings for hour, minute, and second.
     *
     * @param hourStr   The hour String
     * @param minuteStr The minute String
     * @param secondStr The second String
     * @return A java.sql.Time made from separate Strings for hour, minute, and second.
     */
    public static java.sql.Time toSqlTime(String hourStr, String minuteStr, String secondStr) {
        java.util.Date newDate = toDate("0", "0", "0", hourStr, minuteStr, secondStr);

        if (newDate != null) {
            return new java.sql.Time(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a java.sql.Time from separate ints for hour, minute, and second.
     *
     * @param hour   The hour int
     * @param minute The minute int
     * @param second The second int
     * @return A java.sql.Time made from separate ints for hour, minute, and second.
     */
    public static java.sql.Time toSqlTime(int hour, int minute, int second) {
        java.util.Date newDate = toDate(0, 0, 0, hour, minute, second);

        if (newDate != null) {
            return new java.sql.Time(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Converts a date and time String into a Timestamp
     *
     * @param dateTime A combined data and time string in the format "MM/DD/YYYY HH:MM:SS", the seconds are optional
     * @return The corresponding Timestamp
     */
    public static java.sql.Timestamp toTimestamp(String dateTime) {
        java.util.Date newDate = toDate(dateTime);

        if (newDate != null) {
            return new java.sql.Timestamp(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Converts a date String and a time String into a Timestamp
     *
     * @param date The date String: MM/DD/YYYY
     * @param time The time String: either HH:MM or HH:MM:SS
     * @return A Timestamp made from the date and time Strings
     */
    public static java.sql.Timestamp toTimestamp(String date, String time) {
        java.util.Date newDate = toDate(date, time);

        if (newDate != null) {
            return new java.sql.Timestamp(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a Timestamp from separate Strings for month, day, year, hour, minute, and second.
     *
     * @param monthStr  The month String
     * @param dayStr    The day String
     * @param yearStr   The year String
     * @param hourStr   The hour String
     * @param minuteStr The minute String
     * @param secondStr The second String
     * @return A Timestamp made from separate Strings for month, day, year, hour, minute, and second.
     */
    public static java.sql.Timestamp toTimestamp(String monthStr, String dayStr, String yearStr, String hourStr,
            String minuteStr, String secondStr) {
        java.util.Date newDate = toDate(monthStr, dayStr, yearStr, hourStr, minuteStr, secondStr);

        if (newDate != null) {
            return new java.sql.Timestamp(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Makes a Timestamp from separate ints for month, day, year, hour, minute, and second.
     *
     * @param month  The month int
     * @param day    The day int
     * @param year   The year int
     * @param hour   The hour int
     * @param minute The minute int
     * @param second The second int
     * @return A Timestamp made from separate ints for month, day, year, hour, minute, and second.
     */
    public static java.sql.Timestamp toTimestamp(int month, int day, int year, int hour, int minute, int second) {
        java.util.Date newDate = toDate(month, day, year, hour, minute, second);

        if (newDate != null) {
            return new java.sql.Timestamp(newDate.getTime());
        } else {
            return null;
        }
    }

    /**
     * Converts a date and time String into a Date
     *
     * @param dateTime A combined data and time string in the format "MM/DD/YYYY HH:MM:SS", the seconds are optional
     * @return The corresponding Date
     */
    public static java.util.Date toDate(String dateTime) {
        if (dateTime == null) {
            return null;
        }
        // dateTime must have one space between the date and time...
        String date = dateTime.substring(0, dateTime.indexOf(" "));
        String time = dateTime.substring(dateTime.indexOf(" ") + 1);

        return toDate(date, time);
    }

    /**
     * Converts a date String and a time String into a Date
     *
     * @param date The date String: MM/DD/YYYY
     * @param time The time String: either HH:MM or HH:MM:SS
     * @return A Date made from the date and time Strings
     */
    public static java.util.Date toDate(String date, String time) {
        if (date == null || time == null) return null;
        String month;
        String day;
        String year;
        String hour;
        String minute;
        String second;

        int dateSlash1 = date.indexOf("/");
        int dateSlash2 = date.lastIndexOf("/");

        if (dateSlash1 <= 0 || dateSlash1 == dateSlash2) return null;
        int timeColon1 = time.indexOf(":");
        int timeColon2 = time.lastIndexOf(":");

        if (timeColon1 <= 0) return null;
        month = date.substring(0, dateSlash1);
        day = date.substring(dateSlash1 + 1, dateSlash2);
        year = date.substring(dateSlash2 + 1);
        hour = time.substring(0, timeColon1);

        if (timeColon1 == timeColon2) {
            minute = time.substring(timeColon1 + 1);
            second = "0";
        } else {
            minute = time.substring(timeColon1 + 1, timeColon2);
            second = time.substring(timeColon2 + 1);
        }

        return toDate(month, day, year, hour, minute, second);
    }

    /**
     * Makes a Date from separate Strings for month, day, year, hour, minute, and second.
     *
     * @param monthStr  The month String
     * @param dayStr    The day String
     * @param yearStr   The year String
     * @param hourStr   The hour String
     * @param minuteStr The minute String
     * @param secondStr The second String
     * @return A Date made from separate Strings for month, day, year, hour, minute, and second.
     */
    public static java.util.Date toDate(String monthStr, String dayStr, String yearStr, String hourStr,
            String minuteStr, String secondStr) {
        int month, day, year, hour, minute, second;

        try {
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            year = Integer.parseInt(yearStr);
            hour = Integer.parseInt(hourStr);
            minute = Integer.parseInt(minuteStr);
            second = Integer.parseInt(secondStr);
        } catch (Exception e) {
            return null;
        }
        return toDate(month, day, year, hour, minute, second);
    }

    /**
     * Makes a Date from separate ints for month, day, year, hour, minute, and second.
     *
     * @param month  The month int
     * @param day    The day int
     * @param year   The year int
     * @param hour   The hour int
     * @param minute The minute int
     * @param second The second int
     * @return A Date made from separate ints for month, day, year, hour, minute, and second.
     */
    public static java.util.Date toDate(int month, int day, int year, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.set(year, month - 1, day, hour, minute, second);
        } catch (Exception e) {
            return null;
        }
        return new java.util.Date(calendar.getTime().getTime());
    }

    /**
     * Makes a date String in the format MM/DD/YYYY from a Date
     *
     * @param date The Date
     * @return A date String in the format MM/DD/YYYY
     */
    public static String toDateString(java.util.Date date) {
        if (date == null) return "";
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String monthStr;
        String dayStr;
        String yearStr;

        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        yearStr = "" + year;
        return monthStr + "/" + dayStr + "/" + yearStr;
    }
    /**
     * Makes a date String in the format MM-DD-YYYY from a Date
     *
     * @param date The Date
     * @return A date String in the format MM-DD-YYYY
     */
    public static String toDateString2(java.util.Date date) {
        if (date == null) return "";
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String monthStr;
        String dayStr;
        String yearStr;

        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        yearStr = "" + year;
        return monthStr + "-" + dayStr + "-" + yearStr;
    }
    /**
     * Makes a date String in the format YYYY��MM��DD�� from a Date
     *
     * @param date The Date
     * @return A date String in the format YYYY��MM��DD��
     */
    public static String toDateStringCN(java.util.Date date) {
        if (date == null) return "";
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String monthStr;
        String dayStr;
        String yearStr;

        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        yearStr = "" + year;
        return  yearStr+"��"+monthStr+"��"+dayStr+"��";
    }
    /**
     * Makes a time String in the format HH:MM:SS from a Date. If the seconds are 0, then the output is in HH:MM.
     *
     * @param date The Date
     * @return A time String in the format HH:MM:SS or HH:MM
     */
    public static String toTimeString(java.util.Date date) {
        if (date == null) return "";
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return (toTimeString(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND)));
    }

    /**
     * Makes a time String in the format HH:MM:SS from a separate ints for hour, minute, and second. If the seconds are 0, then the output is in HH:MM.
     *
     * @param hour   The hour int
     * @param minute The minute int
     * @param second The second int
     * @return A time String in the format HH:MM:SS or HH:MM
     */
    public static String toTimeString(int hour, int minute, int second) {
        String hourStr;
        String minuteStr;
        String secondStr;

        if (hour < 10) {
            hourStr = "0" + hour;
        } else {
            hourStr = "" + hour;
        }
        if (minute < 10) {
            minuteStr = "0" + minute;
        } else {
            minuteStr = "" + minute;
        }
        if (second < 10) {
            secondStr = "0" + second;
        } else {
            secondStr = "" + second;
        }
        if (second == 0) {
            return hourStr + ":" + minuteStr;
        } else {
            return hourStr + ":" + minuteStr + ":" + secondStr;
        }
    }

    /**
     * Makes a combined data and time string in the format "MM/DD/YYYY HH:MM:SS" from a Date. If the seconds are 0 they are left off.
     *
     * @param date The Date
     * @return A combined data and time string in the format "MM/DD/YYYY HH:MM:SS" where the seconds are left off if they are 0.
     */
    public static String toDateTimeString(java.util.Date date) {
        if (date == null) return "";
        String dateString = toDateString(date);
        String timeString = toTimeString(date);

        if (dateString != null && timeString != null) {
            return dateString + " " + timeString;
        } else {
            return "";
        }
    }
    
    /**
     * Makes a combined data and time string in the format "MM-DD-YYYY HH:MM:SS" from a Date. If the seconds are 0 they are left off.
     *
     * @param date The Date
     * @return A combined data and time string in the format "MM-DD-YYYY HH:MM:SS" where the seconds are left off if they are 0.
     */
    public static String toDateTimeString2(java.util.Date date) {
        if (date == null) return "";
        String dateString = toDateString2(date);
        String timeString = toTimeString(date);

        if (dateString != null && timeString != null) {
            return dateString + " " + timeString;
        } else {
            return "";
        }
    }

  /**
   * ��ǰ�¶ȵĿ�ʼʱ��
   *  * @author κ��
   * @����  2006-7-12
   * @return
   */
    public static java.sql.Timestamp monthBegin() {
        Calendar mth = Calendar.getInstance();

        mth.set(Calendar.DAY_OF_MONTH, 1);
        mth.set(Calendar.HOUR_OF_DAY, 0);
        mth.set(Calendar.MINUTE, 0);
        mth.set(Calendar.SECOND, 0);
        mth.set(Calendar.MILLISECOND, 0);
        mth.set(Calendar.AM_PM, Calendar.AM);
        return new java.sql.Timestamp(mth.getTime().getTime());
    }

/**
 * ��ȡĳ���ڵ����е����ں�
 * @���� ��׿��
 * @����  2006-10-19
 * @param input
 * @return ���ں� int
 */
    public static int weekNumber(Timestamp input) {
        Timestamp yearStart = DateTimeUtils.getYearStart(input);
        Timestamp weekStart = DateTimeUtils.getWeekStart(yearStart);
        Timestamp weekStart1=weekStart;
        int days = 0;
//        for (days = 0; DateTimeUtils.getDayStart(weekStart, days).compareTo(yearStart) == 0; days++) ;
        while(DateTimeUtils.getDayStart(weekStart).compareTo(yearStart)<0){
            days++;
            weekStart=DateTimeUtils.getDayStart(weekStart, 1);
        }
        // the splitted week belongs to the year where there are the most days (ISO)
        Timestamp week1Start = weekStart;
        if (days > 4)
            week1Start = DateTimeUtils.getWeekStart(week1Start, 7);
            

        int weeks = 0;
//        for (weeks = 0; DateTimeUtils.getDayStart(week1Start, weeks * 7).compareTo(input) < 0; weeks++) ;
        while(DateTimeUtils.getDayStart(week1Start, weeks * 7).compareTo(input) <= 0){
            ++weeks;
        }
//        for(DateTimeUtils.getDayStart(week1Start,weeks*7).compareTo(input))

        return weeks; // start at 1
    }
    /**
     * ��ȡ�ڵ����е���������
     * @���� κ��
     * @����  2006-10-19
     * @param input
     * @return ���ں� int
     */
//    public static int weekSumNumber(Timestamp input) {
//        Timestamp yearStart = DateTimeUtils.getYearStart(input);
//        Timestamp yearEnd=DateTimeUtils.getYearStart(new Timestamp(input.getTime()),-1,1);
//        Timestamp weekStart = DateTimeUtils.getWeekStart(yearStart);
//        //����1��1�ŵĿ�ʼ����
//        Timestamp weekStart1=weekStart;
//        int days = 0;
////        for (days = 0; DateTimeUtils.getDayStart(weekStart, days).compareTo(yearStart) == 0; days++) ;
//        while(DateTimeUtils.getDayStart(weekStart).compareTo(yearStart)<0){
//            days++;
//            weekStart=DateTimeUtils.getDayStart(weekStart, 1);
//        }       
//        // the splitted week belongs to the year where there are the most days (ISO)
//        Timestamp week1Start = weekStart;
//        if (days > 4)
//            week1Start = DateTimeUtils.getWeekStart(week1Start, 7);
//        days=0;
//        //�������һ��Ŀ�ʼ����
//        Timestamp weekStart2=DateTimeUtils.getWeekStart(yearEnd);
//        Timestamp weekStart3=weekStart2;
//        while(DateTimeUtils.getDayStart(weekStart2).compareTo(yearEnd)<0){
//            days++;
//            weekStart2=DateTimeUtils.getDayStart(weekStart2, 1);
//        }  
//        if(days<=3){
//            yearEnd=DateTimeUtils.getDayStart(yearEnd,-7);
//        }
//        int weeks = 0;
////        for (weeks = 0; DateTimeUtils.getDayStart(week1Start, weeks * 7).compareTo(input) < 0; weeks++) ;
//        while(DateTimeUtils.getDayStart(week1Start, weeks * 7).compareTo(yearEnd) <= 0){
//            ++weeks;
//        }
////        for(DateTimeUtils.getDayStart(week1Start,weeks*7).compareTo(input))
//
//        return weeks; // start at 1
//    }
//    
    
    /**
     * ��ȡĳ���ڵ����еļ��Ⱥ�
     * @���� κ��
     * @����  2006-7-12
     * @param input
     * @return ���ں� int
     */
        public static int quarterNumber(Timestamp input) {
//            Timestamp QuarterStart = DateTimeUtils.getQuarterStart(input);
            int q=((int)(input.getMonth())/3)+1;
 

            return q;
        }
    
    /**
     * ��ȡ���ȵĿ�ʼʱ��
     * @���� κ��
     * @����  2006-7-12
     * @param input
     * @return
     */
    public static Timestamp getQuarterStart(Timestamp input){
        
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime((Date) input);
        
        
        int month = rightNow.get(Calendar.MONTH)+1;
        int mod =(int)month/3;
        if(month<=3){
            month =1;
        }else if(month<=6){
            month =4;
        }else if(month<=9){
            month =7;
        }else{
            month=10;
        }
        
        rightNow.set(rightNow.get(Calendar.YEAR),month-1,rightNow.get(Calendar.DATE));
        Timestamp quarterStart = DateTimeUtils.getMonthStart(new java.sql.Timestamp(rightNow.getTime().getTime()));
        return new java.sql.Timestamp(quarterStart.getTime());
        
    }
/**
 * �������g
 * @���� κ��
 * @���� 2006-12-15
 * @param feedDate
 * @param baseDate
 * @return
 */
	public static int weekAge(Date feedDate, Date baseDate) {
		int weekage=0;
		weekage=new Double(((dateDiffInDays(feedDate,baseDate)+1)/7)).intValue()+1;
		return weekage;
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2007-11-29
	 * @���� ����ĳ���ǰ����
	 * @param date
	 * @param someDays
	 * @return
	 */
	public static Date getBeforeSomeDay(Date date,int someDays){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, - someDays);
        return calendar.getTime();
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2007-11-29
	 * @���� ����ĳ��ĺ���
	 * @param date
	 * @param someDays
	 * @return Date
	 */
	public static Date getAfterSomeDay(Date date ,int someDays){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, someDays);
        return calendar.getTime();
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2007-12-7
	 * @���� �ж�ĳ���Ƿ��ǵ���
	 * @return true-�ǽ��� false-���ǽ���
	 */
	public static boolean isToday(Date date){
		boolean bool = false;
		Date today = new Date();
		Date todayStart = getDayStart(today);
		Date todayEnd = getDayEnd(today);
		if(date.compareTo(todayStart) >= 0 && date.compareTo(todayEnd) <= 0){//date.after(todayStart),date.before(todayEnd)
			bool = true;
		}
		return bool;
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2008-3-20
	 * @���� �ж��������Date�Ƿ���ͬһ��
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean isSameDate(Date firstDate,Date secondDate){
		boolean same = false ;
		Date firstDateStart = getDayStart(firstDate);
		Date firstDateEnd = getDayEnd(firstDate);
		if(secondDate.compareTo(firstDateStart) >= 0 && secondDate.compareTo(firstDateEnd) <= 0)
			same = true ;
		return same ;
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2008-4-22
	 * @���� ���ظ�ʱ��hours��Сʱ���ʱ��
	 * @param oldTimestamp
	 * @param hours
	 * @return
	 */
	public static Timestamp getAfterSomeHoursTimestamp(Timestamp oldTimestamp,int hours){
		if(oldTimestamp == null)
			return null;
		if(hours < 0)
			return oldTimestamp;
		Timestamp newTimestamp = null;
		long times = oldTimestamp.getTime() + hours * 60 * 60 * 1000;
		newTimestamp = new Timestamp(times);
		return newTimestamp;
	}

	/**
	 * @���� Τ����
	 * @�������� 2008-4-22
	 * @���� ���ظ�ʱ��hours��Сʱǰ��ʱ��
	 * @param oldTimestamp
	 * @param hours
	 * @return
	 */
	public static Timestamp getBeforeSomeHoursTimestamp(Timestamp oldTimestamp,int hours){
		if(oldTimestamp == null)
			return null;
		if(hours < 0)
			return oldTimestamp;
		Timestamp newTimestamp = null;
		long times = oldTimestamp.getTime() - hours * 60 * 60 * 1000;
		newTimestamp = new Timestamp(times);
		return newTimestamp;
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2008-5-4
	 * @���� ���ظ�date��������,��date = Sun May 04 14:19:21 CST 2008 ,�򷵻�1(����һ)
	 * @param date
	 * @return
	 */
	public static int getWeekindex(Date date){
		int weekindex = 0;
		if(date == null)
			return 0;
		String[] string = date.toString().split(" ");
		if("Mon".equals(string[0]))
			weekindex = 1;
		if("Tue".equals(string[0]))
			weekindex = 2;
		if("Wed".equals(string[0]))
			weekindex = 3;
		if("Thu".equals(string[0]))
			weekindex = 4;
		if("Fri".equals(string[0]))
			weekindex = 5;
		if("Sat".equals(string[0]))
			weekindex = 6;
		if("Sun".equals(string[0]))
			weekindex = 7;
		return weekindex;
	}
	
	/**
	 * @���� Τ����
	 * @�������� 2008-7-10
	 * @���� �Ƚ�����ʱ����Ⱥ�
	 * @param firstDate
	 * @param secondDate
	 * @return firstTime ���� secondTime����1,���򷵻�-1,0
	 */
	public static int compareTime(Time firstTime,Time secondTime) throws NullPointerException{
		if(firstTime == null || secondTime == null)
			throw new NullPointerException();
		int firsthour = firstTime.getHours();
		int firstminute = firstTime.getMinutes();
		int firstsecond = firstTime.getSeconds();
		int secondhour = secondTime.getHours();
		int secondminute = secondTime.getMinutes();
		int secondsecond = secondTime.getSeconds();
		if(firsthour > secondhour)
			return 1;
		else if(firsthour < secondhour)
			return -1;
		if(firstminute > secondminute)
			return 1;
		else if(firstminute < secondminute)
			return -1;
		if(firstsecond > secondsecond)
			return 1;
		else if(firstsecond < secondsecond)
			return -1;
		else
			return 0;
	}
	
	/**
	 * ��Ӻ������
	 * @author huangbingjin 
	 * @return
	 * @parameter	
	 * @date 2008-7-21
	 */
    public static Date changeDay(Date date, int offset){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.DAY_OF_YEAR,(calendar.get(Calendar.DAY_OF_YEAR) + offset));
    	return calendar.getTime();
    	}
}
