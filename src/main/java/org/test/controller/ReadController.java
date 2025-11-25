package org.test.controller;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Resultmsg;
import org.test.service.AdminIndexServiceImpl;

@Controller
public class ReadController {
	@Resource
	AdminIndexServiceImpl ursi;
	//用户查询
	@RequestMapping("/UserRead.do")
	@ResponseBody
	public Resultmsg getResult(){
		Resultmsg rm = ursi.UserRead();
		return rm;
	}
	//分页查询
	@RequestMapping("/UserReadPage.do")
	@ResponseBody
	public Resultmsg getResultPage(Integer currentPage){
		Resultmsg rm = ursi.getReadPage(currentPage);
		return rm;
	}
	//角色信息查询
	@RequestMapping("/UserInfoFind.do")
	@ResponseBody
	public Resultmsg UserInfoFind(String username){
		Resultmsg rm = ursi.UserInfoRead(username);
		return rm;
		
	}
	//角色信息修改
	@RequestMapping("/UserInfoUpdate.do")
	@ResponseBody
	public Resultmsg UserInfoUpdate(String age,String sex,String telep,String address,String username){
		Resultmsg rm = ursi.UserInfoUpdate(age, sex, telep, address, username);
		return rm;
	}
	//角色删除
	@RequestMapping("/Delete.do")
	@ResponseBody
	public Resultmsg Deleteshow(Integer id){
		Resultmsg rm = ursi.getDeleteMsg(id);
		return rm;
	}
	//注册角色信息
	@RequestMapping("/Register.do")
	@ResponseBody
	public Resultmsg toRegister(String username,String password,String levelInput,String telephone,Integer id){
		Resultmsg result = ursi.getResultmsg(username,password,levelInput,telephone,id);
		return result;
	}
	//添加时的角色信息查询
	@RequestMapping("/RegisterRead.do")
	@ResponseBody
	public Resultmsg toUserRead(String username,String id){
		Resultmsg rm = ursi.getReadUsername(username,id);
		return rm;
	}
	//角色级别和联系方式修改
	@RequestMapping("/Update.do")
	@ResponseBody
	public Resultmsg getUpdateResultMsg(Integer userid,String username,String level,String tel){
		Resultmsg rt = ursi.Updateservice(userid, username, level, tel);
		return rt;
	}
	//旧密码查询
	@RequestMapping("/ReadPassword.do")
	@ResponseBody
	public Resultmsg ReadPass(String OldPassword,String username){
		Resultmsg rm = null;
		try {
			rm = ursi.ReadPassword(username, OldPassword);
			return rm;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rm;
		
	}
	//密码修改
	@RequestMapping("/UpdatePass.do")
	@ResponseBody
	public Resultmsg UpdatePass(String password,String username){
		try {
			Resultmsg rm = ursi.getUpdatePass(username, password);
			return rm;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
