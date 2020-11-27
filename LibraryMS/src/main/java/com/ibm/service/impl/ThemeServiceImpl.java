package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Theme;
import com.ibm.mapper.ThemeMapper;
import com.ibm.service.ThemeService;

/**
 * 
 * @author:刘志勇
 * @Description:图书主题服务层的实现类
 */
@Service
public class ThemeServiceImpl implements ThemeService {

	@Autowired
	private ThemeMapper themeMapper;

	@Override
	public List<Theme> selectAll() {
		return themeMapper.selectAll();
	}

	@Override
	public Theme getById(Integer id) {
		return themeMapper.getById(id);
	}

	@Override
	public Integer getIdByName(String name) {
		return themeMapper.getIdByName(name);
	}

	@Override
	public void save(Theme theme) {
		themeMapper.save(theme);
	}

	@Override
	public void update(Theme theme) {
		themeMapper.update(theme);
	}

	@Override
	public void deleteById(Integer id) {
		themeMapper.deleteById(id);
	}

}
