package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Type;

/**
 * 
 * @author:刘志勇
 * @Description:图书类型的SQL操作
 */
public interface TypeMapper {

	public List<Type> selectAll();

	public Type getById(Integer id);

	public Integer getIdByName(String name);

	public void save(Type type);

	public void update(Type type);

	public void deleteById(Integer id);

}
