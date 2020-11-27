package com.ibm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @author:吕守淼
 * @Description:日期转换工具类
 */
public class DateConverter implements Converter<String, Date>{

	private SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Date convert(String source) {
		try {
			simple.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
