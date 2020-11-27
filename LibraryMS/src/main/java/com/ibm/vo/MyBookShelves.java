package com.ibm.vo;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author:吕守淼
 * @Description:用户书架类
 */
public class MyBookShelves {
	private int borrowId;
	private int bookId;
	private String bookName;
	private Date borrowTime;
	private Date deadline;
	private String borrowTimeStr;
	private String deadlineStr;
	private String themeName;
	private String countryName;
	private String typeName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public String getBorrowTimeStr() {
		return borrowTimeStr;
	}
	public void setBorrowTimeStr(String borrowTimeStr) {
		this.borrowTimeStr = borrowTimeStr;
	}
	public String getDeadlineStr() {
		return deadlineStr;
	}
	public void setDeadlineStr(String deadlineStr) {
		this.deadlineStr = deadlineStr;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(borrowTime);					
		String str = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
		this.setBorrowTimeStr(str);
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deadline);					
		String str = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
		this.setDeadlineStr(str);
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
