package org.test.service;

import org.springframework.stereotype.Service;
import org.test.entity.Resultmsg;

@Service
public interface UserService {
	/**
	 * 添加用户*
	 * @param username
	 * @param userage
	 * @param usersex
	 * @param userIdcard
	 * @param usertelep
	 * @param useraddress
	 * @return
	 */
	public Resultmsg UserAdd(String username,String userage,String usersex,String userIdcard,String usertelep,String useraddress);
	
	/**
	 * 用户信息查询*
	 * @param queryinfo
	 * @return
	 */
	public Resultmsg QueryUser(String queryinfo);
	
	/**
	 * *
	 * @param telep
	 * @param address
	 * @param idCard
	 * @return
	 */
	public Resultmsg UpdateUserInfo(String telep,String address,String idCard);
	
}
