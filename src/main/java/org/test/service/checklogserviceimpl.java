package org.test.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.test.dao.checklogDao;
import org.test.entity.Admin;
import org.test.entity.Resultmsg;
import org.test.utils.PasswordMd5;
@Service
public class checklogserviceimpl implements checklog{
	@Resource
	checklogDao cld;
	@Resource
	HttpServletRequest req;
	public Resultmsg getresultmsg(String username, String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		try {
			String pwd = PasswordMd5.getPasswordMd5(password);
			admin.setPassword(pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Resultmsg result = new Resultmsg();
		//匹配用户名和密码
		Admin ad = cld.checklog(admin);
		//如果正确
		if(ad!=null){
			String status = cld.StatusRead(admin);
			//检查是否是登录状态
			if(status.equals("1")){
				result.setStatus("2");
			}else{
				cld.changestatus(username);
				result.setStatus("0");
				result.setData(ad);
			}
		}else{
			result.setStatus("1");
			result.setMsg("用户名或密码错误");
		}
		return result;
	}
	public Resultmsg getAdmin(String username){
		Admin ad = cld.getAdmin(username);
		Resultmsg rm = new Resultmsg();
		rm.setData(ad);
		rm.setStatus("0");
		return rm;
	}
	
}
