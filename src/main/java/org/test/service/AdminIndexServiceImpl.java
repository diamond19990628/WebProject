package org.test.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.dao.AdminDao;
import org.test.entity.Admin;
import org.test.entity.Page;
import org.test.entity.Resultmsg;
import org.test.entity.UserInfo;
import org.test.utils.PasswordMd5;

@Service
@Transactional(value = "transactionManager", rollbackFor = java.lang.Exception.class)
public class AdminIndexServiceImpl implements AdminIndexService {
	@Resource
	AdminDao urd;
	@Resource
	PasswordMd5 pm5;
	public Resultmsg UserRead() {
		int rows = urd.UserCount();
		Page page = new Page();
		page.setRows(rows);
		List<Admin> adminListPage = urd.UserReadPage(page);
		List<Admin> UserList = urd.UserRead();
		Resultmsg rm = new Resultmsg();
		if (UserList == null) {
			rm.setData(adminListPage);
			rm.setStatus("1");
			rm.setMsg("error");
		} else {
			rm.setData(adminListPage);
			rm.setStatus("0");
			rm.setMsg("yes");
		}
		return rm;
	}
	//查看个人信息
	public Resultmsg UserInfoRead(String username) {
		UserInfo ui = urd.UserInfoFind(username);
		Resultmsg rm = new Resultmsg();
		if (ui == null) {
			rm.setStatus("1");
			rm.setMsg("没有找到相关数据");
			rm.setData(ui);
		} else {
			rm.setStatus("0");
			rm.setData(ui);
			rm.setMsg("找到该人信息");
		}
		return rm;
	}
	//个人信息修改
	public Resultmsg UserInfoUpdate(String age, String sex, String telep,
		String address, String username) {
		UserInfo ui = new UserInfo();
		ui.setAccount(username);
		ui.setAddress(address);
		ui.setAge(age);
		ui.setSex(sex);
		ui.setTelep(telep);
		Resultmsg rm = new Resultmsg();
		int i = urd.UserInfoUpdate(ui);
		int j = urd.UserAdminiUpdate(telep, username);
		if (i > 0 && j > 0) {
			rm.setStatus("0");
			rm.setMsg("修改成功");
		}
		return rm;

	}
	//角色删除
	public Resultmsg getDeleteMsg(Integer id) {

		String username = urd.UserNameRead(id);
		urd.UpdateUserInfo(username);
		int i = urd.DeleteUser(id);
		Resultmsg rm = new Resultmsg();
		if (i > 0) {
			rm.setStatus("0");
			rm.setMsg("yes");
		} else {
			rm.setStatus("1");
			rm.setMsg("no");
		}
		return rm;
	}
	//分页查询
	public Resultmsg getReadPage(Integer currentPage) {
		int rows = urd.UserCount();
		Page page = new Page();
		Page page2 = new Page();
		page2.setRows(rows);
		page.setRows(rows);
		page.setCurrentPage(currentPage);
		Integer TotalPage = page2.getTotalPage();
		List<Admin> adminListPage = urd.UserReadPage(page);
		Resultmsg rt = new Resultmsg();
		rt.setData(adminListPage);
		rt.setMsg("yes");
		rt.setCurrentPage(TotalPage);
		return rt;
	}
	public Resultmsg getResultmsg(String username,String password,String levelInput,String telephone,Integer id) {
		Admin ad = new Admin();
		ad.setUsername(username);
		ad.setLeve(levelInput);
		ad.setTelep(telephone);
		try {
			String pwd = PasswordMd5.getPasswordMd5(password);
			ad.setPassword(pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin = urd.UsernameRead(ad);
		UserInfo uifo = new UserInfo();
		uifo.setAccount(username);
		uifo.setId(id);
		urd.UserinfoAdd(uifo);
		Resultmsg resultmsg = new Resultmsg();
		resultmsg.setStatus("0");
		resultmsg.setMsg("用户名可以使用");
		resultmsg.setData(admin);
		urd.UserRegister(ad);
		return resultmsg;

	}
	public Resultmsg getReadUsername(String username,String id) {
		Admin ad = new Admin();
		ad.setUsername(username);
		//查询用户名是否存在
		Admin admin = urd.UsernameRead(ad);
		Resultmsg rt = new Resultmsg();
		//如果用户名不存在
		if(admin==null){
			//查询用户名是否被绑定过
			UserInfo userinfo = urd.AccountRead(username);
			//没被绑定
			if(userinfo==null){
				//查询是否有该员工
				UserInfo uInfo = urd.UserinfoRead1(id);
				//如果没找到该员工
				if(uInfo==null){
					rt.setMsg("未找到该员工");
					rt.setStatus("1");
					return rt;
				}else{
					if(uInfo.getAccount()==null){
						//帐号没有绑定过，且有该员工
						rt.setStatus("0");
						rt.setMsg("该帐号没被绑定过,并且有该员工,同时该员工也未绑定任何帐号");
						rt.setData(uInfo);
					}else{
						rt.setMsg("该帐号没被绑定过,但该员工已绑定了其他帐号");
						rt.setStatus("1");
					}
					return rt;
				}
			}
			else{
				rt.setStatus("1");
				rt.setMsg("该帐号已经被绑定过");
				return rt;
			}
		}else{
			rt.setStatus("1");
			rt.setMsg("用户名已存在");
			return rt;
		}
	}
	//修改个人信息
	public Resultmsg Updateservice(Integer id,String username,String level,String telep) {
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		ad.setId(id);
		ad.setLeve(level);
		ad.setUsername(username);
		ad.setTelep(telep);
		urd.UpdateUser(ad);
		UserInfo userinfo = urd.UserinfoRead2(username);
		Resultmsg rm = new Resultmsg();
		rm.setStatus("0");
		if(userinfo!=null){
			urd.UserinfoUpdate(telep, username);
			rm.setMsg("修改成功");
			return rm;
		}else{
			rm.setMsg("未找到该角色的个人信息");
			return rm;
		}
		
	}
	//旧密码查询
	public Resultmsg ReadPassword(String username,String password) throws NoSuchAlgorithmException{
		String OldPass1 = urd.PasswordRead(username);
		Resultmsg rm = new Resultmsg();
		String OldPass2 = PasswordMd5.getPasswordMd5(password);
		if(OldPass1.equals(OldPass2)){
			rm.setMsg("yes");
			rm.setData(OldPass2);
			rm.setStatus("0");
		}else{
			rm.setMsg("no");
			rm.setStatus("1");
		}
		return rm;
	
	}
	//密码修改
	public Resultmsg getUpdatePass(String username,String password) throws NoSuchAlgorithmException{
		String pwd = PasswordMd5.getPasswordMd5(password);
		Admin ad = new Admin();
		ad.setPassword(pwd);
		ad.setUsername(username);
		urd.UpdatePass(ad);
		Resultmsg rm = new Resultmsg();
		rm.setStatus("0");
		rm.setMsg("修改成功");
		return rm;
	}

}
