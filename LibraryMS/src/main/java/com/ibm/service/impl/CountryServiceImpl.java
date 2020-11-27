package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Country;
import com.ibm.mapper.CountryMapper;
import com.ibm.service.CountryService;

/**
 * 
 * @author:刘志勇
 * @Description:国家服务层的实现类
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryMapper countryMapper;

	@Override
	public List<Country> selectAll() {
		return countryMapper.selectAll();
	}

	@Override
	public Country getById(Integer id) {
		return countryMapper.getById(id);
	}

	@Override
	public Integer getIdByName(String name) {
		return countryMapper.getIdByName(name);
	}

	@Override
	public void save(Country country) {
		countryMapper.save(country);
	}

	@Override
	public void update(Country country) {
		countryMapper.update(country);
	}

	@Override
	public void deleteById(Integer id) {
		countryMapper.deleteById(id);
	}

}
