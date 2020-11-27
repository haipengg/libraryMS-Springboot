package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Country;

/**
 * 
 * @author:刘志勇
 * @Description:国家的SQL操作
 */
public interface CountryMapper {

	public List<Country> selectAll();

	public Country getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Country country);

	public void update(Country country);

	public void deleteById(Integer id);

}
