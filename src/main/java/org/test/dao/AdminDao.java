package org.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.test.entity.Admin;
import org.test.entity.Page;
import org.test.entity.UserInfo;

@Repository
public interface AdminDao {
	public List<Admin> UserRead();
	
	public List<Admin> UserReadPage(Page page);
	public int UserCount();
	
	public UserInfo UserInfoFind(String username);
	
	public int UserInfoUpdate(UserInfo ui);
	
	public int UserAdminiUpdate(String telep,String username);
	
	public int DeleteUser(Integer id);
	
	public String UserNameRead(Integer id);
	
	public void UpdateUserInfo(String username);
	
	public String PasswordRead(String username);
	
	public void UpdatePass(Admin admin);
	
	//添加用户
	public void UserRegister(Admin admin);
	//自己角色查询
	public Admin UsernameRead(Admin admin);
	//角色个人信息查询
	public UserInfo AccountRead(String account);
	
	public UserInfo UserinfoRead1(String id);
	
	public void UserinfoAdd(UserInfo userinfo);
	
	public void UpdateUser(Admin admin);
	
	public void UserinfoUpdate(String telep,String username);
	
	public UserInfo UserinfoRead2(String username);
}
