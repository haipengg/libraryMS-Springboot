package com.ibm.config;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.ibm.domain.BorrowingDetails;
import com.ibm.service.BorrowService;

/**
 * 
 * @author:吕守淼
 * @Description:定时任务
 */
@Configuration
@EnableScheduling
public class ScheduleTask {

	@Autowired
	BorrowService borrowService;

	/**
	 * @Description 定时任务，每天0点进行一次修改借阅剩余有效期
	 */
	@Scheduled(cron = "59 2 0 * * ?")    
	public void updateValidTime() {
		System.out.println("111111111");
		Executors.newSingleThreadExecutor().execute(() -> {
			List<BorrowingDetails> selectAllBorrowDetails = this.borrowService.selectAll();
			Iterator<BorrowingDetails> iterator = selectAllBorrowDetails.iterator();
			while (iterator.hasNext()) {
				BorrowingDetails borrowDetails = iterator.next();
				borrowDetails.setValidTime(borrowDetails.getValidTime() - 1);
				this.borrowService.update(borrowDetails);
			}
			System.gc();
		});
	}
}
