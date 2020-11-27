package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author:刘志勇
 * @Description:图书信息类
 */
public class Book {

	private Integer bookId; // 图书ID
	private String bookName; // 图书名称
	private Country country; // 国家
	private String brief; // 简介
	private Integer onNumber; // 上架数量
	private Date onTime; // 上架时间
	private String onTimeStr;// 上架时间--String类型
	private Integer offNumber; // 下架数量
	private Date offTime; // 下架时间
	private String offTimeStr;// 下架时间--String类型
	private Integer surplusNumber; // 剩余数量
	private Type type; // 类型
	private Theme theme; // 主题
	// 篇幅  1:短篇  2:中篇  3:长篇   4:超长篇
	private Integer pages; 
	private List<BorrowingDetails> borrows; // 借阅记录

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getOnNumber() {
		return onNumber;
	}

	public void setOnNumber(Integer onNumber) {
		this.onNumber = onNumber;
	}

	public Date getOnTime() {
		return onTime;
	}

	public void setOnTime(Date onTime) {
		this.onTime = onTime;
		if (onTime!=null) {
			this.setOnTimeStr();
		}
	}

	public String getOnTimeStr() {
		return onTimeStr;
	}

	public void setOnTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(onTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.onTimeStr = str;
	}

	public Integer getOffNumber() {
		return offNumber;
	}

	public void setOffNumber(Integer offNumber) {
		this.offNumber = offNumber;
	}

	public Date getOffTime() {
		return offTime;
	}

	public void setOffTime(Date offTime) {
		this.offTime = offTime;
		if (offTime != null) {
			this.setOffTimeStr();
		}
	}

	public String getOffTimeStr() {
		return offTimeStr;
	}

	public void setOffTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(offTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.offTimeStr = str;
	}

	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}

	public List<BorrowingDetails> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<BorrowingDetails> borrows) {
		this.borrows = borrows;
	}

}
