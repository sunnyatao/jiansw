/**
 * Copyright    : Copyright (c) 2014. Kanebay Corp. All rights reserved
 * auth: sunny
 * File Summary : 
 * Create time  : 2014-12-16
 */

package com.jianan.software.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 处理日期的工具类
 * @author robert
 *
 */
public class DateUtil {
	
	//日期的格式
	public static final String dateFormat = "yyyy-MM-dd";
	public static final String yearFormat = "yyyy";
	
	public static final String TODAY_STR = "today";
	
	public static Map<String, String> y2d = new HashMap<String, String>();
	
	static {
		y2d.put("一月", "1");
		y2d.put("二月", "1");
		y2d.put("三月", "1");
		y2d.put("四月", "1");
		y2d.put("五月", "1");
		y2d.put("六月", "1");
		y2d.put("七月", "1");
		y2d.put("八月", "1");
		y2d.put("九月", "1");
		y2d.put("十月", "1");
		y2d.put("十一月", "1");
		y2d.put("十二月", "1");
	}
	
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	public static String getYear() {
		Date date = new Date();
		SimpleDateFormat yearDateFormat = new SimpleDateFormat(yearFormat);
		return yearDateFormat.format(date);
	}
	
	public static String getmonth() {
		Date date = new Date();
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		return monthFormat.format(date);
	}

	public static String getDay() {
		Date date = new Date();
		SimpleDateFormat monthFormat = new SimpleDateFormat("dd");
		return monthFormat.format(date);
	}

	public static String getYear(Date date) {
		SimpleDateFormat yearDateFormat = new SimpleDateFormat(yearFormat);
		return yearDateFormat.format(date);
	}
	
	public static String getmonth(Date date) {
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		return monthFormat.format(date);
	}
	
	public static String getDay(Date date) {
		SimpleDateFormat monthFormat = new SimpleDateFormat("dd");
		return monthFormat.format(date);
	}
	
	/**
	 * 获得指定日期的前一天的Date对象
	 * @param dateStr
	 * @return
	 */
	public static Date getYesterdayFor(String dateStr) {
		Calendar calendar = Calendar.getInstance();
		if (!TODAY_STR.equals(dateStr)) {
			Date date = null;
			try {
				date = parseDate(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (null == date) {
				return null;
			}
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, -1);
		Date yesterday = calendar.getTime();
		return yesterday;
	}
	
	/**
	 * 获得当前日期前一天的Date对象
	 * @return
	 */
	public static Date getYesterday() {
		return getYesterdayFor(TODAY_STR);
	}
	
	/**
	 * 获得距现在days天的数据，days可以为负
	 * @param days
	 * @return
	 */
	public static Date getDateAfterDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	/**
	 * 获得距d的days天的数据，days可以为负
	 * @param days
	 * @return
	 */
	public static Date getDateAfterDays(Date d, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	/**
	 * 获得距现在days天的数据，days可以为负
	 * @param days
	 * @return
	 */
	public static Date getDateAfterMinutes(Date d, int minutes) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minutes);
		return now.getTime();
	}
	
	/**
	 * 获得当前日期前一天的字符串形式
	 * @return
	 */
	public synchronized static String getYesterdayStrFor(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(getYesterdayFor(dateStr));
	}
	
	/**
	 * 获得当前日期前一天的字符串形式
	 * @return
	 */
	public synchronized static String getYesterdayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(getYesterday());
	}
	
	/**
	 * 获得当前日期
	 * @return
	 */
	public synchronized static Date getToday() {
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		return today;
	}

	/**
	 * 获得当前日期的字符串形式
	 * @return
	 */
	public synchronized static String getTodayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(getToday());
	}
	
	/**
	 * 转换字符串到Date对象
	 * @param dateStr
	 * @return
	 * @throws Exception
	 */
	public synchronized static Date parseDate(String dateStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.parse(dateStr);
	}
	
	/**
	 * 获得当前时间起hour小时之后的时间
	 * @param d
	 * @param hour
	 * @return
	 */
	public static Date getDateAfterHours(int hour) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR, hour);
		return now.getTime();
	}
	
	/**
	 * 获得以秒计时的时间差
	 * @param parseDate1
	 * @param parseDate2
	 * @return
	 */
	static public long differenceInSecond(Date parseDate1, Date parseDate2) {
		// 日期相减得到相差的日期
		long diff = 0;
		diff = (parseDate1.getTime() - parseDate2.getTime()) / (1000);
		return diff;
	}
	
	/**
	 * 获得以分钟计时的时间差
	 * @param parseDate1
	 * @param parseDate2
	 * @return
	 */
	static public long differenceInMinute(Date parseDate1, Date parseDate2) {
		// 日期相减得到相差的日期
		long diff = 0;
		diff = (parseDate1.getTime() - parseDate2.getTime()) / (60 * 1000);
		return diff;
	}
	
	/**
	 * 获得以分钟计时的时间差
	 * @param parseDate1
	 * @param parseDate2
	 * @return
	 */
	static public long differenceInDay(Date parseDate1, Date parseDate2) {
		// 日期相减得到相差的日期
		long diff = 0;
		diff = (parseDate1.getTime() - parseDate2.getTime()) / (60 * 1000 * 60 * 24);
		return diff;
	}
	
	static public int getDiffYear(Date before, Date after) {
		try {
			int diff = after.getYear() - before.getYear();
			if (diff == 0) {
				return 1;
			}
			int dateDiff = getDateDiff(before, after);
			
			return dateDiff/365;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	static public int differenceInMonth(Date before, Date  after) {
		int dateDiff = getDateDiff(before, after);
		
		return dateDiff/30;
	}
	
	/**
	 * 获得以日计时的时间差
	 * @param parseDate1
	 * @param parseDate2
	 * @return
	 */
	static public int differenceInDays(Date parseDate1, Date parseDate2) {
		// 日期相减得到相差的日期
		long diff = 0;
		diff = (parseDate1.getTime() - parseDate2.getTime()) / (60 * 1000 * 60 * 24);
		return (int)diff;
	}
	
	/**
	 * 获取当前日期中的月
	 * 
	 * @return java.lang.String
	 */
	public static int getCurrentMonth() {
		String month;
		SimpleDateFormat df = new SimpleDateFormat("MM");
		month = df.format(new Date());
		return Integer.parseInt(month);
	}

	/**
	 * 获取当前日期中的年
	 * 
	 * @return java.lang.String
	 */
	public static int getCurrentYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return Integer.parseInt(df.format(new Date()));
	}
	
	/**
	 * 获取两个日期的相差天数
	 * @param before: 2010-04-15 13:17:01
	 * @param after: 2013-04-23 15:38:21
	 * @return
	 */
	public static int getDateDiff(Date before, Date after) {
		return (int) (-(before.getTime() - after.getTime()) / (3600L * 1000 * 24));
	}

	public static Date getTodayZero() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());

		try {
			Date zero = sdf.parse(today);
			return  zero;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Date parseDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			for (Entry<String, String> entry: y2d.entrySet()) {
				if (dateStr.contains(entry.getKey())) {
					dateStr = dateStr.replace(entry.getKey(), entry.getValue());
					break;
				}
			}
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String dateStr = "01-一月-1900";
		String format = "dd-mm-yy";
		Date date = parseDate(dateStr, format);
		System.out.println(date);
	}
}

