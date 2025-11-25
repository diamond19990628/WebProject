package org.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Resultmsg;
import org.test.service.PreductServiceImpl;
@Controller
public class PreductController {
	@Resource
	PreductServiceImpl pService;
	@RequestMapping("/PreductRead.do")
	@ResponseBody
	public Resultmsg PreductRead(String begin,String end){
		Resultmsg rm = pService.PreductRead(begin,end);
		return rm;
	}
	@RequestMapping("/PreductReadMath.do")
	@ResponseBody
	public Resultmsg PreductReadMath(){
		Resultmsg rm = pService.PreductReadMath();
		return rm;
	}
	@RequestMapping("/PreductShow.do")
	@ResponseBody
	public Resultmsg PreductShow(String uname,String uIdcard,String userphone,String ubasic,String amount,String pre){
		Resultmsg rm = pService.PreductShow(uname, uIdcard, userphone, ubasic, amount);
		return rm;
	}
	@RequestMapping("/TelepUpdate.do")
	@ResponseBody
	public Resultmsg TelepUpdate(String Phone,String idcard){
		Resultmsg rm = pService.TelepUpdate(Phone, idcard);
		System.out.println(rm);
		return rm;
	}
	@RequestMapping("/phoneStatusUpdate1.do")
	@ResponseBody
	public Resultmsg phoneStatusUpdate1(String phone){
		Resultmsg rm = pService.phoneStatusUpdate1(phone);
		return rm;
	}
	@RequestMapping("/phoneStatusUpdate2.do")
	@ResponseBody
	public Resultmsg phoneStatusUpdate2(String phone){
		Resultmsg rm = pService.phoneStatusUpdate2(phone);
		return rm;
	}
	@RequestMapping("/KDPreductRead.do")
	@ResponseBody
	public Resultmsg KDPreductRead(){
		Resultmsg rm = pService.KDPreductRead();
		return rm;
	}
	@RequestMapping("/TelInfoRead.do")
	@ResponseBody
	public Resultmsg TelInfoRead(String uname,String idcard,String userphone,String KDSpeed,String kfy,String SAddress){
		Resultmsg rm = pService.TelInfoRead(uname, idcard, userphone, KDSpeed, kfy, SAddress);
		return rm;
	}
}
