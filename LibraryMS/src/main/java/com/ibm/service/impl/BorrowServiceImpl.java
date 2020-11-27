package com.ibm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Book;
import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.mapper.BorrowMapper;
import com.ibm.service.BorrowService;
import com.ibm.utils.DateConversion;

/**
 * 
 * @author:刘志勇
 * @Description:借阅信息服务层的实现类
 */
@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowMapper borrowMapper;

	@Override
	public Integer getBorrowCountByDay() {
		Date day = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		return borrowMapper.getCountByDay(1, ft.format(day));
	}

	@Override
	public Integer getReturnCountByDay() {
		Date day = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		return borrowMapper.getCountByDay(2, ft.format(day));
	}

	@Override
	public Integer getBorrowCountByMon() {
		Date mon = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM");
		return borrowMapper.getCountByMon(1, ft.format(mon));
	}

	@Override
	public Integer getReturnCountByMon() {
		Date mon = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM");
		return borrowMapper.getCountByMon(2, ft.format(mon));
	}

	@Override
	public Integer getBorrowCountByYear() {
		Date year = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy");
		return borrowMapper.getCountByYear(1, ft.format(year));
	}

	@Override
	public Integer getReturnCountByYear() {
		Date year = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy");
		return borrowMapper.getCountByYear(2, ft.format(year));
	}
	
	@Override
	public BorrowingDetails getBorrowById(Integer borrowId) {
		return this.borrowMapper.getBorrowById(borrowId);
	}

	@Override
	public void save(BorrowingDetails borrow) {
		borrowMapper.save(borrow);
	}

	@Override
	public void deleteById(Integer uid, Integer bid) {
		borrowMapper.deleteById(uid, bid);
	}

	@Override
	public void update(BorrowingDetails borrow) {
		borrowMapper.update(borrow);
	}

	@Override
	public void updateStatesById(Date reTime, Integer borrowId) {
		borrowMapper.updateStatesById(reTime, borrowId);
	}

	@Override
	public BorrowingDetails selectByBookIdAndUserId(BorrowingDetails borrowingDetails) {
		BorrowingDetails borrow = this.borrowMapper.selectByBookIdAndUserId(borrowingDetails);
		return borrow;
	}

	@Override
	public void saveBorrowRecords(int userId, int bookId) {
		BorrowingDetails borrowingDetails = new BorrowingDetails();
		User user = new User();
		user.setUserId(userId);
		Book book = new Book();
		book.setBookId(bookId);

		borrowingDetails.setUser(user);
		borrowingDetails.setBook(book);
		borrowingDetails.setBorrowStates(1);
		borrowingDetails.setBorrowTime(new Date());
		borrowingDetails.setDeadline(DateConversion.stepDay(new Date(), 30));
		borrowingDetails.setValidTime(30);
		this.borrowMapper.save(borrowingDetails);
	}

	@Override
	public List<BorrowingDetails> selectBorrowsByUserId(Integer id) {
		List<BorrowingDetails> borrows = this.borrowMapper.selectBorrowsByBookId(id);
		return borrows;
	}

	@Override
	public List<BorrowingDetails> selectAll() {
		return borrowMapper.selectAll();
	}

	@Override
	public List<BorrowingDetails> selectByKey(Integer userId, String key) {
		return borrowMapper.selectByKey(userId, key);
	}

}
