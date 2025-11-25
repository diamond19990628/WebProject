package org.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Resultmsg;
import org.test.service.UserServiceImpl;
@Controller
public class UserController {
	@Resource
	UserServiceImpl usi;
	@RequestMapping("/UserAdd.do")
	@ResponseBody
	public Resultmsg UserAdd(String username,String userage,String usersex,String userIdcard,String usertelep,String useraddress){
		Resultmsg rm = usi.UserAdd(username, userage, usersex, userIdcard, usertelep, useraddress);
		return rm;
	}
	//用户查询
	@RequestMapping("/QueryUser.do")
	@ResponseBody
	public Resultmsg queryUser(String queryinfo){
		Resultmsg rm = usi.QueryUser(queryinfo);
		return rm;
	}
	@RequestMapping("/UpdateUserInfo.do")
	@ResponseBody
	public Resultmsg UpdateUserInfo(String idCard,String telep,String address){
		Resultmsg rm =	usi.UpdateUserInfo(idCard, telep, address);
		return rm;
	}
}
