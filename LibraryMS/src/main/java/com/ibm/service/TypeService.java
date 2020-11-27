package com.ibm.service;

import java.util.List;

import com.ibm.domain.Type;

/**
 * 
 * @author:刘志勇
 * @Description:图书类型服务层
 */
public interface TypeService {

	public List<Type> selectAll();

	public Type getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Type type);

	public void update(Type type);

	public void deleteById(Integer id);

}
