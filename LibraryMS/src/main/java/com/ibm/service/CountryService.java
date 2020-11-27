package com.ibm.service;

import java.util.List;

import com.ibm.domain.Country;

/**
 * 
 * @author:刘志勇
 * @Description:国家服务层
 */
public interface CountryService {

	public List<Country> selectAll();

	public Country getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Country country);

	public void update(Country country);

	public void deleteById(Integer id);

}
