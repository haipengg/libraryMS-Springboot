package com.ibm.service;

import java.util.List;

import com.ibm.domain.Theme;

/**
 * 
 * @author:刘志勇
 * @Description:图书主题服务层
 */
public interface ThemeService {
	public List<Theme> selectAll();

	public Theme getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Theme theme);

	public void update(Theme theme);

	public void deleteById(Integer id);
}
