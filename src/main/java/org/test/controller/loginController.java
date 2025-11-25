package org.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Resultmsg;
import org.test.service.checklogserviceimpl;
@Controller
public class loginController {
	@Resource
	checklogserviceimpl clsi;
	
	@RequestMapping("/tolog.do")
	public String getString(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Resultmsg tolog(String username,String password){
		Resultmsg result = clsi.getresultmsg(username, password);
		return result;
	}
	@RequestMapping("/toindex.do")
	public String toindex(){
		return "index";
	}
	@RequestMapping("AdminFind.do")
	@ResponseBody
	public Resultmsg AdminFind(String username){
		Resultmsg rm = clsi.getAdmin(username);
		return rm;
	}
}
