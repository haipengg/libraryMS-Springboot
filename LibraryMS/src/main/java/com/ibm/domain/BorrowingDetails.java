package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author:刘志勇
 * @Description:借阅信息类
 */
public class BorrowingDetails {
	private int borrowId;//借阅id
	private Date borrowTime; // 借阅日期
	private String borrowTimeStr; // 借阅日期--String类型
	private Date deadline; // 截止日期
	private String deadlineStr; // 截止日期--String类型
	private Date returnTime; // 归还日期
	private String returnTimeStr; // 归还日期--String类型
	private int validTime; // 借阅有效期
	private int borrowStates; // 借阅状态
	private String borrowStatesStr; // 借阅状态
	private User user; // 用户
	private Book book;// 图书
	
	public int getBorrowId() {
		return borrowId;
	}
	
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBorrowStatesStr() {
		return borrowStatesStr;
	}

	public void setBorrowStatesStr(String borrowStatesStr) {
		this.borrowStatesStr = borrowStatesStr;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBorrowTimeStr(String borrowTimeStr) {
		this.borrowTimeStr = borrowTimeStr;
	}

	public void setDeadlineStr(String deadlineStr) {
		this.deadlineStr = deadlineStr;
	}

	public void setReturnTimeStr(String returnTimeStr) {
		this.returnTimeStr = returnTimeStr;
	}

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
		if (borrowTime!=null) {
			this.setBorrowTimeStr();
		}
	}

	public String getBorrowTimeStr() {
		return borrowTimeStr;
	}

	public void setBorrowTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(borrowTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.borrowTimeStr = str;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
		this.setDeadlineStr();
	}

	public String getDeadlineStr() {
		return deadlineStr;
	}

	public void setDeadlineStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deadline);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.deadlineStr = str;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
		if (returnTime!=null) {
			this.setReturnTimeStr();
		}
	}

	public String getReturnTimeStr() {
		return returnTimeStr;
	}

	public void setReturnTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(returnTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.returnTimeStr = str;
	}

	public int getValidTime() {
		return validTime;
	}

	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}

	public int getBorrowStates() {
		return borrowStates;
	}

	public void setBorrowStates(int borrowStates) {
		this.borrowStates = borrowStates;
		if (borrowStates==1) {
			this.setBorrowStatesStr("借阅中");
		}else {
			this.setBorrowStatesStr("已归还");
		}
	}

}
