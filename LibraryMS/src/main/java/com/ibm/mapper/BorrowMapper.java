package com.ibm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.domain.BorrowingDetails;

/**
 * 
 * @author:刘志勇
 * @Description:借阅信息的SQL操作
 */
public interface BorrowMapper {

	// 查询所有借阅记录
	public List<BorrowingDetails> selectAll();

	// 根据关键字模糊查询用户借阅记录
	public List<BorrowingDetails> selectByKey(Integer userId, String key);

	// 根据参数进行今日借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByDay(Integer boOrRu, String day);

	// 根据参数进行本月借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByMon(Integer boOrRu, String mon);

	// 根据参数进行年度借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByYear(Integer boOrRu, String year);

	// 保存借阅记录
	public void save(@Param("borrow") BorrowingDetails borrow);

	// 根据ID删除借阅记录
	public void deleteById(Integer uid, Integer bid);

	// 更新借阅记录
	public void update(@Param("borrow") BorrowingDetails borrow);
	
	//根据ID修改借阅状态
	public void updateStatesById(Date reTime, Integer borrowId);
	
	// 根据ID查询借阅记录
	public BorrowingDetails getBorrowById(Integer borrowId);
	
	//查找借阅内容
	public BorrowingDetails selectByBookIdAndUserId(@Param("borrow") BorrowingDetails borrow);
	
	// 根据图书ID查询借阅记录
	public List<BorrowingDetails> selectBorrowsByBookId(Integer id);

}
