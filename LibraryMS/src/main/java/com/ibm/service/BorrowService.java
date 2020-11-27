package com.ibm.service;

import java.util.Date;
import java.util.List;

import com.ibm.domain.BorrowingDetails;

/**
 * 
 * @author:刘志勇
 * @Description:借阅信息服务层
 */
public interface BorrowService {

	public List<BorrowingDetails> selectAll();

	public List<BorrowingDetails> selectByKey(Integer userId, String key);

	public Integer getBorrowCountByDay();

	public Integer getReturnCountByDay();

	public Integer getBorrowCountByMon();

	public Integer getReturnCountByMon();

	public Integer getBorrowCountByYear();

	public Integer getReturnCountByYear();
	
	public BorrowingDetails getBorrowById(Integer borrowId);

	public void save(BorrowingDetails borrow);

	public void deleteById(Integer uid, Integer bid);

	public void update(BorrowingDetails borrow);
	
	public void updateStatesById(Date reTime, Integer borrowId);

	public BorrowingDetails selectByBookIdAndUserId(BorrowingDetails borrowingDetails);

	public void saveBorrowRecords(int userId, int bookId);

	public List<BorrowingDetails> selectBorrowsByUserId(Integer id);
}
