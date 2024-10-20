package org.test.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.test.dao.RegisterDao;
import org.test.entity.Admin;
import org.test.entity.Resultmsg;
import org.test.utils.PasswordMd5;
@Service
public class RegisterServiceimpl implements RegisterService{
	@Resource
	RegisterDao registerDao;
	@Resource
	Resultmsg resultmsg;
	@Resource
	PasswordMd5 pm5;
	public Resultmsg getResultmsg(String username,String password) {
		Admin ad = new Admin();
		ad.setUsername(username);
		try {
			String pwd = pm5.getPasswordMd5(password);
			ad.setPassword(pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin = registerDao.UsernameRead(ad);
		System.out.println(admin);
		if(admin==null){
			resultmsg.setStatus("0");
			resultmsg.setMsg("用户名可以使用");
			resultmsg.setData("haha");
			registerDao.UserRegister(ad);
		}else{
			resultmsg.setStatus("1");
			resultmsg.setMsg("用户名已存在");
			resultmsg.setData(admin);
		}
		return resultmsg;
	}

}
