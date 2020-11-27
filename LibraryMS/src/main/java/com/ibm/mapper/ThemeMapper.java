package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Theme;

/**
 * 
 * @author:刘志勇
 * @Description:图书标题的SQL操作
 */
public interface ThemeMapper {

	public List<Theme> selectAll();

	public Theme getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Theme theme);

	public void update(Theme theme);

	public void deleteById(Integer id);

}
