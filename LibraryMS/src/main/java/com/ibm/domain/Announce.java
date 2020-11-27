package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author:邱海鹏
 * @Description:公告类
 */
public class Announce {
	private  int announceId;         //公告id
	private  Date announceTime;      //公告日期
	private String announceTimeStr;
	private  String announceContent;  //公告内容
	public int getAnnounceID() {
		return announceId;
	}
	public void setAnnounceID(int announceID) {
		this.announceId = announceID;
	}
	public Date getAnnounceTime() {
		return announceTime;
	}
	public void setAnnounceTime(Date announceTime) {
		this.announceTime = announceTime;
		this.setAnnounceTimeStr();
	}
	public int getAnnounceId() {
		return announceId;
	}
	public void setAnnounceId(int announceId) {
		this.announceId = announceId;
	}
	public String getAnnounceTimeStr() {
		return announceTimeStr;
	}
	public void setAnnounceTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(announceTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.announceTimeStr = str;
	}
	public String getAnnounceContent() {
		return announceContent;
	}
	public void setAnnounceContent(String announceContent) {
		this.announceContent = announceContent;
	}
	@Override
	public String toString() {
		return "announce [announceID=" + announceId + ", announceTime=" + announceTime + ", announceContent="
				+ announceContent + "]";
	}
	
	

}
