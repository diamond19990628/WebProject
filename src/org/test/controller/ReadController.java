package org.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Resultmsg;
import org.test.service.UserReadPageImpl;
import org.test.service.UserReadServiceImpl;

@Controller
public class ReadController {
	@Resource
	UserReadServiceImpl ursi;
	@Resource
	UserReadPageImpl urpi;
	@RequestMapping("/UserRead.do")
	@ResponseBody
	public Resultmsg getResult(){
		Resultmsg rm = ursi.UserRead();
		return rm;
	}
	@RequestMapping("/UserReadPage.do")
	@ResponseBody
	public Resultmsg getResultPage(Integer currentPage){
		Resultmsg rm = urpi.getReadPage(currentPage);
		return rm;
	}
}
