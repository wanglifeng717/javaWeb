/**
* Title: I18nTest.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 6, 2018
* @version 1.0
*/
package com.tongji.i18n;


import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**  
* Title: I18nTest 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 6, 2018  
*/
public class I18nTest {
	/**
	 * Locale: Java 中表示国家或地区的类. JDK 中提供了很多常量.
	 * 也可以通过 Locale(languageCode, countryCode) 的方式来创建 
	 * 在 WEB 应用中可以通过 request.getLocale() 方法来获取. 
	 */
	@Test
	public void testLocale() {
		//直接通过点的方式就可以获取
		Locale locale = Locale.CHINA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		
		//也可以通过新建对象的方式
		locale = new Locale("en", "US");
	}
	/**
	 * DateFormat: 格式化日期的工具类. 
	 * DateFormate 本身是一个抽象类. 
	 * 
	 * 1. 若只希望通过 DateFormat 把一个 Date 对象转为一个字符串, 则可以通过 DateFormat 的工厂方法来获取 DateFormat 对象
	 * 2. 可以获取只格式化 Date 的 DateFormat 对象: getDateInstance(int style, Locale aLocale) 
	 * 3. 可以获取只格式化 Time 的 DateFormat 对象: getTimeInstance(int style, Locale aLocale) 
	 * 4. 可以获取既格式化 Date, 也格式化 Time 的 DateFormat 对象: 
	 * getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale) 
	 * 5. 其中 style 可以取值为: DateFormat 的常量: SHORT, MEDIUM, LONG, FULL. Locale 则为代表国家地区的 Locale 对象
	 * 6. 通过 DateFormat 的 format 方法来格式化个 Date 对象到字符串. 
	 */
	@Test
	public void testDateFormat() {
		Locale locale = Locale.CHINA;
		Date date = new Date();
		System.out.println(date);
		//获取DateFormat对象
		DateFormat  dateFormat=
				DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
		String str= dateFormat.format(date);
		System.out.println(str);
				
	}
	 /* 7. 若有一个字符串, 如何解析为一个 Date 对象呢 ? 
	 * I. 先创建 DateFormat 对象: 创建 DateFormat 的子类 SimpleDateFormat 对象
	 * SimpleDateFormat(String pattern). 
	 * 其中 pattern 为日期, 时间的格式, 例如: yyyy-MM-dd hh:mm:ss
	 * II. 调用 DateFormat 的 parse 方法来解析字符串到 Date 对象.  
	 * 
	 */
	@Test
	public void testDateFormat2() throws ParseException {
		String string="1990-12-12 12:12:12";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date date = dateFormat.parse(string);
		System.out.println(date);
	}
	
	/**
	 * NumberFormat: 格式化数字到数字字符串, 或货币字符串的工具类
	 * 1. 通过工厂方法获取 NumberFormat 对象
	 * NumberFormat.getNumberInstance(locale); //仅格式化为数字的字符串
	 * NumberFormat.getCurrencyInstance(locale); //格式为货币的字符串
	 * 
	 * 2. 通过 format 方法来进行格式化
	 * 3. 通过 parse 方法把一个字符串解析为一个 Number 类型. 
	 */
	@Test
	public void testNumberFormat() throws ParseException{
		double d = 123456789.123d;
		Locale locale = Locale.FRANCE;
		
		//数字格式
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		
		String str = numberFormat.format(d);
		System.out.println(str); 
		//货币类型 $ ￥
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
		str = numberFormat2.format(d);
		System.out.println(str); 
		 
		str = "123 456 789,123";
		d = (Double) numberFormat.parse(str);
		System.out.println(d); 
		
		str = "123 456 789,12 €";
		d = (Double) numberFormat2.parse(str);
		System.out.println(d);
	}
	
	/**
	 * MessageFormat: 可以格式化模式字符串
	 * 模式字符串: 带占位符的字符串: "Date: {0}, Salary: {1}"
	 * 可以通过 format 方法会模式字符串进行格式化
	 */
	@Test
	public void testMessageFormat(){
		String str = "Date: {0}, Salary: {1}";
		
		Locale locale = Locale.CHINA;
		Date date = new Date();
		double sal = 12345.12;
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String dateStr = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salStr = numberFormat.format(sal);
		
		String result = MessageFormat.format(str, dateStr, salStr);
		System.out.println(result); 
	}
	
	/**
	 * ResourceBundle: 资源包类.
	 * 
	 * 1. 在类路径下需要有对应的资源文件: baseName.properties. 其中 baseName 是基名.
	 * 2. 可以使用 基名_语言代码_国家代码.properties 来添加不同国家或地区的资源文件. i18n_zh_CN.properties
	 * 3. 要求所有基名相同的资源文件的 key 必须完全一致. 
	 * 4. 可以使用 native2ascii 命令来得到 汉字 对一个的 asc 码. Eclipse 内置了工具
	 * 5. 可以调用 ResourceBundle 的 getBundle(基名, Locale 实例) 获取获取 ResourceBundle 对象
	 * 6. 可以调用 ResourceBundle 的 getString(key) 来获取资源文件的 value 字符串的值. 
	 * 7. 结合 DateFormat, NumberFormat, MessageFormat 即可实现国际化. 
	 * 
	 */
	@Test
	public void testResourceBundle(){
		Locale locale = Locale.CHINA;  
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
	
		System.out.println(resourceBundle.getString("date"));
		System.out.println(resourceBundle.getString("salary"));
		
		String dateLabel = resourceBundle.getString("date");
		String salLabel = resourceBundle.getString("salary");
		
		String str = "{0}:{1}, {2}:{3}";
		
		Date date = new Date();
		double sal = 12345.12;
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String dateStr = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salStr = numberFormat.format(sal);
		
		String result = MessageFormat.format(str, dateLabel, dateStr, salLabel, salStr);
		System.out.println(result); 
	}
	
	
}
				
				
				