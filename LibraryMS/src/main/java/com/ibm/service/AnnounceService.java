package com.ibm.service;

import com.ibm.domain.Announce;

/**
 * 
 * @author:邱海鹏
 * @Description:公告栏服务层
 */
public interface AnnounceService {
	public Announce getAnnounce();
	
	public void deleteAnnounce();
	
	public void updateAnnounce(Announce announce);

}
