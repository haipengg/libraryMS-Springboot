package com.ibm.domain;

/**
 * 
 * @author:刘志勇
 * @Description:图书信息标签类
 */
public class BookLabel {

	private int countryId; // 国家id
	private int typeId; // 类型id
	private int themeId; // 主题id
	private int lengthRange; // 篇幅

	public int getLengthRange() {
		return lengthRange;
	}

	// 篇幅  1:短篇  2:中篇  3:长篇   4:超长篇
	public void setLengthRange(int lengthRange) {
		this.lengthRange = lengthRange;
	}

	
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

}
