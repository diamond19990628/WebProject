package org.test.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.dao.UserDao;
import org.test.entity.Resultmsg;
import org.test.entity.User;
import org.test.entity.UserPreductInfo;
@Service
@Transactional(value = "transactionManager", rollbackFor = java.lang.Exception.class)
public class UserServiceImpl implements UserService{
	@Resource
	UserDao uDao;
	//添加用户
	public Resultmsg UserAdd(String username, String userage, String usersex,
			String userIdcard, String usertelep, String useraddress) {
		User u = uDao.UserFind(userIdcard);
		Resultmsg rm = new Resultmsg();
		if(u==null){
			rm.setStatus("0");
			User user = new User();
			user.setUsername(username);
			user.setAge(userage);
			user.setSex(usersex);
			user.setIdCard(userIdcard);
			user.setTelep(usertelep);
			user.setAddress(useraddress);
			uDao.UserAdd(user);
			rm.setMsg("用户添加成功");
		}else{
			rm.setStatus("1");
			rm.setMsg("该身份证已注册过");
		}
		return rm;
		
		
	}
	//用户通过身份证进行信息查询
	public Resultmsg QueryUser(String queryinfo) {
		Resultmsg rm = new Resultmsg();
		if(queryinfo.length()==15||queryinfo.length()==18){
			List<Map<String,String>> userinfo = uDao.queryUserByIdCard(queryinfo);
			if(userinfo.isEmpty()){
				User user = uDao.UserInfoFindById(queryinfo);
				if(user==null){
					rm.setStatus("1");
					rm.setMsg("没有查询到数据");
				}else{
					rm.setStatus("2");
					rm.setData(user);
				}
			}else{
				rm.setData(userinfo);
				rm.setMsg("已找到该用户信息");
				rm.setStatus("0");
			}
		}
		//通过手机号进行业务查询
		else if(queryinfo.length()==11){
			List<UserPreductInfo> uPreInfo = uDao.queryUserByPhone(queryinfo);
			if(uPreInfo.isEmpty()){
				rm.setStatus("1");
				rm.setMsg("该用户还未办理过业务");
			}else{
				rm.setData(uPreInfo);
				rm.setStatus("0");
			}
		}
		return rm;
	}
	//用户信息修改
	public Resultmsg UpdateUserInfo(String idCard, String telep, String address) {
		Resultmsg rm = new Resultmsg();
		uDao.UpdateUserInfo(telep, address, idCard);
		rm.setStatus("0");
		rm.setMsg("修改成功");
		return rm;
	}
}
