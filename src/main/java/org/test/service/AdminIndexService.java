package org.test.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import org.test.entity.Resultmsg;

@Service
public interface AdminIndexService {
	
	/**
	 * 用户查询*
	 */
	public Resultmsg UserRead();
	
	/**
	 * 个人信息查询*
	 * @param name
	 * @return
	 */
	public Resultmsg UserInfoRead(String name);
	
	/**
	 * 个人信息员工表修改*
	 * @param age
	 * @param sex
	 * @param telep
	 * @param address
	 * @param username
	 * @return
	 */
	public Resultmsg UserInfoUpdate(String age, String sex, String telep,
			String address, String username);
	
	/**
	 * 角色信息删除*
	 * @param id
	 * @return
	 */
	public Resultmsg getDeleteMsg(Integer id);
	//分页查询
	public Resultmsg getReadPage(Integer currentPage);
	
	/**
	 * 匹配都通过后对数据的修改*
	 * @param username
	 * @param password
	 * @param levelInput
	 * @param telep
	 * @param name
	 * @return
	 */
	public Resultmsg getResultmsg(String username,String password,String levelInput,String telep,Integer id);
	
	
	/**
	 * *
	 * 查看用户名是否匹配
	 * @param username
	 * @param name
	 * @return
	 */
	public Resultmsg getReadUsername(String username,String id);
	
	
	/**
	 * 用户信息修改*
	 * @param id
	 * @param username
	 * @param level
	 * @param telep
	 * @return
	 */
	public Resultmsg Updateservice(Integer id,String username,String level,String telep);
	
	/**
	 * 修改密码之密码查询*
	 * @param username
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public Resultmsg ReadPassword(String username,String password)throws NoSuchAlgorithmException;
	
	/**
	 * 修改密码之密码修改*
	 * @param username
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public Resultmsg getUpdatePass(String username,String password)throws NoSuchAlgorithmException;
}
