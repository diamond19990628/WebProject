package org.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Admin;
import org.test.entity.Resultmsg;
import org.test.service.RegisterServiceimpl;

@Controller
public class RegisterController {
	@Resource
	RegisterServiceimpl rs;
	@RequestMapping("/Register.do")
	@ResponseBody
	public Resultmsg toRegister(String username,String password){
		Resultmsg result = rs.getResultmsg(username,password);
		System.out.println(result);
		return result;
	}
}
