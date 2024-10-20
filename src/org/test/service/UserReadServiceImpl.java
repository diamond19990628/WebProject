package org.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.test.dao.UserReadDao;
import org.test.entity.Admin;
import org.test.entity.Page;
import org.test.entity.Resultmsg;
@Service
public class UserReadServiceImpl implements UserReadService {
	@Resource
	UserReadDao urd;
	public Resultmsg UserRead() {
		int rows = urd.UserCount();
		Page page = new Page();
		page.setRows(rows);
		List<Admin> adminListPage = urd.UserReadPage(page);
		List<Admin> UserList = urd.UserRead();
		
		Resultmsg rm = new Resultmsg();
		if(UserList==null){
			rm.setData(adminListPage);
			rm.setStatus("1");
			rm.setMsg("error");
		}else{
			rm.setData(adminListPage);
			rm.setStatus("0");
			rm.setMsg("yes");
		}
		return rm;
	}

}
