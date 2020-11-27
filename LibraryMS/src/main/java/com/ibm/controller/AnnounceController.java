package com.ibm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Announce;
import com.ibm.service.AnnounceService;

/**
 * 
 * @author:邱海鹏
 * @Description:公告栏的删查改
 */
@RestController
@RequestMapping("/announce")
public class AnnounceController {
	
	@Autowired
	private AnnounceService announceService;
	
	
	/**
	 * @Description 获取公告信息
	 * @param
	 * @return 公告信息
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list")
	public Announce getAnnounce() {
		return announceService.getAnnounce();
	}
	
	/**
	 * @Description 删除公告信息
	 * @return 
	 * @return 图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/delete")
	public String deleteAnnounce() {
		announceService.deleteAnnounce();
		return "删除成功";
	}
	
	/**
	 * @Description 更新公告信息
	 * @param
	 * @return 图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/update")
	public String updateAnounce(@RequestBody Announce announce) {
		announce.setAnnounceTime(new Date());
		announceService.updateAnnounce(announce);
		return "修改成功";
	}
	
	
	
	

}
