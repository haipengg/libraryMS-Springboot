package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Type;
import com.ibm.mapper.TypeMapper;
import com.ibm.service.TypeService;

/**
 * 
 * @author:刘志勇
 * @Description:图书类型服务层的实现类
 */
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Override
	public List<Type> selectAll() {
		return typeMapper.selectAll();
	}

	@Override
	public Type getById(Integer id) {
		return typeMapper.getById(id);
	}

	@Override
	public Integer getIdByName(String name) {
		return typeMapper.getIdByName(name);
	}

	@Override
	public void save(Type type) {
		typeMapper.save(type);
	}

	@Override
	public void update(Type type) {
		typeMapper.update(type);
	}

	@Override
	public void deleteById(Integer id) {
		typeMapper.deleteById(id);
	}

}
