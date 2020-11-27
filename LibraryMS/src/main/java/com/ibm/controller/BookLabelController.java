package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Country;
import com.ibm.domain.Theme;
import com.ibm.domain.Type;
import com.ibm.service.CountryService;
import com.ibm.service.ThemeService;
import com.ibm.service.TypeService;

/**
 * 
 * @author:刘志勇
 * @Description:图书标签模块
 */
@RestController
public class BookLabelController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private ThemeService themeService;

	/**
	 * @Description 获取国家列表
	 * @return 国家列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/country/list")
	public List<Country> selectCountryList() {
		List<Country> countrys = countryService.selectAll();
		return countrys;
	}

	/**
	 * @Description 获取类型列表
	 * @return 类型列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/type/list")
	public List<Type> selectTypeList() {
		List<Type> types = typeService.selectAll();
		return types;
	}

	/**
	 * @Description 获取主题列表
	 * @return 主题列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/theme/list")
	public List<Theme> selectThemeList() {
		List<Theme> themes = themeService.selectAll();
		return themes;
	}

}
