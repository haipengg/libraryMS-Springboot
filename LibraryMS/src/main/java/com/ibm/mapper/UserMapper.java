package com.ibm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;

/**
 * 
 * @author:吕守淼
 * @Description:用户的ＳＱＬ操作
 */
public interface UserMapper {
	public User getUserByName(String name);//通过用户名获取用户
	
	public void saveUser(User user);//保存用户
	
	public void updateUser(User user);//更新用户
	
	public List<User> selectAllUser();//查询所有用户
	
	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int userId);//查询用户借阅详情

	public void deleteUser(int userId);//注销用户
	
	public List<User> selectUserListByVagueName(String vageName);//模糊查询用户
	
	public User getUserById(int id);//根据用户id获取用户信息

	public void updatePasswordByUserId(@Param("user") User user);//根据用户id修改密码
	
	public int getUserId();//获取用户登录的账号id

	public void updateUserBooksNumber(@Param("user") User user);//更新用户的已借图书量
}
