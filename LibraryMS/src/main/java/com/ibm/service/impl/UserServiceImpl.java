package com.ibm.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.mapper.BookMapper;
import com.ibm.mapper.UserMapper;
import com.ibm.service.UserService;
import com.ibm.vo.MyBookShelves;

/**
 * 
 * @author:吕守淼
 * @Description:用户服务层的实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	BookMapper bookMapper;

	@Override
	public User getUserByName(String name) {
		User user = this.userMapper.getUserByName(name);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		Md5Hash md5Hash = new Md5Hash(user.getPassword(),user.getSalt());
		user.setPassword(md5Hash.toString());
		this.userMapper.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		Md5Hash md5Hash = new Md5Hash(user.getPassword(),user.getSalt());
		user.setPassword(md5Hash.toString());
		this.userMapper.updateUser(user);
	}

	@Override
	public List<User> selectUserListByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> selectUserByPage = this.userMapper.selectAllUser();
		return selectUserByPage;
	}

	@Override
	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int userId) {
		List<BorrowingDetails> borrowHistory = this.userMapper.selectBorrowingDetailsByUserId(userId);
		return borrowHistory;
	}

	@Override
	public void deleteUser(int userId) {
		this.userMapper.deleteUser(userId);

	}

	@Override
	public List<User> selectUserListByVagueName(String vageName) {
		List<User> selectUserListByVagueName = this.userMapper.selectUserListByVagueName(vageName);
		return selectUserListByVagueName;
	}

	public List<User> selectAllUser() {
		List<User> selectAllUser = this.userMapper.selectAllUser();
		return selectAllUser;
	}

	@Override
	public User getUserById(int id) {
		User user = this.userMapper.getUserById(id);
		return user;
	}

	@Override
	public void updatePasswordByUserId(String password, int userId) {
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		this.userMapper.updatePasswordByUserId(user);
		
	}

	@Override
	public List<MyBookShelves> selectShelves(int userId) {
		List<MyBookShelves> myShelves = this.bookMapper.selectShelves(userId);
		return myShelves;
	}

	@Override
	public int getUserId() {
		int userId = this.userMapper.getUserId();
		return userId;
	}

	@Override
	public void updateUserBooksNumber(User user) {
		this.userMapper.updateUserBooksNumber(user);
		
	}

}
