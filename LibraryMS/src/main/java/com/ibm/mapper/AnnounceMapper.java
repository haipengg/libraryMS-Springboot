package com.ibm.mapper;

import com.ibm.domain.Announce;

/**
 * 
 * @author:刘志勇
 * @Description:公告栏的SQL操作
 */
public interface AnnounceMapper {
	
	//查询通知
	public Announce getAnnounce();
	
	//删除通知
	public void deleteAnnounce();
	
	//更改通知
	public void updateAnnounce(Announce announce);
	

}
