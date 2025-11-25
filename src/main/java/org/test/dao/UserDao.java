package org.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.test.entity.User;
import org.test.entity.UserPreductInfo;

@Repository
public interface UserDao {
	public User UserFind(String idCard);
	
	public void UserAdd(User user);
	
	public List<Map<String,String>> queryUserByIdCard(String idcard);
	
	public User UserInfoFindById(String idcard);
	
	public List<UserPreductInfo> queryUserByPhone(String phone);
	
	public void UpdateUserInfo(String telep,String address,String idCard);
	
	public void PreductRead();
}
