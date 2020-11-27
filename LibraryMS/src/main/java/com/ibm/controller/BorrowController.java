package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.BorrowingDetails;
import com.ibm.service.BorrowService;

/**
 * 
 * @author:刘志勇
 * @Description:借阅信息模块
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	/**
	 * @Description 获取借阅记录列表
	 * @param
	 * @return 借阅记录列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list")
	public List<BorrowingDetails> selectBorrowList() {
		List<BorrowingDetails> borrows = borrowService.selectAll();
		return borrows;
	}

	/**
	 * @Description 根据关键字模糊查询对应借阅记录
	 * @param 关键字
	 * @return 对应的借阅记录列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list/key")
	public List<BorrowingDetails> selectBorrowListByKey(Integer userId, String key) {
		List<BorrowingDetails> borrows = borrowService.selectByKey(userId, key);
		return borrows;
	}

	/**
	 * @Description 获取借阅统计数据
	 * @return 借阅统计数据
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/statistics")
	public int[] selectBorrowStatist() {
		int st[] = new int[6];
		st[0] = borrowService.getBorrowCountByDay();
		st[1] = borrowService.getReturnCountByDay();
		st[2] = borrowService.getBorrowCountByMon();
		st[3] = borrowService.getReturnCountByMon();
		st[4] = borrowService.getBorrowCountByYear();
		st[5] = borrowService.getReturnCountByYear();
		return st;
	}

	/**
	 * @Description 添加借阅记录
	 * @param 新的借阅记录
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/add")
	public String addBorrow(@RequestBody BorrowingDetails borrow) {
		borrowService.save(borrow);
		return "添加成功";
	}

	/**
	 * @Description 修改借阅记录
	 * @param 更新后的借阅记录
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/update")
	public String updateBorrow(@RequestBody BorrowingDetails borrow) {
		borrowService.update(borrow);
		return "更新成功";
	}

	/**
	 * @Description 根据用户ID和图书ID删除对应借阅记录
	 * @param userId:用户ID bookId:图书ID
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/delete")
	public String deleteBorrow(Integer userId, Integer bookId) {
		borrowService.deleteById(userId, bookId);
		return "删除成功";
	}

}
