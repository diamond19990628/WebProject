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
		Admin ad = cld.checklog(admin);
		Resultmsg result = new Resultmsg();
		if(ad!=null){
			result.setStatus("0");
			String level = cld.checklevel(admin);
			System.out.println(level);
			result.setData(level);
			result.setMsg("yes");
			
		}else{
			result.setStatus("1");
			result.setMsg("用户名或密码错误");
		}
		return result;
	}
	
}
